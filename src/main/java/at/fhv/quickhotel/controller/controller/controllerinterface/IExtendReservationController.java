package at.fhv.quickhotel.controller.controller.controllerinterface;

import at.fhv.quickhotel.controller.controller.exceptions.ReservationExtensionNotPossibleException;

import java.time.LocalDate;

public interface IExtendReservationController {

    //void setReservation(IReservation reservation);

    boolean isReservationUnitExtensionPossible(int reservationUnitId, LocalDate departureDate);

    boolean extendReservationUnit(int reservationUnitId, LocalDate departureDate);

    void updateReservation() throws ReservationExtensionNotPossibleException;

}
