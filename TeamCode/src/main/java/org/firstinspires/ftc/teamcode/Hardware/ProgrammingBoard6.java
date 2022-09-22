package org.firstinspires.ftc.teamcode.Hardware;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;


public class ProgrammingBoard6 {
    private BNO055IMU imu;

    public void init(HardwareMap hwMap) {
        imu = hwMap.get(BNO055IMU.class, "imu");
        BNO055IMU.Parameters params = new BNO055IMU.Parameters();
        imu.initialize(params);
    }

    public double getHeading(AngleUnit angleUnit) {
        //first parameter is how the angle is detected in the imu
        // second is the order in which each coordinate is returned
        //third is simply making it so we can choose between degrees and rads for our angle
        Orientation angles = imu.getAngularOrientation(AxesReference.INTRINSIC,AxesOrder.ZYX,angleUnit);
        //Axes order is ZYX so our first angle is Z
        return angles.firstAngle;
    }
}
