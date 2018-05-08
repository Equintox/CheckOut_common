package at.fhv.quickhotel.ui.reservation.viewReservation.subcontent.contractingPartyView.Contractor;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ContractorView implements FxmlView<ContractorViewModel>{
    public TextField textField_firstnameGuest;
    public TextField textField_lastnameGuest;
    public TextField textField_phonenumberGuest;
    public TextField textField_emailGuest;
    public TextField textField_countryGuest;
    public TextField textField_zipcodeGuest;
    public TextField textField_placeGuest;
    public TextArea textArea_streetGuest;
    public CheckBox checkbox_isVipGuest;

    @InjectViewModel
    private ContractorViewModel viewModel;
    
    @FXML
    public void initialize(){
        textField_firstnameGuest.setText(viewModel.getFirstName());
        textField_lastnameGuest.setText(viewModel.getLastName());
        textField_phonenumberGuest.setText(viewModel.getPhoneNumber());
        textField_emailGuest.setText(viewModel.getEmail());
        textField_countryGuest.setText(viewModel.getCountry());
        textField_zipcodeGuest.setText(viewModel.getPostcode());
        textField_placeGuest.setText(viewModel.getPlace());
        textArea_streetGuest.setText(viewModel.getStreet());
    }

    public void setAllElementDisabled(){
        textField_firstnameGuest.setDisable(true);
        textField_lastnameGuest.setDisable(true);
        textField_phonenumberGuest.setDisable(true);
        textField_emailGuest.setDisable(true);
        textField_countryGuest.setDisable(true);
        textField_zipcodeGuest.setDisable(true);
        textField_placeGuest.setDisable(true);
        textArea_streetGuest.setDisable(true);
    }
}
