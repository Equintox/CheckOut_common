package at.fhv.quickhotel.controller.controller;

import at.fhv.quickhotel.controller.controller.controllerinterface.ICheckoutReservationController;
import at.fhv.quickhotel.controller.controller.controllerinterface.IRoomController;
import at.fhv.quickhotel.controller.controller.controllerinterface.IUpdateReservationController;
import at.fhv.quickhotel.controller.supplier.supplierInterface.IReservationSupplier;
import at.fhv.quickhotel.domain.modelInterface.IReservation;
import at.fhv.quickhotel.domain.modelInterface.IReservationUnit;
import at.fhv.quickhotel.domain.modelInterface.IRoom;
import at.fhv.quickhotel.domain.modelInterface.IRoomAssignment;

import java.util.List;

public class CheckoutController implements ICheckoutReservationController {

    IReservationSupplier reservationSupplier;
    IUpdateReservationController updateReservationController;
    IRoomController roomController;

    public CheckoutController(IReservationSupplier reservationSupplier, IUpdateReservationController updateReservation, IRoomController roomController){
        this.reservationSupplier = reservationSupplier;
        updateReservationController = updateReservation;
        this.roomController = roomController;
    }

    @Override
    public void checkoutReservation(int reservationID) {
        //TODO: checkout implementation
        IReservation reservation = reservationSupplier.getReservation(reservationID);

        //ist Rechnung beglichen(Inteface von TeamG)

        reservation.setReservationStatus("checkedOut");
        setRoomState(reservation);
        updateReservationController.updateReservation(reservation);

    }

    public void setRoomState(IReservation reservation){
        List<? extends IReservationUnit> reservations = reservation.getReservationUnits();

        for(IReservationUnit res: reservations){
            List<? extends IRoomAssignment> units = res.getAllRoomAssignments();
            if(units.size()>0){
                IRoomAssignment roomAssignment = units.get(units.size()-1);
                IRoom room = roomAssignment.getRoom();
                room.setStatus("free-uncleaned");
                roomController.update(room);
            }else{
                System.out.println("Aendern nicht moeglich");
            }

        }
    }
}
