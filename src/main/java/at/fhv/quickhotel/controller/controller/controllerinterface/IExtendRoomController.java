package at.fhv.quickhotel.controller.controller.controllerinterface;

import at.fhv.quickhotel.domain.modelInterface.IRoom;

import java.time.LocalDate;

public interface IExtendRoomController {
    boolean isExtensionPossible(IRoom room, LocalDate startDate, LocalDate endDate);
    boolean isExtensionPossible(int roomNumber, LocalDate startDate, LocalDate endDate);
}
