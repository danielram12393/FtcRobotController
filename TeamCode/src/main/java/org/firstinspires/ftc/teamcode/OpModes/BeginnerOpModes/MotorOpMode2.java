package org.firstinspires.ftc.teamcode.OpModes.BeginnerOpModes;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Hardware.ProgrammingBoard3;
@TeleOp
@Disabled
public class MotorOpMode2 extends OpMode {
    ProgrammingBoard3 board = new ProgrammingBoard3();

    @Override
    public void init() {
        board.init(hardwareMap);
    }

    double squareInputWithSign(double input) {
        double output = input * input;
        if(input < 0) {
            output *= -1;
        }
        return output;
    }

    @Override
    public void loop() {

        double motorSpeed = squareInputWithSign(-gamepad1.left_stick_y);

        board.setMotorSpeed(motorSpeed);

        if(gamepad1.a) {
            board.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            telemetry.addData("Stop", "Brake");
        }
        else if(gamepad1.b) {
            board.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
            telemetry.addData("Stop", "Float");
        }
        telemetry.addData("Rotations: ", board.getMotorRotations());
    }
}
