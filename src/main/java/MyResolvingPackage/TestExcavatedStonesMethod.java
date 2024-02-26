package MyResolvingPackage;

import com.comsystem.homework.model.RobotAction;
import com.comsystem.homework.model.RobotPlan;

import java.util.ArrayList;
import java.util.List;

public class TestExcavatedStonesMethod {
    public static void main(String[] args) {

        excavateStonesForDays(6);

    }

    public static RobotPlan excavateStonesForDays(int days) {
        List<RobotAction> robotActionList = new ArrayList<>();
        int numberOfExcavatedStones = 0;
        int clonedRobots = 0;
        if (days < 0) {
            return null;
        } else if (days >= 2) {

            for (int i = 0; i < days - 1; i++) {

                RobotAction cloningRobot = RobotAction.CLONE;
                if (clonedRobots == 0) {
                    clonedRobots += 1;
                }
                clonedRobots = clonedRobots * 2;
                robotActionList.add(cloningRobot);
            }
            numberOfExcavatedStones = clonedRobots;
            RobotAction digRobot = RobotAction.DIG;
            robotActionList.add(digRobot);

        } else {
            RobotAction digRobot = RobotAction.DIG;
            robotActionList.add(digRobot);
            numberOfExcavatedStones = 1;
        }
        System.out.println(robotActionList);
        System.out.println("Cloned Robots are equal to " + clonedRobots);
        System.out.println("Excavated stones are equal to " + numberOfExcavatedStones);
        RobotPlan plan = new RobotPlan(days,numberOfExcavatedStones,robotActionList);
        return plan;
    }
}
