package at.fhv.quickhotel.ui.reservation.viewReservation.subcontent.contractingPartyView.TravelAgency;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class TravelAgencyView implements FxmlView<TravelAgencyViewModel> {
    public TextField textField_firstnameTravelAgency;
    public TextField textField_lastnameTravelAgency;
    public TextField textField_phonenumberTravelAgency;
    public TextField textField_emailTravelAgency;
    public TextField textField_countryTravelAgency;
    public TextField textField_zipcodeTravelAgency;
    public TextField textField_placeTravelAgency;
    public TextArea textArea_streetTravelAgency;
    public TextField textField_nameTravelAgency;

    @InjectViewModel
    private TravelAgencyViewModel viewModel;

    @FXML
    public void initialize(){
        textField_firstnameTravelAgency.setText(viewModel.getFirstName());
        textField_lastnameTravelAgency.setText(viewModel.getLastName());
        textField_phonenumberTravelAgency.setText(viewModel.getPhoneNumber());
        textField_emailTravelAgency.setText(viewModel.getEmail());
        textField_countryTravelAgency.setText(viewModel.getCountry());
        textField_zipcodeTravelAgency.setText(viewModel.getPostcode());
        textField_placeTravelAgency.setText(viewModel.getPlace());
        textArea_streetTravelAgency.setText(viewModel.getStreet());
        textField_nameTravelAgency.setText(viewModel.getTravelAgencyName());
    }

    public void setAllElementDisabled(){
        

        textField_firstnameTravelAgency.setDisable(true);
        textField_lastnameTravelAgency.setDisable(true);
        textField_phonenumberTravelAgency.setDisable(true);
        textField_emailTravelAgency.setDisable(true);
        textField_countryTravelAgency.setDisable(true);
        textField_zipcodeTravelAgency.setDisable(true);
        textField_placeTravelAgency.setDisable(true);
        textArea_streetTravelAgency.setDisable(true);
        textField_nameTravelAgency.setDisable(true);
    }
}
