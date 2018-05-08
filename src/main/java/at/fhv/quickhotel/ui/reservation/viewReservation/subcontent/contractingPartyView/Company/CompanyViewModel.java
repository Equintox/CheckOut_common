package at.fhv.quickhotel.ui.reservation.viewReservation.subcontent.contractingPartyView.Company;

import de.saxsys.mvvmfx.InjectScope;
import de.saxsys.mvvmfx.ViewModel;

public class CompanyViewModel implements ViewModel {

    @InjectScope
    private CompanyDetailScope companyDetailScope;

    int getContactID(){
        return companyDetailScope.getCompany().getContactID();
    }

    String getCompanyName(){
        return companyDetailScope.getCompany().getCompanyName();
    }

    String getFirstName(){
        return companyDetailScope.getCompany().getFirstName();
    }

    String getLastName(){
        return companyDetailScope.getCompany().getLastName();
    }

    String getPhoneNumber(){
        return companyDetailScope.getCompany().getPhoneNumber();
    }


    String getStreet(){
        return companyDetailScope.getCompany().getStreet();
    }

    String getPlace(){
        return companyDetailScope.getCompany().getPlace();
    }


    String getPostcode(){
        return companyDetailScope.getCompany().getPostcode();
    }


    String getCountry(){
        return companyDetailScope.getCompany().getCountry();
    }


    String getEmail(){
        return companyDetailScope.getCompany().getEmail();
    }

}
