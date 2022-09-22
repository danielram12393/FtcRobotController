package org.firstinspires.ftc.teamcode.Hardware;

import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class ProgrammingBoard1AndAHalf {
    DistanceSensor distanceSensor;

    public void init(HardwareMap hwMap) {
        distanceSensor = hwMap.get(DistanceSensor.class, "distance");
    }

    public double getDistance(DistanceUnit du) {
        return distanceSensor.getDistance(du);
    }
}
