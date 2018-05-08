package at.fhv.quickhotel.ui.reservation.viewReservation.subcontent.unitView;


import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class ReservationUnitView implements FxmlView<ReservationUnitViewModel> {

    @FXML
    public DatePicker depatureDatePicker;
    @FXML
    public DatePicker arrivalDatePicker;
    @FXML
    private Text text_roomNumber;
    @FXML
    public ChoiceBox choicebox_category;
    @FXML
    public ChoiceBox choicebox_arrangements;

    @FXML
    private TextField textfield;

    @InjectViewModel
    private ReservationUnitViewModel viewModel;

    @FXML
    public void initialize(){
        arrivalDatePicker.setValue(viewModel.getReservationUnitArrivalDate());
        depatureDatePicker.setValue(viewModel.getReservationUnitDepartureDate());

        ObservableList<String> category = FXCollections.observableArrayList(viewModel.getReservationUnitCategory());
        ObservableList<String> arrangement = FXCollections.observableArrayList(viewModel.getReservtionUnitArrangement());

        choicebox_category.setItems(category);
        choicebox_arrangements.setItems(arrangement);

        choicebox_category.setValue(viewModel.getReservationUnitCategory());
        choicebox_arrangements.setValue(viewModel.getReservtionUnitArrangement());

        text_roomNumber.setText("" + viewModel.getReservationUnitRoomNumber());
    }

    public void revertDateChanges() {
        depatureDatePicker.setValue(viewModel.getReservationUnitDepartureDate());
    }
}
