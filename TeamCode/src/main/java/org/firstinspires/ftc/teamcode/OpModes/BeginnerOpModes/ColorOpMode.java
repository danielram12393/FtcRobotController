package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Hardware.ProgrammingBoard5;
@Disabled
@TeleOp
public class ColorOpMode extends OpMode {
    ProgrammingBoard5 board = new ProgrammingBoard5();

    public void init() {
        board.init(hardwareMap);
    }

    public void loop() {
        telemetry.addData("Red", board.getAmountRed());
        telemetry.addData("Blue", board.getAmountBlue());
        telemetry.addData("Green", board.getAmountGreen());
        telemetry.addData("Alpha", board.getAmountAlpha());

    }
}
