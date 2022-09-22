package org.firstinspires.ftc.teamcode.OpModes.BeginnerOpModes;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.Hardware.ProgrammingBoard1AndAHalf;
@Disabled
@TeleOp
public class DistanceOpMode extends OpMode {
    ProgrammingBoard1AndAHalf board = new ProgrammingBoard1AndAHalf();

    public void init() {
        board.init(hardwareMap);
    }

    public void loop() {
        telemetry.addData("Distance in cm", board.getDistance(DistanceUnit.CM));
        telemetry.addData("Distance in inch", board.getDistance(DistanceUnit.INCH));

    }
}
