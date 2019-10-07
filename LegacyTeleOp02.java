package org.firstinspires.ftc.teamcode.FTCGame2018;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name = "LegacyTeleOp02", group = "Tele Op")
@Disabled
public class LegacyTeleOp02 extends OpMode {

    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftDrive = null;
    private DcMotor rightDrive = null;
    private Servo leftServo = null;
    private Servo rightServo = null;

    private double leftArmPosition = 0.0;
    private double rightArmPosition = 0.0;

    public void init() {
        telemetry.addData("Init", "Initialized");
        telemetry.update();

        leftDrive = hardwareMap.get(DcMotor.class, "left_drive");
        rightDrive = hardwareMap.get(DcMotor.class, "right_drive");
        leftServo = hardwareMap.get(Servo.class, "servoLeft");
        rightServo = hardwareMap.get(Servo.class, "servoRight");


        runtime.reset();
    }

    @Override
    public void init_loop() {
        telemetry.addData("Init Loop", "Initialize Wait Time: " + runtime.toString());
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
        telemetry.update();

        double left;
        double right;

        // Run wheels in tank mode (note: The joystick goes negative when pushed forwards, so negate it)
        left = -gamepad1.left_stick_y;
        right = gamepad1.right_stick_y;

        leftDrive.setPower(left);
        rightDrive.setPower(right);
        if (left == 0 && right == 0) {
            if (gamepad1.dpad_up) {
                left = 1;
                right = -1;
            }
            leftDrive.setPower(left);
            rightDrive.setPower(right);
        }

        if (gamepad1.left_trigger > 0) {     //Left arm movement
            leftArmPosition += 0.01;
        }
        if (gamepad1.left_bumper) {
            leftArmPosition -= 0.01;
        }
        if (leftArmPosition < 0.0)
            leftArmPosition = 0.0;
        else if (leftArmPosition > 0.5)
            leftArmPosition = 0.5;

        if (gamepad1.right_trigger > 0) {     //Right arm movement
            rightArmPosition -= 0.01;
        }
        if (gamepad1.right_bumper) {
            rightArmPosition += 0.01;
        }
        if (rightArmPosition < 0.0)
            rightArmPosition = 0.0;
        else if (rightArmPosition > 0.5)
            rightArmPosition = 0.5;

        if (gamepad1.b) {               //both arms inside
            rightArmPosition = 0.5;
            leftArmPosition = 0;
        }
        if (gamepad1.a) {               //both arms outside
            rightArmPosition = 0.0;
            leftArmPosition = 0.5;
        }
        leftServo.setPosition(leftArmPosition);   //these two actually move it
        rightServo.setPosition(rightArmPosition);

    }

    @Override
    public void stop() {
        telemetry.addData("Stop", "Stopped");
        telemetry.update();
    }
}
