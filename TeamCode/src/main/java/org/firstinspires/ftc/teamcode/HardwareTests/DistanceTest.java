package org.firstinspires.ftc.teamcode.HardwareTests;

import com.qualcomm.robotcore.hardware.DistanceSensor;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class DistanceTest extends TestItem {
    private DistanceSensor distanceSensor;
    private DistanceUnit du;

    public DistanceTest(String description, DistanceUnit du, DistanceSensor distanceSensor) {
        super(description);
        this.distanceSensor = distanceSensor;
        this.du = du;
    }

    public void run(boolean on, Telemetry telemetry) {
        telemetry.addData("Distance in inches: ", distanceSensor.getDistance(du));
    }
}
