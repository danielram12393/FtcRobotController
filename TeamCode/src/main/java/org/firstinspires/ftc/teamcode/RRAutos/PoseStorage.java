package org.firstinspires.ftc.teamcode.RRAutos;

import com.acmerobotics.roadrunner.geometry.Pose2d;

 /*
 used to tranfer position of robot between autos and teleOps.
 Simply set end positions of autos equal to PoseStorage.currentPose then set start position of
 TeleOps equal to PoseStorage.currentPose. since the variable is static it is shared among all classes
  */
public class PoseStorage {
    public static Pose2d currentPose = new Pose2d();
}
