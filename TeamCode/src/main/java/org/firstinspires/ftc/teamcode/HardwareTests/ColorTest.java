package org.firstinspires.ftc.teamcode.HardwareTests;

import com.qualcomm.robotcore.hardware.ColorSensor;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class ColorTest extends TestItem {
    private ColorSensor colorSensor;

    public ColorTest(String description, ColorSensor colorSensor) {
        super(description);
        this.colorSensor = colorSensor;
    }

    public void run(boolean on, Telemetry telemetry) {
        telemetry.addData("red", colorSensor.red());
        telemetry.addData("blue", colorSensor.blue());
        telemetry.addData("green", colorSensor.green());
        telemetry.addData("alpha", colorSensor.alpha());

    }
}
