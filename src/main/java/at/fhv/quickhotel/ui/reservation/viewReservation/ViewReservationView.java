package at.fhv.quickhotel.ui.reservation.viewReservation;


import at.fhv.quickhotel.ui.reservation.viewReservation.subcontent.ViewReservationContentView;
import at.fhv.quickhotel.ui.reservation.viewReservation.subcontent.ViewReservationContentViewModel;
import de.saxsys.mvvmfx.*;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;


public class ViewReservationView implements FxmlView<ViewReservationViewModel> {

    public Text textEdit;
    public HBox HBoxEdit;
    @FXML
    private AnchorPane anchorpane_center;

    @InjectViewModel
    private ViewReservationViewModel viewModel;

    @InjectContext
    private Context context;

    private ViewTuple<ViewReservationContentView,ViewReservationContentViewModel> viewTupleContent;
    private boolean isEditState;


    @FXML
    public void initialize() {
        isEditState = false;
        viewTupleContent = FluentViewLoader.fxmlView(ViewReservationContentView.class).context(context).load();
        anchorpane_center.getChildren().add(viewTupleContent.getView());
        
    }


    public void buttonCheckOutClicked(MouseEvent mouseEvent) {
        viewModel.checkOutEvent();
    }

    public void buttonEditClicked(MouseEvent mouseEvent) {
        if(viewTupleContent.getCodeBehind().editButtonPressed()){
            isEditState = !isEditState;

            if (isEditState){
                textEdit.setText("Save");
            }else {
                textEdit.setText("Edit");
            }
        }
    }
}
