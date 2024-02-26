package com.comsystem.homework.rest;

import com.comsystem.homework.model.RobotPlan;
import com.comsystem.homework.robot.RobotOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/v1/robot/operation")
public final class RobotRestController {

    /**
     * This method exposes the functionality of {@link RobotOperations#excavateStonesForDays(int)} via HTTP
     */
    @PostMapping("/excavation")
    public ResponseEntity<RobotPlan> excavateStones(@RequestParam Integer numberOfDays) {

        if (numberOfDays < 0) {
            throw new ErrorResponseException(HttpStatus.I_AM_A_TEAPOT);
        }
        RobotOperations excavate = new RobotOperations();

        RobotPlan robotPlan = excavate.excavateStonesForDays(numberOfDays);

        return new ResponseEntity<>(robotPlan, HttpStatus.OK);

    }

    /**
     * This method exposes the functionality of {@link RobotOperations#daysRequiredToCollectStones(int)} via HTTP
     */
    @PostMapping("/approximation")
    public ResponseEntity<RobotPlan> approximateDays(@RequestParam Integer numberOfStones) {

        if (numberOfStones < 0) {
            throw new ErrorResponseException(HttpStatus.I_AM_A_TEAPOT);
        }
        RobotOperations days = new RobotOperations();
        RobotPlan robotPlan = days.daysRequiredToCollectStones(numberOfStones);

        return new ResponseEntity<>(robotPlan, HttpStatus.OK);
    }
}
