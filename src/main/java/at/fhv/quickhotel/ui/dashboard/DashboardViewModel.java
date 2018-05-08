package at.fhv.quickhotel.ui.dashboard;

import at.fhv.quickhotel.controller.factory.IControllerFactory;
import at.fhv.quickhotel.ui.reservation.viewReservation.ReservationDetailScope;
import de.saxsys.mvvmfx.InjectScope;
import de.saxsys.mvvmfx.ScopeProvider;
import de.saxsys.mvvmfx.ViewModel;

@ScopeProvider(scopes = {ReservationDetailScope.class})
public class DashboardViewModel implements ViewModel {

    @InjectScope
    private ReservationDetailScope scope;

    public void setReservationID(int id){
        IControllerFactory controllerFactory = null; //TODO: your controller factory  //new ControllerFactory();
        scope.setReservationSupplier(controllerFactory.createReservationSupplier());
        scope.setReservation(scope.getReservationSupplier().getReservation(id));
        scope.setExtendReservationController(controllerFactory.createExtendReservationController(scope.getReservation()));
        scope.setCheckoutReservationController(controllerFactory.createCheckoutReservationController());
    }
}
