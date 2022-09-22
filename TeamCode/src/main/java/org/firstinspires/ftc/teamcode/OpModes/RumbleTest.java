package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
@TeleOp
@Disabled
public class RumbleTest extends OpMode {
    public void init() {

    }
    public void loop() {
        if(gamepad1.a) {
            gamepad1.rumble(100);
        }
    }
}
