package org.firstinspires.ftc.teamcode.OpModes.BeginnerOpModes;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Hardware.FinalBoard;
@TeleOp
@Disabled
public class ToggleButton extends OpMode {
    FinalBoard board = new FinalBoard();
    boolean xAlreadyPressed;
    boolean motorOn;

    @Override
    public void init() {
        board.init(hardwareMap);
    }


    public void loop() {
        if(gamepad1.x && !xAlreadyPressed) {
            motorOn = !motorOn;
            telemetry.addData("Motor", motorOn);
            if(motorOn) {
                board.setMotorSpeed(.5);
            }
            else {
                board.setMotorSpeed(0.0);
            }
        }
        xAlreadyPressed = gamepad1.x;
    }


}
