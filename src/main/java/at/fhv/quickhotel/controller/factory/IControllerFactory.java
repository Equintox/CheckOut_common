package at.fhv.quickhotel.controller.factory;

import at.fhv.quickhotel.controller.controller.controllerinterface.*;
import at.fhv.quickhotel.controller.supplier.supplierInterface.IReservationSupplier;
import at.fhv.quickhotel.domain.modelInterface.IReservation;

public interface IControllerFactory {

    IReservationSupplier createReservationSupplier();
    IExtendRoomController createExtendRoomController();
    IUpdateReservationController createUpdateReservationController();
    ICheckoutReservationController createCheckoutReservationController();
    IRoomController createRoomController();

    IExtendReservationController createExtendReservationController(IReservation reservation);
}
