package at.fhv.quickhotel.domain.modelInterface;

import java.time.LocalDate;
import java.util.List;

public interface IReservationUnit {
    LocalDate getDepartureDate();
    LocalDate getArrivalDate();
    String getRoomCategoryDescription();
    IRoomCategory getRoomCategory();
    String getArrangementDescription();
    IRoom getRoom();
    int getReservationUnitId();
    List<? extends IRoomAssignment> getAllRoomAssignments();

    void setNewDepartureDate(LocalDate newDepartureDate);

}
