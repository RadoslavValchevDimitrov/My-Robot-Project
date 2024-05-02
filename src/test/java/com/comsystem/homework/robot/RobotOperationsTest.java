package com.comsystem.homework.robot;

import com.comsystem.homework.model.RobotAction;
import com.comsystem.homework.model.RobotPlan;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RobotOperationsTest {
    RobotOperations operations;
    List<RobotAction> list;

    @BeforeEach
    public void setUpOperationsAndList() {
        operations = new RobotOperations();
        list = new ArrayList<>();
    }

    static Stream<Arguments> daysAndStonesProvider() {
        return Stream.of(Arguments.arguments(6, 32)
                , Arguments.arguments(3, 4));
    }

    @ParameterizedTest
    @MethodSource("daysAndStonesProvider")
    void excavateStonesForDays(int days, long stones) {

        RobotPlan actualPlan = RobotOperations.excavateStonesForDays(days);

        for (int i = 0; i < days - 1; i++) {
            list.add(RobotAction.CLONE);
        }
        list.add(RobotAction.DIG);
        RobotPlan testPlan = new RobotPlan(days, stones, list);
        assertEquals(actualPlan, testPlan);
    }

    @ParameterizedTest
    @MethodSource("daysAndStonesProvider")
    void daysRequiredToCollectStones(int days, long stones) {

        RobotPlan actualPlan = RobotOperations.daysRequiredToCollectStones(stones);

        for (int i = 0; i < days - 1; i++) {
            list.add(RobotAction.CLONE);
        }
        list.add(RobotAction.DIG);
        RobotPlan testPlan = new RobotPlan(days, stones, list);
        assertEquals(actualPlan, testPlan);
    }
}