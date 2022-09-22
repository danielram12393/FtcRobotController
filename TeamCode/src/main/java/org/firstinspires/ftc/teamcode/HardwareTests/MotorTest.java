package org.firstinspires.ftc.teamcode.HardwareTests;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class MotorTest extends TestItem{
    private double speed;
    private DcMotor motor;

    public MotorTest(String description, double speed, DcMotor motor) {
        super(description);
        this.speed = speed;
        this.motor = motor;
    }

    public void run(boolean on, Telemetry telemetry) {
        if(on) {
            motor.setPower(speed);
        } else {
            motor.setPower(0.0);
        }
        telemetry.addData("Encoder: ", motor.getCurrentPosition());
    }
}
