package MyResolvingPackage;

import com.comsystem.homework.model.RobotAction;
import com.comsystem.homework.model.RobotPlan;
import com.comsystem.homework.robot.RobotOperations;

import java.util.ArrayList;
import java.util.List;

public class TestApproximateDays {

    public static void main(String[] args) {
        //daysRequiredToCollectStones(1);
        fillTheRobotPlan(9);
    }

    // We have to clone the robots until they reach a value equal to or greater than that of the stones

    public static void fillTheRobotPlan(int numberOfDays){
        RobotOperations excavate = new RobotOperations();

        RobotPlan robotPlan = excavate.excavateStonesForDays(numberOfDays);
        System.out.println(robotPlan);
    }

    public static RobotPlan daysRequiredToCollectStones(int numberOfStones) {
        List<RobotAction> robotActionList = new ArrayList<>();

        int daysToCollect = 0;
        int clonedRobots = 1;

        if (numberOfStones == 1) {
            RobotAction robotActionDig = RobotAction.DIG;
            robotActionList.add(robotActionDig);
            daysToCollect = 1;
            System.out.println( "Days for collecting " + daysToCollect);
        }
        if (numberOfStones >= 2) {
            for (int i = 0; i < numberOfStones; i++) {

                RobotAction robotActionClone = RobotAction.CLONE;
                robotActionList.add(robotActionClone);
                clonedRobots = clonedRobots *2;
                daysToCollect ++;
                if(clonedRobots >= numberOfStones){
                    break;
                }
            }
            daysToCollect +=1;
            RobotAction robotActionClone = RobotAction.DIG;
            robotActionList.add(robotActionClone);
            System.out.println( "Days for collecting " + daysToCollect);
            System.out.println(robotActionList);

        }
        RobotPlan robotPlan = new RobotPlan(daysToCollect,numberOfStones,robotActionList);
          return robotPlan;
    }
}


