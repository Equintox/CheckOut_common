package at.fhv.quickhotel.ui.reservation.viewReservation;

import at.fhv.quickhotel.controller.controller.controllerinterface.ICheckoutReservationController;
import at.fhv.quickhotel.controller.controller.controllerinterface.IExtendReservationController;
import at.fhv.quickhotel.controller.supplier.supplierInterface.IReservationSupplier;
import at.fhv.quickhotel.domain.modelInterface.IReservation;
import de.saxsys.mvvmfx.Scope;

public class ReservationDetailScope implements Scope{

    private IReservation reservation;
    private IReservationSupplier reservationSupplier;
    private IExtendReservationController extendReservationController;
    private ICheckoutReservationController checkoutReservationController;


  /*  public ReservationDetailScope(IReservationSupplier reservationSupplier
            ,IExtendReservationController extendReservationController
            , ICheckoutReservationController checkoutReservationController ){
        this.reservationSupplier = reservationSupplier;
        this.extendReservationController = extendReservationController;
        this.checkoutReservationController = checkoutReservationController;
    }
    */

    public void setReservationSupplier(IReservationSupplier reservationSupplier){
        this.reservationSupplier = reservationSupplier;
    }

    public IReservationSupplier getReservationSupplier() {
        return reservationSupplier;
    }

    public IExtendReservationController getExtendReservationController() {
        return extendReservationController;
    }

    public void setExtendReservationController(IExtendReservationController extendReservationController) {
        this.extendReservationController = extendReservationController;
    }

    public IReservation getReservation(){
        return reservation;
    }

    public void setReservation(IReservation reservation){
        this.reservation = reservation;

    }

    public ICheckoutReservationController getCheckoutReservationController() {
        return checkoutReservationController;
    }

    public void setCheckoutReservationController(ICheckoutReservationController checkoutReservationController) {
        this.checkoutReservationController = checkoutReservationController;
    }
}
