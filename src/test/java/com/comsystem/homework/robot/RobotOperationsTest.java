package com.comsystem.homework.robot;

import com.comsystem.homework.model.RobotAction;
import com.comsystem.homework.model.RobotPlan;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RobotOperationsTest {

    @Test
    void excavateStonesForDays() {
        RobotOperations actualOperation = new RobotOperations();
        RobotPlan actualPlan = actualOperation.excavateStonesForDays(6);
        List<RobotAction> actionsList = new ArrayList<>();
        for(int i =0; i < 5 ;i++){
            actionsList.add(RobotAction.CLONE);
        }
        actionsList.add(RobotAction.DIG);
        RobotPlan testPlan = new RobotPlan(6,32,actionsList);
        assertEquals(actualPlan,testPlan);
    }

    @Test
    void daysRequiredToCollectStones() {
        RobotOperations operation = new RobotOperations();
        RobotPlan actualPlan = operation.daysRequiredToCollectStones(256);
        List<RobotAction> actionList = new ArrayList<>();
        for(int i =0;i < 8;i++){
            actionList.add(RobotAction.CLONE);
        }
        actionList.add(RobotAction.DIG);
        RobotPlan testPlan = new RobotPlan(9,256,actionList);
        assertEquals(actualPlan,testPlan);
    }
}