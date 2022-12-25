package ecse429;

import ca.mcgill.ecse429.cruisecontrol.CruiseControllerStatus;
import ca.mcgill.ecse429.cruisecontrol.impl.CarControllerImpl;
import ca.mcgill.ecse429.cruisecontrol.impl.CruiseControllerImpl;

import org.junit.Assert;

import java.io.IOException;

public class Runner {
  public static void main(String[] args) throws IOException {

    // Creating a CruiseControllerImpl object
    CruiseControllerImpl controller = new CruiseControllerImpl(new CarControllerImpl());

    // Checking that the initial status is OFF
    Assert.assertTrue(controller.getCruiseControllerStatus() == CruiseControllerStatus.OFF);

    // Applying the togglecruise operation (method)
    controller.toggleCruise();

    // Checking that the status changed to PASSIVE
    Assert.assertTrue(controller.getCruiseControllerStatus() == CruiseControllerStatus.PASSIVE);
  }
}
