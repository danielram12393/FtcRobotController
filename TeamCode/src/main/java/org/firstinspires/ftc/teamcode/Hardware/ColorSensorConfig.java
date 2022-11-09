package org.firstinspires.ftc.teamcode.Hardware;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class ColorSensorConfig {
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

    public int getMostColor() {
        if(colorSensor.red() > colorSensor.blue() && colorSensor.red() > colorSensor.green()) {
            return 0;
        }
        else if(colorSensor.green() > colorSensor.red() && colorSensor.green() > colorSensor.blue()) {
            return 1;
        }
        else if(colorSensor.blue() > colorSensor.red() && colorSensor.blue() > colorSensor.green()) {
            return 2;
        }
        else {
            return -1;
        }
    }
}
