package at.fhv.quickhotel.ui.reservation.viewReservation.subcontent.contractingPartyView.TravelAgency;


import at.fhv.quickhotel.domain.modelInterface.ITravelAgency;
import de.saxsys.mvvmfx.Scope;

public class TravelAgencyDetailScope implements Scope{

    private ITravelAgency travelAgency;

    public TravelAgencyDetailScope(ITravelAgency travelAgency){
        this.travelAgency = travelAgency;
    }

    public ITravelAgency getTravelAgency() {
        return travelAgency;
    }

    public void setTravelAgency(ITravelAgency travelAgency) {
        this.travelAgency = travelAgency;
    }
}
