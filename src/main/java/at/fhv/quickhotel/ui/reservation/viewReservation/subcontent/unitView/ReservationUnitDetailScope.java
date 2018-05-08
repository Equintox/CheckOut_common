package at.fhv.quickhotel.ui.reservation.viewReservation.subcontent.unitView;

import at.fhv.quickhotel.domain.modelInterface.IReservationUnit;
import de.saxsys.mvvmfx.Scope;

public class ReservationUnitDetailScope implements Scope{

    private IReservationUnit reservationUnit;

    public IReservationUnit getReservationUnit() {
        return reservationUnit;
    }

    public void setReservationUnit(IReservationUnit reservationUnit) {
        this.reservationUnit = reservationUnit;
    }
}
