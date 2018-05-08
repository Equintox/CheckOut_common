package at.fhv.quickhotel.domain.modelInterface;

import java.time.LocalDate;

public interface IRoom {
    int getRoomNumber();
    IRoomCategory getRoomCategory();

    void setRoomID(int roomID);

    String getStatus();

    void setStatus(String status);

    boolean isExtensionPossible(LocalDate startDate, LocalDate endDate);
}
