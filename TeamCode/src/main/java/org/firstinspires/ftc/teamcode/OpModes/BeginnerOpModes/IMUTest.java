package org.firstinspires.ftc.teamcode.OpModes.BeginnerOpModes;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.Hardware.ProgrammingBoard6;
@Disabled
@TeleOp
public class IMUTest extends OpMode {
    ProgrammingBoard6 board = new ProgrammingBoard6();

    public void init() {
        board.init(hardwareMap);
    }

    public void loop() {
        telemetry.addData("Heading", board.getHeading(AngleUnit.DEGREES));
    }
}
