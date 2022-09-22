package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Hardware.ProgrammingBoard2AndAHalf;
@Disabled
@TeleOp
public class RunToPositionTest extends OpMode {
    ProgrammingBoard2AndAHalf board = new ProgrammingBoard2AndAHalf();

    public void init() {
        board.init(hardwareMap);
        board.setMotorSpeed(0.2);
    }

    public void loop() {
        if(board.getTargetPosition() == board.getCurrentPosition()) {
            board.setMotorSpeed(0.0);
        }

    }
}
