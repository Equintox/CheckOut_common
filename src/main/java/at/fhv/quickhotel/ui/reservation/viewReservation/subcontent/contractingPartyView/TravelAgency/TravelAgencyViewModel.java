package at.fhv.quickhotel.ui.reservation.viewReservation.subcontent.contractingPartyView.TravelAgency;

import de.saxsys.mvvmfx.InjectScope;
import de.saxsys.mvvmfx.ViewModel;

public class TravelAgencyViewModel implements ViewModel {

    @InjectScope
    private TravelAgencyDetailScope travelAgencyDetailScope;


    int getContactID(){
        return travelAgencyDetailScope.getTravelAgency().getContactID();
    }

    String getTravelAgencyName(){
        return travelAgencyDetailScope.getTravelAgency().getCompanyName();
    }

    String getFirstName(){
        return travelAgencyDetailScope.getTravelAgency().getFirstName();
    }

    String getLastName(){
        return travelAgencyDetailScope.getTravelAgency().getLastName();
    }

    String getPhoneNumber(){
        return travelAgencyDetailScope.getTravelAgency().getPhoneNumber();
    }


    String getStreet(){
        return travelAgencyDetailScope.getTravelAgency().getStreet();
    }

    String getPlace(){
        return travelAgencyDetailScope.getTravelAgency().getPlace();
    }


    String getPostcode(){
        return travelAgencyDetailScope.getTravelAgency().getPostcode();
    }


    String getCountry(){
        return travelAgencyDetailScope.getTravelAgency().getCountry();
    }


    String getEmail(){
        return travelAgencyDetailScope.getTravelAgency().getEmail();
    }
}
