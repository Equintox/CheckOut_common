package at.fhv.quickhotel.ui.reservation.viewReservation.subcontent.contractingPartyView.Company;

import at.fhv.quickhotel.domain.modelInterface.ICompany;
import de.saxsys.mvvmfx.Scope;

public class CompanyDetailScope implements Scope{

    private ICompany company;

    public CompanyDetailScope(ICompany company){
        this.company = company;
    }

    public ICompany getCompany() {
        return company;
    }

    public void setCompany(ICompany company) {
        this.company = company;
    }
}
