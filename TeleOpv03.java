package org.firstinspires.ftc.teamcode.FTCGame2018;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import edu.spa.ftclib.sample.robot.BNO055HolonomicBot;

@TeleOp(name = "TeleOp v03", group = "Tele Op")
//@Disabled

public class TeleOpv03 extends OpMode {
    private BNO055HolonomicBot robot;
    private DcMotor liftDrive = null;
    double course = 0.0;
    double velocity = 0.0;
    double rotation = 0.0;

    @Override
    public void init() {
        robot = new BNO055HolonomicBot(telemetry, hardwareMap);
        liftDrive = hardwareMap.get(DcMotor.class, "driveLift");
        //robot.drivetrain.setCourse(course);
        robot.drivetrain.setVelocity(0.0); //make sure drive motors are stopped.
        //robot.drivetrain.setRotation(rotation);
    }

    @Override
    public void loop() {
        if (gamepad1.y) {
            liftDrive.setPower(0.1); // Extend
        } else if (gamepad1.a) {
            liftDrive.setPower(-1.0); // Retract
        } else {
            liftDrive.setPower(0.0);
        }

        course = Math.atan2(-gamepad1.right_stick_y, gamepad1.right_stick_x) - Math.PI / 2;
        velocity = Math.hypot(gamepad1.right_stick_x, gamepad1.right_stick_y);
        rotation = -gamepad1.left_stick_x;

        robot.drivetrain.setCourse(course);
        robot.drivetrain.setVelocity(velocity);
        robot.drivetrain.setRotation(rotation);
    }
}
