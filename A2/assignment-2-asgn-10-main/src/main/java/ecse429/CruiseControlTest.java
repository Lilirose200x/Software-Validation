package ecse429;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;
import org.junit.Assert;

import ca.mcgill.ecse429.cruisecontrol.CruiseController;
import ca.mcgill.ecse429.cruisecontrol.CruiseControllerStatus;
import ca.mcgill.ecse429.cruisecontrol.impl.CarControllerImpl;
import ca.mcgill.ecse429.cruisecontrol.impl.CruiseControllerImpl;

@GraphWalker(value = "random(edge_coverage(100))", start = "v_cc_off" )
public class CruiseControlTest extends ExecutionContext implements CruiseControlGraph {

    private final CruiseControllerImpl controller = new CruiseControllerImpl(new CarControllerImpl());
    int curSpeed = 0;

    @Override
    public void v_cc_off() {
        // TODO Auto-generated method stub
        Assert.assertTrue(controller.getCruiseControllerStatus() == CruiseControllerStatus.OFF);
    }

    @Override
    public void e_cancel() {
        // TODO Auto-generated method stub
        controller.cancelCruise();
    }

    @Override
    public void v_cc_activated() {
        // TODO Auto-generated method stub
        Assert.assertTrue(controller.getCruiseControllerStatus() == CruiseControllerStatus.ACTIVE);
        
    }

    @Override
    public void e_res_accel() {
        // TODO Auto-generated method stub
        controller.resumeCruiseAccel();
    }

    @Override
    public void v_cc_deactivated() {
        // TODO Auto-generated method stub
        Assert.assertEquals(CruiseControllerStatus.PASSIVE, controller.getCruiseControllerStatus());
    }

    @Override
    public void e_cruise() {
        // TODO Auto-generated method stub
        controller.toggleCruise();
    }

    @Override
    public void e_set_decel() {
        // TODO Auto-generated method stub
        controller.setSpeedDecel();
    }

    @Override
    public void e_brake() {
        // TODO Auto-generated method stub
        controller.brakeActivated();
    }

    @Override
    public void v_cc_cancelled() {
        // TODO Auto-generated method stub
        Assert.assertTrue(controller.getCruiseControllerStatus() == CruiseControllerStatus.CANCELLED);
    }
}