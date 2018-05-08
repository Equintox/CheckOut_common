package at.fhv.quickhotel.controller.controller.controllerinterface;

import at.fhv.quickhotel.domain.modelInterface.ICategoryAvailableContainer;

import java.util.List;

public interface ICategoryAvailableController {

    boolean checkRoomAvailable(List<? extends ICategoryAvailableContainer> categoryAvailableContainers);
}