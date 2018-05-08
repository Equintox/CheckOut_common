package at.fhv.quickhotel.ui.reservation.viewReservation.subcontent.contractingPartyView.Contractor;

import de.saxsys.mvvmfx.InjectScope;
import de.saxsys.mvvmfx.ViewModel;

public class ContractorViewModel implements ViewModel {


    @InjectScope
    private ContractorDetailScope contractorDetailScope;

    int getContactID(){
        return contractorDetailScope.getContractor().getContactID();
    }

    String getFirstName(){
        return contractorDetailScope.getContractor().getFirstName();
    }

    String getLastName(){
        return contractorDetailScope.getContractor().getLastName();
    }

    String getPhoneNumber(){
        return contractorDetailScope.getContractor().getPhoneNumber();
    }


    String getStreet(){
        return contractorDetailScope.getContractor().getStreet();
    }

    String getPlace(){
        return contractorDetailScope.getContractor().getPlace();
    }


    String getPostcode(){
        return contractorDetailScope.getContractor().getPostcode();
    }


    String getCountry(){
        return contractorDetailScope.getContractor().getCountry();
    }


    String getEmail(){
        return contractorDetailScope.getContractor().getEmail();
    }
}
