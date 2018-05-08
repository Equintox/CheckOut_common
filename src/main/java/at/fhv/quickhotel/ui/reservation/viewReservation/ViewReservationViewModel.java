package at.fhv.quickhotel.ui.reservation.viewReservation;

import de.saxsys.mvvmfx.InjectScope;
import de.saxsys.mvvmfx.ViewModel;

public class ViewReservationViewModel implements ViewModel {

    @InjectScope
    private ReservationDetailScope scope;

    public void checkOutEvent() {
        scope.getCheckoutReservationController().checkoutReservation(scope.getReservation().getReservationID());
    }
}
