package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
@TeleOp
public class ServoTestOpMode extends OpMode {
    Servo servo;
    boolean aAlreadyPressed, servoOn;
    @Override
    public void init() {
        servo = hardwareMap.get(Servo.class, "servo");
        servo.setPosition(.5);
    }

    @Override
    public void loop() {
        if(gamepad1.a && !aAlreadyPressed) {
            servoOn = !servoOn;
            telemetry.addData("Claw", servoOn);
            if(servoOn) {
                servo.setPosition(0.4);
            }
            else {
                servo.setPosition(0.6);
            }
        }
        aAlreadyPressed = gamepad1.a;
    }
}
