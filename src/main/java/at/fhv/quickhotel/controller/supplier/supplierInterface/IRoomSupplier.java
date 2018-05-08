package at.fhv.quickhotel.controller.supplier.supplierInterface;

import at.fhv.quickhotel.domain.modelInterface.IRoom;


public interface IRoomSupplier {

  public IRoom getRoomByRoomNumber(int roomNumber);

}
