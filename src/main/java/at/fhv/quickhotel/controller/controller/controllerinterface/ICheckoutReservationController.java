package at.fhv.quickhotel.controller.controller.controllerinterface;

import at.fhv.quickhotel.domain.modelInterface.IReservation;

public interface ICheckoutReservationController {

    void checkoutReservation(int reservationID);
    void setRoomState(IReservation reservation);
}
