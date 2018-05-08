package at.fhv.quickhotel.ui.reservation.viewReservation.subcontent.contractingPartyView.Contractor;


import at.fhv.quickhotel.domain.modelInterface.IContractor;
import de.saxsys.mvvmfx.Scope;

public class ContractorDetailScope implements Scope{

    private IContractor contractor;

    public ContractorDetailScope(IContractor contractor){
        this.contractor = contractor;
    }

    public IContractor getContractor() {
        return contractor;
    }

    public void setContractor(IContractor contractor) {
        this.contractor = contractor;
    }
}
