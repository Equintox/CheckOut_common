package at.fhv.quickhotel.domain;

import at.fhv.quickhotel.domain.modelInterface.ICategoryAvailableContainer;

import java.time.LocalDate;

public class CategoryAvailableContainer implements ICategoryAvailableContainer {

    private int roomCategoryId;
    private LocalDate startDate;
    private LocalDate endDate;

    public int getRoomCategoryId() {
        return roomCategoryId;
    }

    public void setRoomCategoryId(int roomCategoryId) {
        this.roomCategoryId = roomCategoryId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
