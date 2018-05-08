package at.fhv.quickhotel.ui.reservation.viewReservation.subcontent;

import at.fhv.quickhotel.domain.modelInterface.*;
import at.fhv.quickhotel.ui.reservation.viewReservation.subcontent.contractingPartyView.Company.CompanyDetailScope;
import at.fhv.quickhotel.ui.reservation.viewReservation.subcontent.contractingPartyView.Company.CompanyView;
import at.fhv.quickhotel.ui.reservation.viewReservation.subcontent.contractingPartyView.Company.CompanyViewModel;
import at.fhv.quickhotel.ui.reservation.viewReservation.subcontent.contractingPartyView.Contractor.ContractorDetailScope;
import at.fhv.quickhotel.ui.reservation.viewReservation.subcontent.contractingPartyView.Contractor.ContractorView;
import at.fhv.quickhotel.ui.reservation.viewReservation.subcontent.contractingPartyView.Contractor.ContractorViewModel;
import at.fhv.quickhotel.ui.reservation.viewReservation.subcontent.contractingPartyView.TravelAgency.TravelAgencyDetailScope;
import at.fhv.quickhotel.ui.reservation.viewReservation.subcontent.contractingPartyView.TravelAgency.TravelAgencyView;
import at.fhv.quickhotel.ui.reservation.viewReservation.subcontent.contractingPartyView.TravelAgency.TravelAgencyViewModel;
import at.fhv.quickhotel.ui.reservation.viewReservation.subcontent.reservationView.ReservationView;
import at.fhv.quickhotel.ui.reservation.viewReservation.subcontent.reservationView.ReservationViewModel;
import at.fhv.quickhotel.ui.reservation.viewReservation.subcontent.unitView.ReservationUnitDetailScope;
import at.fhv.quickhotel.ui.reservation.viewReservation.subcontent.unitView.ReservationUnitView;
import at.fhv.quickhotel.ui.reservation.viewReservation.subcontent.unitView.ReservationUnitViewModel;
import de.saxsys.mvvmfx.*;
import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.LinkedList;
import java.util.List;

public class ViewReservationContentView implements FxmlView<ViewReservationContentViewModel> {


    public HBox HBox_ReservationInformation;
    public VBox HBox_ContractingParty;
    @FXML
    private VBox vbox_categoryContent;


    @InjectViewModel
    ViewReservationContentViewModel viewModel;

    @InjectContext
    private Context context;

    private List<ViewTuple<ReservationUnitView, ReservationUnitViewModel>> unitViewTuples;
    private boolean isEditState;


    @FXML
    public void initialize() {
        isEditState = false;
        unitViewTuples = new LinkedList<>();

        for(IReservationUnit reservationUnit : viewModel.getReservationUnits()){
            ReservationUnitDetailScope reservationUnitDetailScope = new ReservationUnitDetailScope();
            reservationUnitDetailScope.setReservationUnit(reservationUnit);
            ViewTuple<ReservationUnitView, ReservationUnitViewModel> viewTuple = FluentViewLoader.fxmlView(ReservationUnitView.class)
                    .context(context)
                    .providedScopes(reservationUnitDetailScope)
                    .load();
            vbox_categoryContent.getChildren().add(viewTuple.getView());
            unitViewTuples.add(viewTuple);

            viewTuple.getCodeBehind().arrivalDatePicker.setDisable(true);
            viewTuple.getCodeBehind().depatureDatePicker.setDisable(true);
            viewTuple.getCodeBehind().choicebox_category.setDisable(true);
            viewTuple.getCodeBehind().choicebox_arrangements.setDisable(true);
        }

        ViewTuple<ReservationView, ReservationViewModel> viewTuple = FluentViewLoader.fxmlView(ReservationView.class)
                .context(context)
                .load();
        viewTuple.getCodeBehind().setAllElementDisabled();
        HBox_ReservationInformation.getChildren().add(viewTuple.getView());
        

        IContractingParty contractingParty = viewModel.getContractingParty();
        if(contractingParty.getContact() instanceof ITravelAgency) {
            TravelAgencyDetailScope travelAgencyDetailScope =  new TravelAgencyDetailScope((ITravelAgency) contractingParty.getContact());
            final ViewTuple<TravelAgencyView, TravelAgencyViewModel> viewTupleContractingParty = FluentViewLoader.fxmlView(TravelAgencyView.class)
                    .providedScopes(travelAgencyDetailScope)
            .load();
            viewTupleContractingParty.getCodeBehind().setAllElementDisabled();
           HBox_ContractingParty.getChildren().addAll(viewTupleContractingParty.getView());

        }else if(contractingParty.getContact() instanceof ICompany) {
            CompanyDetailScope companyDetailScope =  new CompanyDetailScope((ICompany) contractingParty.getContact());
            final ViewTuple<CompanyView, CompanyViewModel> viewTupleContractingParty = FluentViewLoader.fxmlView(CompanyView.class)
                    .providedScopes(companyDetailScope)
                    .load();
            viewTupleContractingParty.getCodeBehind().setAllElementDisabled();
            HBox_ContractingParty.getChildren().addAll(viewTupleContractingParty.getView());
        } else if(contractingParty.getContact() instanceof IContractor){
            ContractorDetailScope contractorDetailScope =  new ContractorDetailScope((IContractor) contractingParty.getContact());
            final ViewTuple<ContractorView, ContractorViewModel> viewTupleContractingParty = FluentViewLoader.fxmlView(ContractorView.class)
                    .providedScopes(contractorDetailScope)
                    .load();
            viewTupleContractingParty.getCodeBehind().setAllElementDisabled();
            HBox_ContractingParty.getChildren().addAll(viewTupleContractingParty.getView());
        }


    }



    public boolean editButtonPressed() {

        if(!isEditState) {
            isEditState = !isEditState;

            for (ViewTuple<ReservationUnitView, ReservationUnitViewModel> viewTuple : unitViewTuples) {
                //viewTuple.getCodeBehind().arrivalDatePicker.setDisable(false);
                viewTuple.getCodeBehind().depatureDatePicker.setDisable(false);
            }

        } else {
            if(viewModel.updateReservation(unitViewTuples)){
                isEditState = !isEditState;
                for (ViewTuple<ReservationUnitView, ReservationUnitViewModel> viewTuple : unitViewTuples) {
                    //viewTuple.getCodeBehind().arrivalDatePicker.setDisable(true);
                    viewTuple.getCodeBehind().depatureDatePicker.setDisable(true);
                }
                return true;
            } else {
                //Revert changes
                for (ViewTuple<ReservationUnitView, ReservationUnitViewModel> viewTuple : unitViewTuples) {
                    viewTuple.getCodeBehind().revertDateChanges();
                }
                return false;
            }
        }
        return true;
    }
}
