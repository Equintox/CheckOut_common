package at.fhv.quickhotel.domain.modelInterface;

import java.time.LocalDate;

public interface IRoomAssignment {
    LocalDate getArrivalDate();
    LocalDate getDepartureDate();
    IRoom getRoom();
}
