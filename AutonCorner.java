package org.firstinspires.ftc.teamcode.FTCGame2018;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import edu.spa.ftclib.sample.robot.BNO055HolonomicBot;

@Autonomous(name = "Go to Corner", group = "Auton")
// @Disabled

public class AutonCorner extends LinearOpMode {
    private BNO055HolonomicBot robot;
    private DcMotor liftDrive = null;

    @Override
    public void runOpMode() throws InterruptedException {

        robot = new BNO055HolonomicBot(telemetry, hardwareMap);
        liftDrive = hardwareMap.get(DcMotor.class, "driveLift");
        double course = 0.0;
        double velocity = 0.0;
        double rotation = 0.0;

        waitForStart();

        // Drop 7 seconds and stop.
        liftDrive.setPower(-0.1); // Extend
        sleep(7000);
        liftDrive.setPower(0.0);

        // Strafe half a second.
        course = 1.5708;
        velocity = 0.2;
        rotation = 0.0;
        robot.drivetrain.setCourse(course);
        robot.drivetrain.setVelocity(velocity);
        robot.drivetrain.setRotation(rotation);

        sleep(500);

        // Stop.
        course = 0.0;
        velocity = 0.0;
        rotation = 0.0;
        robot.drivetrain.setCourse(course);
        robot.drivetrain.setVelocity(velocity);
        robot.drivetrain.setRotation(rotation);

        sleep(1000);

        // Forward 2.0 seconds.
        course = 3.14;
        velocity = 0.4;
        rotation = 0.0;
        robot.drivetrain.setCourse(course);
        robot.drivetrain.setVelocity(velocity);
        robot.drivetrain.setRotation(rotation);

        sleep(2000);

        // Stop.
        course = 0.0;
        velocity = 0.0;
        rotation = 0.0;
        robot.drivetrain.setCourse(course);
        robot.drivetrain.setVelocity(velocity);
        robot.drivetrain.setRotation(rotation);

        // back away from marker.
        course = 0.0;
        velocity = 0.3;
        rotation = 0.0;
        robot.drivetrain.setCourse(course);
        robot.drivetrain.setVelocity(velocity);
        robot.drivetrain.setRotation(rotation);

        sleep(500);

        // Stop.
        course = 0.0;
        velocity = 0.0;
        rotation = 0.0;
        robot.drivetrain.setCourse(course);
        robot.drivetrain.setVelocity(velocity);
        robot.drivetrain.setRotation(rotation);

    }
}
