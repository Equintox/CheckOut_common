package at.fhv.quickhotel.ui.reservation.viewReservation.subcontent;

import at.fhv.quickhotel.controller.controller.controllerinterface.IExtendReservationController;
import at.fhv.quickhotel.controller.controller.exceptions.ReservationExtensionNotPossibleException;
import at.fhv.quickhotel.domain.modelInterface.IContractingParty;
import at.fhv.quickhotel.domain.modelInterface.IReservationUnit;
import at.fhv.quickhotel.ui.reservation.viewReservation.ReservationDetailScope;
import at.fhv.quickhotel.ui.reservation.viewReservation.subcontent.unitView.ReservationUnitView;
import at.fhv.quickhotel.ui.reservation.viewReservation.subcontent.unitView.ReservationUnitViewModel;
import de.saxsys.mvvmfx.InjectScope;
import de.saxsys.mvvmfx.ViewModel;
import de.saxsys.mvvmfx.ViewTuple;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class ViewReservationContentViewModel implements ViewModel {

    @InjectScope
    private ReservationDetailScope scope;

    public List<? extends IReservationUnit> getReservationUnits(){
        return scope.getReservation().getReservationUnits();
    }

    public IContractingParty getContractingParty(){
        return scope.getReservation().getIContractingParty();
    }



    public boolean updateReservation(List<ViewTuple<ReservationUnitView, ReservationUnitViewModel>> unitViewTuples) {
        IExtendReservationController extendReservationController = scope.getExtendReservationController();
        AtomicBoolean roomsAvailable = new AtomicBoolean(true);
        AtomicBoolean changeDetected = new AtomicBoolean(false);

        unitViewTuples.forEach(viewTuple -> {
            //TODO: Don't use View directly, check date

            int resUnitId = viewTuple.getViewModel().getReservationUnitId();
            LocalDate selectedDepartureDate = viewTuple.getCodeBehind().depatureDatePicker.getValue();

            if(!selectedDepartureDate.equals(viewTuple.getViewModel().getReservationUnitDepartureDate())) { //date was changed
                changeDetected.set(true);
                if (!extendReservationController.extendReservationUnit(resUnitId, selectedDepartureDate)) {
                    //Rooms not available
                    roomsAvailable.set(false);

                    //TODO: ViewModel should not create Alert windows
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Room extension not available");
                    alert.setContentText("Room extension for Room " + viewTuple.getViewModel().getReservationUnitRoomNumber() + " not possible");
                    alert.showAndWait();
                    viewTuple.getView().requestFocus();
                }
            }
        });

        if(!roomsAvailable.get()) //Rooms not available --> return
            return false;

        if(changeDetected.get()) { //Departure date was changed

            //Rooms available --> check Categories from other reservations
            try {
                extendReservationController.updateReservation();

                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Room extension successful");
                alert.setContentText("Room extensions successfully saved");
                alert.showAndWait();

            } catch (ReservationExtensionNotPossibleException e) {

                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Room extension unsuccessful");
                alert.setContentText("Room extensions was not possible because the categories are not available");
                alert.showAndWait();

                return false;
            }
        }
        return true;
    }
}
