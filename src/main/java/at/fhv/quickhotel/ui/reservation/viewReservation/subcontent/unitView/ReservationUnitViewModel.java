package at.fhv.quickhotel.ui.reservation.viewReservation.subcontent.unitView;

import at.fhv.quickhotel.domain.modelInterface.IRoom;
import de.saxsys.mvvmfx.InjectScope;
import de.saxsys.mvvmfx.ViewModel;

import java.time.LocalDate;

public class ReservationUnitViewModel implements ViewModel{
    
    @InjectScope
    private ReservationUnitDetailScope reservationUnitDetailScope;

    public LocalDate getReservationUnitDepartureDate(){
        return reservationUnitDetailScope.getReservationUnit().getDepartureDate();
    }

    public LocalDate getReservationUnitArrivalDate(){
        return reservationUnitDetailScope.getReservationUnit().getArrivalDate();
    }

    public String getReservationUnitCategory(){
        return reservationUnitDetailScope.getReservationUnit().getRoomCategoryDescription();
    }

    public String getReservtionUnitArrangement(){
        return reservationUnitDetailScope.getReservationUnit().getArrangementDescription();
    }

    public int getReservationUnitRoomNumber(){
        IRoom room = reservationUnitDetailScope.getReservationUnit().getRoom();

        if(room == null)
            return -1;
        return room.getRoomNumber();
    }

    public int getReservationUnitId(){
        return reservationUnitDetailScope.getReservationUnit().getReservationUnitId();
    }


}
