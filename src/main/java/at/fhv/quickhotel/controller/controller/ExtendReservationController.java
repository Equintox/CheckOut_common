package at.fhv.quickhotel.controller.controller;

import at.fhv.quickhotel.controller.controller.controllerinterface.ICategoryAvailableController;
import at.fhv.quickhotel.controller.controller.controllerinterface.IExtendReservationController;
import at.fhv.quickhotel.controller.controller.controllerinterface.IExtendRoomController;
import at.fhv.quickhotel.controller.controller.controllerinterface.IUpdateReservationController;
import at.fhv.quickhotel.controller.controller.exceptions.ReservationExtensionNotPossibleException;
import at.fhv.quickhotel.domain.CategoryAvailableContainer;
import at.fhv.quickhotel.domain.modelInterface.ICategoryAvailableContainer;
import at.fhv.quickhotel.domain.modelInterface.IReservation;
import at.fhv.quickhotel.domain.modelInterface.IReservationUnit;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ExtendReservationController implements IExtendReservationController {

    private IReservation reservation;
    private IExtendRoomController extendRoomController;
    private IUpdateReservationController updateReservationController;


    //key: reservationUnitId, value: newDepartureDate
    private Map<Integer, LocalDate> extendedUnitMap;



    public ExtendReservationController(IReservation reservation
            , IExtendRoomController extendRoomController
            , IUpdateReservationController updateReservationController){
        this.reservation = reservation;
        this.extendRoomController = extendRoomController;
        this.updateReservationController = updateReservationController;

        extendedUnitMap = new HashMap<>();
    }

    @Override
    public boolean isReservationUnitExtensionPossible(int reservationUnitId, LocalDate departureDate) {

        List<? extends IReservationUnit> reservationUnits = reservation.getReservationUnits();
        for(IReservationUnit unit : reservationUnits){
            if(unit.getReservationUnitId() == reservationUnitId){

                //check if extension is possible
                return extendRoomController.isExtensionPossible(unit.getRoom(), unit.getDepartureDate(), departureDate);
            }
        }
        return false;
    }

    @Override
    public boolean extendReservationUnit(int reservationUnitId, LocalDate departureDate) {

        if(!isReservationUnitExtensionPossible(reservationUnitId, departureDate))
            return false;

        List<? extends IReservationUnit> reservationUnits = reservation.getReservationUnits();
        for(IReservationUnit unit : reservationUnits){
            if((unit.getReservationUnitId() == reservationUnitId) && !(unit.getDepartureDate().equals(departureDate))){
                //set new departure date
                extendedUnitMap.put(reservationUnitId, departureDate);
                return true;
            }
        }
        return false;
    }

    @Override
    public void updateReservation() throws ReservationExtensionNotPossibleException {

        ICategoryAvailableController categoryAvailableController = CategoryAvailableController.getInstance();

        List<ICategoryAvailableContainer> categoryAvailableContainers = new LinkedList<>();

        reservation.getReservationUnits().forEach(unit -> {
            if(extendedUnitMap.get(unit.getReservationUnitId())!= null) {     //new departuredate was requested
                System.out.println("new date detected");

                ICategoryAvailableContainer container = new CategoryAvailableContainer();
                container.setStartDate(unit.getArrivalDate());
                container.setEndDate(extendedUnitMap.get(unit.getReservationUnitId()));
                container.setRoomCategoryId(unit.getRoomCategory().getRoomCategoryID());
                categoryAvailableContainers.add(container);
            }
        });

        if(categoryAvailableContainers.size() > 0) {
            if (!categoryAvailableController.checkRoomAvailable(categoryAvailableContainers)) {
                throw new ReservationExtensionNotPossibleException();
            }

            //Set new Departure Dates
            for(IReservationUnit unit : reservation.getReservationUnits()){
                if(extendedUnitMap.get(unit.getReservationUnitId()) != null){
                    LocalDate oldDate = extendedUnitMap.get(unit.getReservationUnitId());
                    LocalDate newDate = LocalDate.of(oldDate.getYear(), oldDate.getMonth(), oldDate.getDayOfMonth());

                    unit.setNewDepartureDate(newDate);
                    System.out.println("new departureDate set: " + newDate);
                }
            }
            updateReservationController.updateReservation(reservation);
        }
    }
}
