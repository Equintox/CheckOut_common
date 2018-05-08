package at.fhv.quickhotel.domain.modelInterface;

import java.util.List;

public interface IReservation {
    int getReservationID();
    List<? extends IReservationUnit> getReservationUnits();
    void setReservationStatus(String status);
    String getReservationStatus();
    String getReservationComment();
    String getPaymentTypeDescripton();
    IContractingParty getIContractingParty();

}
