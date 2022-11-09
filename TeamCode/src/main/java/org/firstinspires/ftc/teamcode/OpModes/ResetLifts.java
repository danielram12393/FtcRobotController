package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Hardware.LiftConfig;

@TeleOp
public class ResetLifts extends OpMode {
    LiftConfig lift = new LiftConfig();

    public void init() {
        lift.init(hardwareMap);
        lift.rightLift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        lift.leftLift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void loop() {
        if(gamepad1.a) {
            lift.leftLift.setPower(.1);
        }
        else if(gamepad1.b) {
            lift.rightLift.setPower(-.1);
        }
        else {
            lift.leftLift.setPower(0);
            lift.rightLift.setPower(0);
        }
    }
}
