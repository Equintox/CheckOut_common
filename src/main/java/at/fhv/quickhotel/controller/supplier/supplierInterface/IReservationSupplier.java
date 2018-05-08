package at.fhv.quickhotel.controller.supplier.supplierInterface;

import at.fhv.quickhotel.domain.modelInterface.IReservation;

public interface IReservationSupplier {

    IReservation getReservation(int reservationID);
}
