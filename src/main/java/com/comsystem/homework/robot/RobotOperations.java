package com.comsystem.homework.robot;


import com.comsystem.homework.model.RobotAction;
import com.comsystem.homework.model.RobotPlan;

import java.util.ArrayList;
import java.util.List;

public class RobotOperations {

    /**
     * An algorithm that converts a number of days into an action plan.
     * @param days the number of days that the robot can work
     * @return The action plan <em>must maximize</em> the number of stones that the robot will dig. In other words, this
     *         algorithm must try to achieve the highest value of {@link RobotPlan#numberOfStones} possible for the
     *         number of provided days. The value of {@link RobotPlan#numberOfDays} is equal to the input
     *         days parameter
     * @see RobotPlan
     */

    /**
     * The logic of the method is that if there is more than one day, the robot does not need to mine,
     * instead it clones itself to the days without the last one,
     * with the last day being the mandatory day for all cloned robots to mine
     */
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

        RobotPlan plan = new RobotPlan(days, numberOfExcavatedStones, robotActionList);
        return plan;
    }

    /**
     * An algorithm that converts a number of stones into an action plan. Essentially this algorithm is the inverse of
     * {@link #excavateStonesForDays(int)}.
     *
     * @param numberOfStones the number of stones the robot has to collect
     * @return The action plan <em>must minimize</em> the number of days necessary for the robot to dig the
     * provided number of stones. In other words, this algorithm must try to achieve the lowest value of
     * {@link RobotPlan#} possible for the number of provided stones. The value of
     * {@link RobotPlan#} is equal to the numberOfStones parameter
     * @see RobotPlan
     */

    /**
     * we have to clone the robots until they reach a value equal to or greater than the stones,
     * then we need another day to mine them
     */
    public static  RobotPlan daysRequiredToCollectStones(long numberOfStones) {

        List<RobotAction> robotActionList = new ArrayList<>();

        int daysToCollect = 0;
        int clonedRobots = 1;
        if (numberOfStones == 1) {
            RobotAction robotActionDig = RobotAction.DIG;
            robotActionList.add(robotActionDig);
            daysToCollect = 1;
        }
        if (numberOfStones >= 2) {
            for (int i = 0; i < numberOfStones; i++) {

                RobotAction robotActionClone = RobotAction.CLONE;
                robotActionList.add(robotActionClone);
                clonedRobots = clonedRobots * 2;
                daysToCollect++;
                if (clonedRobots >= numberOfStones) {
                    break;
                }
            }
            daysToCollect += 1;
            RobotAction robotActionClone = RobotAction.DIG;
            robotActionList.add(robotActionClone);

        }
        return new RobotPlan(daysToCollect, numberOfStones, robotActionList);
    }
}

