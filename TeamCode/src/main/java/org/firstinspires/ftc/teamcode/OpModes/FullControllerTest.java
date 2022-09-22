package org.firstinspires.ftc.teamcode.OpModes;

import android.view.View;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
//@Disabled
@TeleOp
public class FullControllerTest extends OpMode
{
    @Override
    public void init()
    {

    }

    @Override
    public void loop()
    {
        telemetry.addData("right bumper",gamepad1.right_bumper);
        telemetry.addData("left bumper",gamepad1.left_bumper);
        telemetry.addData("left trigger",gamepad1.left_trigger);
        telemetry.addData("right trigger",gamepad1.right_trigger);
        telemetry.addData("dpad down",gamepad1.dpad_down);
        telemetry.addData("dpad up",gamepad1.dpad_up);
        telemetry.addData("dpad right",gamepad1.dpad_right);
        telemetry.addData("dpad left",gamepad1.dpad_left);
        telemetry.addData("back",gamepad1.back);
        telemetry.addData("start",gamepad1.start);
        telemetry.addData("right stick press",gamepad1.right_stick_button);
        telemetry.addData("left stick press",gamepad1.left_stick_button);
        telemetry.addData("right stick x",gamepad1.right_stick_x);
        telemetry.addData("right stick y",gamepad1.right_stick_y);
        telemetry.addData("left stick x",gamepad1.left_stick_x);
        telemetry.addData("left stick y",gamepad1.left_stick_y);
        telemetry.addData("y",gamepad1.y);
        telemetry.addData("x",gamepad1.x);
        telemetry.addData("b",gamepad1.b);
        telemetry.addData("a",gamepad1.a);
    }
}
