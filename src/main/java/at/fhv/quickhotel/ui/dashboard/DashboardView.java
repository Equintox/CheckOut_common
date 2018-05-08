package at.fhv.quickhotel.ui.dashboard;

import at.fhv.quickhotel.ui.reservation.viewReservation.ViewReservationView;
import at.fhv.quickhotel.ui.reservation.viewReservation.ViewReservationViewModel;
import de.saxsys.mvvmfx.*;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class DashboardView implements FxmlView<DashboardViewModel>{

    @FXML
    private TextField textfield_searchCheckOut;
/*
    @FXML
    private HBox searchBtnHBox;
*/

    @InjectContext
    private Context context;


    @InjectViewModel
    private DashboardViewModel viewModel;

    @FXML
    public void initialize() {
    }

    @FXML
    public void buttonCheckOutClicked(MouseEvent mouseEvent){

        viewModel.setReservationID(0); //TODO: set reservation id here

        Stage newReservationStage = new Stage();
        newReservationStage.setTitle("Reservation Overview");
        final ViewTuple<ViewReservationView, ViewReservationViewModel> viewTuple = FluentViewLoader.fxmlView(ViewReservationView.class).context(context).load();



        final Parent root = viewTuple.getView();
        //searchBtnHBox.getChildren().add(root);
        newReservationStage.setScene(new Scene(root));
        newReservationStage.show();


    }
}
