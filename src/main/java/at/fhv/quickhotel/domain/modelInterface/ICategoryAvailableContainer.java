package at.fhv.quickhotel.domain.modelInterface;

import java.time.LocalDate;

public interface ICategoryAvailableContainer {

    int getRoomCategoryId();
    void setRoomCategoryId(int roomCategoryId);
    LocalDate getStartDate();
    void setStartDate(LocalDate startDate);
    LocalDate getEndDate();
    void setEndDate(LocalDate endDat);


}
