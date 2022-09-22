package org.firstinspires.ftc.teamcode.RRAutos;

import androidx.annotation.NonNull;

import com.acmerobotics.roadrunner.drive.MecanumDrive;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Hardware.MecanumDriveConfig;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequenceBuilder;

import java.util.List;

@Autonomous
public class RRTestRun extends LinearOpMode {

    public void runOpMode() throws InterruptedException{
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);

        Pose2d startPose = new Pose2d(0, 0, 0);

        drive.setPoseEstimate(startPose);

        waitForStart();

        if (isStopRequested()) return;

        TrajectorySequence trajSeq = drive.trajectorySequenceBuilder(startPose)
                .splineToConstantHeading(new Vector2d(24, 24), Math.toRadians(45))
                .splineToSplineHeading(new Pose2d(72,72, Math.toRadians(135)), Math.toRadians(90))
                .strafeLeft(45)
                .splineToLinearHeading(new Pose2d(0,72, Math.toRadians(-90)), Math.toRadians(180))
                .build();
        drive.followTrajectorySequence(trajSeq);

        PoseStorage.currentPose = drive.getPoseEstimate();
    }
}