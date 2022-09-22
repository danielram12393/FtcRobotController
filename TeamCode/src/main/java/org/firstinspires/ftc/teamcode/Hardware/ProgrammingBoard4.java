package org.firstinspires.ftc.teamcode.Hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class ProgrammingBoard4 {
    private DcMotor motor;
    private double ticksPerRotation;
    private Servo servo;

    public void init(HardwareMap hwMap) {
        motor = hwMap.get(DcMotor.class, "motor");
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        ticksPerRotation = motor.getMotorType().getTicksPerRev();
        servo = hwMap.get(Servo.class, "servo");
    }

    public void setMotorSpeed(double speed) {
        motor.setPower(speed);
    }

    public void setServoPosition(double position) {
        servo.setPosition(position);
    }

    public double getMotorRotations() {
        return motor.getCurrentPosition() / ticksPerRotation;
    }

    public void setZeroPowerBehavior(DcMotor.ZeroPowerBehavior zeroBehavior) {
        motor.setZeroPowerBehavior(zeroBehavior);
    }
}
