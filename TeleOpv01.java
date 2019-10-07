package org.firstinspires.ftc.teamcode.FTCGame2018;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

//import edu.spa.ftclib.internal.drivetrain.MecanumDrivetrain;

//using library from St. Paul Academy for mechanum drive


@TeleOp(name = "Tele Op v01", group = "Tele Op")
@Disabled
public class TeleOpv01 extends OpMode {

    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor frontLeftDrive = null;
    private DcMotor frontRightDrive = null;
    private DcMotor backLeftDrive = null;
    private DcMotor backRightDrive = null;
    //private MecanumDrivetrain drivetrain;
    private double frontLeft = 0.0;
    private double frontRight = 0.0;
    private double backLeft = 0.0;
    private double backRight = 0.0;
    private double maxPower = 0.1;


    //private TelemetryData telem = TelemetryData.getInstance();

    //private double leftArmPosition = 0.0;
    // private double rightArmPosition = 0.0;

    public void init() {
        telemetry.addData("Init", "Initialized");

        //drivetrain = new MecanumDrivetrain(new DcMotor[]{frontLeftDrive, frontRightDrive, backLeftDrive, backRightDrive});

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

        // double left;
        // double right;

        // Run wheels in tank mode (note: The joystick goes negative when pushed forwards, so negate it)
        // left = -gamepad1.left_stick_y;
        maxPower = gamepad1.right_stick_y;

        // leftDrive.setPower(left);
        // rightDrive.setPower(right);

        /*
        telemetry.addData("left stick", "X: " + String.valueOf(gamepad1.left_stick_x)
                + ", Y:" + String.valueOf(gamepad1.left_stick_y)
                + ", Btn:" + String.valueOf(gamepad1.left_stick_button));
        telemetry.addData("right stick", "X: " + String.valueOf(gamepad1.right_stick_x)
                + ", Y:" + String.valueOf(gamepad1.right_stick_y)
                + ", Btn:" + String.valueOf(gamepad1.right_stick_button));


        telemetry.addData("Dpad down", "Val: " + String.valueOf(gamepad1.dpad_down));
        telemetry.addData("Dpad up", "Val: " + String.valueOf(gamepad1.dpad_up));
        telemetry.addData("Dpad left", "Val: " + String.valueOf(gamepad1.dpad_left));
        telemetry.addData("Dpad right", "Val: " + String.valueOf(gamepad1.dpad_right));
        telemetry.addData("y", "Val: " + String.valueOf(gamepad1.y));
        telemetry.addData("b", "Val: " + String.valueOf(gamepad1.b));
        telemetry.addData("a", "Val: " + String.valueOf(gamepad1.a));
        telemetry.addData("x", "Val: " + String.valueOf(gamepad1.x));
    */

        // Simple Mechanum Drive
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
        } else if (gamepad1.dpad_up && gamepad1.dpad_left) {
            telemetry.addData("direction", "f-l");

            // frontLeft = -maxPower;
            // frontRight =  maxPower;
            // backLeft =  -maxPower;
            // backRight =  maxPower;
        } else if (gamepad1.dpad_up && gamepad1.dpad_right) {
            telemetry.addData("direction", "f-r");

            // frontLeft = -maxPower;
            // frontRight =  maxPower;
            // backLeft =  -maxPower;
            // backRight =  maxPower;
        } else if (gamepad1.dpad_down && gamepad1.dpad_left) {
            telemetry.addData("direction", "b-l");

            //frontLeft = -maxPower;
            // frontRight =  maxPower;
            // backLeft =  -maxPower;
            // backRight =  maxPower;
        } else if (gamepad1.dpad_down && gamepad1.dpad_right) {
            telemetry.addData("direction", "b-r");

            //frontLeft = -maxPower;
            // frontRight =  maxPower;
            // backLeft =  -maxPower;
            // backRight =  maxPower;
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

        /*
        //mechanum
        double course = Math.atan2(-gamepad1.right_stick_y, gamepad1.right_stick_x) - Math.PI / 2;
        double velocity = Math.hypot(gamepad1.right_stick_x, gamepad1.right_stick_y);
        double rotation = -gamepad1.left_stick_x;

        try {
            drivetrain.setCourse(course);
            drivetrain.setVelocity(velocity);
            drivetrain.setRotation(rotation);
        } catch (IllegalArgumentException e) {
            telemetry.addData("Error", "Can't get drivetrain. Check motor connections");
        } catch (Exception e) {
            telemetry.addData("Error", e.toString());
        }
        telemetry.addData("course", course);
        telemetry.addData("velocity", velocity);
        telemetry.addData("rotation", rotation);

        */

        telemetry.update();
    }

    @Override
    public void stop() {
        telemetry.addData("Stop", "Stopped");
        telemetry.update();
    }
}
