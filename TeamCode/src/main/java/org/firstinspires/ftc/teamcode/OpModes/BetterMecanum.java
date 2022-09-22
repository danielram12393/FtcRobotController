package org.firstinspires.ftc.teamcode.OpModes;

import com.acmerobotics.roadrunner.followers.HolonomicPIDVAFollower;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.localization.Localizer;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Hardware.MecanumDriveConfig;
import org.firstinspires.ftc.teamcode.RRAutos.PoseStorage;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

@TeleOp
public class BetterMecanum extends LinearOpMode {
    final public double SLOW_MODE_SPEED = .3;
    @Override
    public void runOpMode() throws InterruptedException {
        SampleMecanumDrive chassis = new SampleMecanumDrive(hardwareMap);

        double magnitude = 1;
        boolean slowMode = false, aAlreadyPressed = false;

        // We want to turn off velocity control for teleop
        // Velocity control per wheel is not necessary outside of motion profiled auto
        chassis.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        // Retrieve our pose from the PoseStorage.currentPose static field
        // See AutoTransferPose.java for further details
        chassis.setPoseEstimate(PoseStorage.currentPose);

        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive() && !isStopRequested()) {
            //Read Pose
            Pose2d poseEstimate = chassis.getPoseEstimate();

            chassis.setWeightedDrivePower(
                    new Pose2d(
                            -gamepad1.left_stick_y * magnitude,
                            -gamepad1.left_stick_x * magnitude,
                            -gamepad1.right_stick_x * magnitude
                    )
            );
            if(gamepad1.a && !aAlreadyPressed) {
                slowMode = !slowMode;
                telemetry.addData("Slowmode", slowMode);
                if(slowMode) {
                    magnitude = SLOW_MODE_SPEED;
                }
                else {
                    magnitude = 1;
                }
            }
            aAlreadyPressed = gamepad1.a;

            // Update everything. Odometry. Etc.
            chassis.update();

            // Print pose to telemetry
            telemetry.addData("x", poseEstimate.getX());
            telemetry.addData("y", poseEstimate.getY());
            telemetry.addData("heading", poseEstimate.getHeading());
            telemetry.update();
        }
    }
}
