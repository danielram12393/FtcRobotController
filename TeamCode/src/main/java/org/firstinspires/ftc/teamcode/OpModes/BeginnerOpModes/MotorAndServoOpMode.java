package org.firstinspires.ftc.teamcode.OpModes.BeginnerOpModes;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Hardware.ProgrammingBoard4;
@Disabled
@TeleOp
public class MotorAndServoOpMode extends OpMode {

    ProgrammingBoard4 board = new ProgrammingBoard4();

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

        if(gamepad1.x) {
            board.setServoPosition(1.0);
        }
        else if(gamepad1.y) {
            board.setServoPosition(0.0);
        }
        else {
            board.setServoPosition(.5);
        }
        telemetry.addData("Rotations: ", board.getMotorRotations());
    }
}
