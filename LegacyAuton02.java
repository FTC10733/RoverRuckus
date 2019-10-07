package org.firstinspires.ftc.teamcode.FTCGame2018;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "LegacyAuton02", group = "Auton")
@Disabled
public class LegacyAuton02 extends OpMode {

    int target = 2000;
    private DcMotor leftDrive = null;
    private DcMotor rightDrive = null;
    private double robotSpeed = 0.4;

    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");
        leftDrive = hardwareMap.get(DcMotor.class, "left_drive");
        rightDrive = hardwareMap.get(DcMotor.class, "right_drive");
    }

    @Override
    public void start() {

        leftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftDrive.setTargetPosition(target);
        rightDrive.setTargetPosition(target);

        leftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        // Stop all motion;
        leftDrive.setPower(0);
        rightDrive.setPower(0);
    }

    @Override
    public void loop() {
        if (leftDrive.isBusy() && rightDrive.isBusy()) {
            leftDrive.setPower(robotSpeed);
            rightDrive.setPower(-robotSpeed);
        } else {
            leftDrive.setPower(0);
            rightDrive.setPower(0);
        }
    }
}
