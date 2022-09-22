package org.firstinspires.ftc.teamcode.OpModes.BeginnerOpModes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.Hardware.ProgrammingForDerick;
@Autonomous
public class DerickIsAnLForJoiningRobotics extends OpMode {
    ProgrammingForDerick board = new ProgrammingForDerick();

    public void init() {
        board.init(hardwareMap);
    }

    public void loop() {
        if (board.isPressed()) {
            board.setPower(1);
        } else {
            board.setPower(0);
        }
    }
}

