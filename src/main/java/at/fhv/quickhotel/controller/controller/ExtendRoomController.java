package at.fhv.quickhotel.controller.controller;

import at.fhv.quickhotel.controller.controller.controllerinterface.IExtendRoomController;
import at.fhv.quickhotel.controller.supplier.supplierInterface.IRoomSupplier;
import at.fhv.quickhotel.domain.modelInterface.IRoom;

import java.time.LocalDate;

public class ExtendRoomController implements IExtendRoomController {

    private IRoomSupplier roomSupplier;

    public ExtendRoomController(IRoomSupplier supplier){
        roomSupplier = supplier;
    }

    @Override
    public boolean isExtensionPossible(IRoom room, LocalDate startDate, LocalDate endDate) {
        return isExtensionPossible(room.getRoomNumber(),startDate,endDate);
    }

    @Override
    public boolean isExtensionPossible(int roomNumber, LocalDate startDate, LocalDate endDate){
        IRoom room = roomSupplier.getRoomByRoomNumber(roomNumber);
        return room.isExtensionPossible(startDate,endDate);
    }
}
