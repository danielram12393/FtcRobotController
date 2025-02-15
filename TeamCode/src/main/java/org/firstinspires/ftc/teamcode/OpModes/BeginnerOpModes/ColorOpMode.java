package org.firstinspires.ftc.teamcode.OpModes.BeginnerOpModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Hardware.ColorSensorConfig;
@TeleOp
public class ColorOpMode extends OpMode {
    ColorSensorConfig board = new ColorSensorConfig();

    public void init() {
        board.init(hardwareMap);
    }

    public void loop() {
        telemetry.addData("Red", board.getAmountRed());
        telemetry.addData("Blue", board.getAmountBlue());
        telemetry.addData("Green", board.getAmountGreen());
        telemetry.addData("Alpha", board.getAmountAlpha());
        telemetry.addData("Selected Color", board.getMostColor());

    }
}
