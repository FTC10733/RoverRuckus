package org.firstinspires.ftc.teamcode.FTCGame2018;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name = "Tele Op v02", group = "Tele Op")
@Disabled
public class TeleOpv02 extends OpMode {

    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor frontLeftDrive = null;
    private DcMotor frontRightDrive = null;
    private DcMotor backLeftDrive = null;
    private DcMotor backRightDrive = null;

    private double frontLeft = 0.0;
    private double frontRight = 0.0;
    private double backLeft = 0.0;
    private double backRight = 0.0;
    private double maxPower = 0.1;

    public void init() {
        telemetry.addData("Init", "Initialized");
        telemetry.update();
        runtime.reset();
    }

    @Override
    public void init_loop() {
        telemetry.addData("Init Loop", "Initialize Wait Time: " + runtime.toString());
        try {
            frontLeftDrive = hardwareMap.get(DcMotor.class, "driveFrontLeft");
            frontRightDrive = hardwareMap.get(DcMotor.class, "driveFrontRight");
            backLeftDrive = hardwareMap.get(DcMotor.class, "driveBackLeft");
            backRightDrive = hardwareMap.get(DcMotor.class, "driveBackRight");
        } catch (IllegalArgumentException e) {
            telemetry.addData("Error", "Can't get motors. Are they connected?");
        }
        telemetry.update();
    }

    @Override
    public void start() {
        telemetry.addData("Start", "Starting");
        telemetry.update();
        runtime.reset();
    }

    public void loop() {
        telemetry.addData("Loop", "Run Time: " + runtime.toString());

        maxPower = gamepad1.right_stick_y;

        if (gamepad1.dpad_up) {
            telemetry.addData("direction", "forward");

            frontRight = maxPower;
            backRight = maxPower;
            frontLeft = -maxPower;
            backLeft = -maxPower;
        } else if (gamepad1.dpad_down) {
            telemetry.addData("direction", "backward");

            frontRight = -maxPower;
            backRight = -maxPower;
            frontLeft = maxPower;
            backLeft = maxPower;
        } else if (gamepad1.dpad_left) {
            telemetry.addData("direction", "left");

            frontRight = -maxPower;
            backRight = maxPower;
            frontLeft = -maxPower;
            backLeft = maxPower;
        } else if (gamepad1.dpad_right) {
            telemetry.addData("direction", "right");

            frontRight = maxPower;
            backRight = -maxPower;
            frontLeft = maxPower;
            backLeft = -maxPower;
        } else {
            telemetry.addData("direction", "still");
            frontLeft = 0;
            frontRight = 0;
            backLeft = 0;
            backRight = 0;
        }

        frontLeftDrive.setPower(frontLeft);
        backLeftDrive.setPower(backLeft);
        frontRightDrive.setPower(frontRight);
        backRightDrive.setPower(backRight);

        telemetry.update();
    }

    @Override
    public void stop() {
        telemetry.addData("Stop", "Stopped");
        telemetry.update();
    }
}
