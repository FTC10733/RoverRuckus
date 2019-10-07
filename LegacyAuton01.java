package org.firstinspires.ftc.teamcode.FTCGame2018;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "LegacyAuton01", group = "Auton")
@Disabled
public class LegacyAuton01 extends OpMode {

    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftDrive = null;
    private DcMotor rightDrive = null;

    // We want the robot to run for a whole second.
    private double runDelay = 1.2;
    // We want the robot to go at one tenth speed.
    private double robotSpeed = 0.4;

    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");
        leftDrive = hardwareMap.get(DcMotor.class, "left_drive");
        rightDrive = hardwareMap.get(DcMotor.class, "right_drive");
    }

    @Override
    public void start() {
        runtime.reset();
    }

    @Override
    public void loop() {
        if (runtime.seconds() < runDelay) {
            leftDrive.setPower(robotSpeed);
            rightDrive.setPower(-robotSpeed);
        } else {
            leftDrive.setPower(0);
            rightDrive.setPower(0);
        }
    }
}
