package at.fhv.quickhotel.ui.reservation.viewReservation.subcontent.reservationView;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ReservationView implements FxmlView<ReservationViewModel>{
    public TextField textField_status;
    public TextField textField_paymentType;
    public TextArea textArea_comment;
    public TextField textField_reservationID;

    @InjectViewModel
    private ReservationViewModel viewModel;

    @FXML
    public void initialize(){
        textField_status.setText(viewModel.getReservationStatus());
        textField_paymentType.setText(viewModel.getReservationPaymentType());
        textArea_comment.setText(viewModel.getReservationComment());
        textField_reservationID.setText(viewModel.getReservationID());
    }

    public void setAllElementDisabled(){
        textField_reservationID.setDisable(true);
        textField_paymentType.setDisable(true);
        textArea_comment.setDisable(true);
        textField_status.setDisable(true);
    }

}
