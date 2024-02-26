package MyResolvingPackage;

import com.comsystem.homework.model.RobotAction;
import com.comsystem.homework.model.RobotPlan;
import com.comsystem.homework.robot.RobotOperations;

import java.util.ArrayList;
import java.util.List;

public class TryingToResolveProblems {
    public static void main(String[] args) {
        RobotOperations actualOperation = new RobotOperations();
        RobotPlan actualPlan = actualOperation.excavateStonesForDays(6);
        List<RobotAction> actionsList = new ArrayList<>();
        for(int i =0; i < 5 ;i++){
            actionsList.add(RobotAction.CLONE);
        }
        actionsList.add(RobotAction.DIG);
        System.out.println(actualPlan);

        RobotPlan testPlan = new RobotPlan(6,32,actionsList);
        System.out.println(testPlan);
        System.out.println(testPlan.equals(actualPlan));
    }
}
