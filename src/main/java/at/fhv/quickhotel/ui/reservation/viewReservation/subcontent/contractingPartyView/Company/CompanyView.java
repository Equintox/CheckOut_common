package at.fhv.quickhotel.ui.reservation.viewReservation.subcontent.contractingPartyView.Company;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CompanyView implements FxmlView<CompanyViewModel> {
    public TextField textField_firstnameCompany;
    public TextField textField_lastnameCompany;
    public TextField textField_phonenumberCompany;
    public TextField textField_emailCompany;
    public TextField textField_countryCompany;
    public TextField textField_zipcodeCompany;
    public TextField textField_placeCompany;
    public TextArea textArea_streetCompany;
    public TextField textField_nameCompany;

    @InjectViewModel
    private CompanyViewModel viewModel;

    @FXML
    public void initialize(){
        textField_firstnameCompany.setText(viewModel.getFirstName());
        textField_lastnameCompany.setText(viewModel.getLastName());
        textField_phonenumberCompany.setText(viewModel.getPhoneNumber());
        textField_emailCompany.setText(viewModel.getEmail());
        textField_countryCompany.setText(viewModel.getCountry());
        textField_zipcodeCompany.setText(viewModel.getPostcode());
        textField_placeCompany.setText(viewModel.getPlace());
        textArea_streetCompany.setText(viewModel.getStreet());
        textField_nameCompany.setText(viewModel.getCompanyName());
    }

    public void setAllElementDisabled(){
        textField_firstnameCompany.setDisable(true);
        textField_lastnameCompany.setDisable(true);
        textField_phonenumberCompany.setDisable(true);
        textField_emailCompany.setDisable(true);
        textField_countryCompany.setDisable(true);
        textField_zipcodeCompany.setDisable(true);
        textField_placeCompany.setDisable(true);
        textArea_streetCompany.setDisable(true);
        textField_nameCompany.setDisable(true);
    }
}
