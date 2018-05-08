package at.fhv.quickhotel.controller.supplier.supplierInterface;

import at.fhv.quickhotel.domain.modelInterface.IRoom;
import at.fhv.quickhotel.domain.modelInterface.IRoomAssignment;

import java.time.LocalDate;
import java.util.List;

public interface IRoomAssignmentSupplier {

    List<? extends IRoomAssignment> getRoomAssignments(IRoom room, LocalDate startDate, LocalDate endDate);
}
