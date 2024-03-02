package MyResolvingPackage;

import java.util.Random;

public class TryingToResolveProblems {

    public static void main(String[] args) {
//        RobotOperations actualOperation = new RobotOperations();
//        RobotPlan actualPlan = actualOperation.excavateStonesForDays(6);
//        List<RobotAction> actionsList = new ArrayList<>();
//        for(int i =0; i < 5 ;i++){
//            actionsList.add(RobotAction.CLONE);
//        }
//        actionsList.add(RobotAction.DIG);
//        System.out.println(actualPlan);
//
//        RobotPlan testPlan = new RobotPlan(6,32,actionsList);
//        System.out.println(testPlan);
//        System.out.println(testPlan.equals(actualPlan));

        System.out.println(utility());

    }
    public static int utility (){
        Random r = new Random();
        return r.nextInt(100);

    }
}
