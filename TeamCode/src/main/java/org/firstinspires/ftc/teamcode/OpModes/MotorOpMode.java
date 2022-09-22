package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Hardware.ProgrammingBoard2;
@TeleOp
public class MotorOpMode extends OpMode {
    ProgrammingBoard2 robot = new ProgrammingBoard2();

    @Override
    public void init() {
        robot.init(hardwareMap);
    }

    @Override
    public void loop() {
        if(gamepad1.a) {
            robot.setMotorSpeed(.5);
        }
        else {
            robot.setMotorSpeed(0);
        }

    }
}
