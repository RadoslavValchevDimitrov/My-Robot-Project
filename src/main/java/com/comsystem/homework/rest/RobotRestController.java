package com.comsystem.homework.rest;

import com.comsystem.homework.model.RobotPlan;
import com.comsystem.homework.robot.RobotOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController()
@RequestMapping("/api/v1/robot/operation")
public final class RobotRestController {

    /**
     * This method exposes the functionality of {@link RobotOperations#excavateStonesForDays(int)} via HTTP
     */
    @PostMapping("/excavation")
    public ResponseEntity<RobotPlan> excavateStones(@RequestParam(required = false) Integer numberOfDays) {
         numberOfDays = generateDaysOrStones();
        if (numberOfDays <= 0) {
            throw new RobotNotFoundException("Robot plan not found");
        }
        RobotOperations excavate = new RobotOperations();

        RobotPlan robotPlan = excavate.excavateStonesForDays(numberOfDays);

        return new ResponseEntity<>(robotPlan, HttpStatus.OK);

    }

    public static int generateDaysOrStones (){
        Random r = new Random();
        return r.nextInt(365);
    }

    @ExceptionHandler
    public ResponseEntity<RobotErrorResponse>handleException(RobotNotFoundException exc){
        RobotErrorResponse error = new RobotErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    /**
     * This method exposes the functionality of {@link RobotOperations#daysRequiredToCollectStones(int)} via HTTP
     */
    @PostMapping("/approximation")
    public ResponseEntity<RobotPlan> approximateDays(@RequestParam(required = false) Integer numberOfStones) {
         numberOfStones = generateDaysOrStones();
        if (numberOfStones <= 0) {
            throw new RobotNotFoundException("Robot plan not found");
        }
        RobotOperations days = new RobotOperations();
        RobotPlan robotPlan = days.daysRequiredToCollectStones(numberOfStones);

        return new ResponseEntity<>(robotPlan, HttpStatus.OK);
    }
}
