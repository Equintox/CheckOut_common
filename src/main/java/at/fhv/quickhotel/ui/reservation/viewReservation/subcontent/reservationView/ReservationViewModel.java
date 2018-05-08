package at.fhv.quickhotel.ui.reservation.viewReservation.subcontent.reservationView;

import at.fhv.quickhotel.ui.reservation.viewReservation.ReservationDetailScope;
import de.saxsys.mvvmfx.InjectScope;
import de.saxsys.mvvmfx.ViewModel;

public class ReservationViewModel implements ViewModel {

    @InjectScope
    private ReservationDetailScope scope;

    public String getReservationID(){
        return Integer.toString(scope.getReservation().getReservationID());
    }
    public String getReservationStatus(){
        return scope.getReservation().getReservationStatus();
    }
    public String getReservationComment() {
        return scope.getReservation().getReservationComment();
    }

    public String getReservationPaymentType(){
        return scope.getReservation().getPaymentTypeDescripton();
    }


}
