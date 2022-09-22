package org.firstinspires.ftc.teamcode.Hardware;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class ProgrammingBoard5 {
    ColorSensor colorSensor;

    public void init(HardwareMap hwMap) {
        colorSensor = hwMap.get(ColorSensor.class, "colorV3");
    }

    public int getAmountRed() {
        return colorSensor.red();
    }
    public int getAmountBlue() {
        return colorSensor.blue();
    }

    public int getAmountGreen() {
        return colorSensor.green();
    }

    public int getAmountAlpha() {
        return colorSensor.alpha();
    }
}
