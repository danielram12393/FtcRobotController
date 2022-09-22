package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Hardware.ProgrammingBoard;
@TeleOp
@Disabled
public class TouchSensorOpMode extends OpMode {
    ProgrammingBoard board = new ProgrammingBoard();
    @Override
    public void init() {
        board.init(hardwareMap);
    }

    @Override
    public void loop() {
        if(board.isTouchSensorPressed()) {
            telemetry.addData("Touch Sensor: ", "pressed");
        }
        else
        {
            telemetry.addData("Touch Sensor: ", "not pressed");
        }
    }
}
