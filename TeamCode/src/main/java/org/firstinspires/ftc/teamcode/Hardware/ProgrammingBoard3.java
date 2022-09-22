package org.firstinspires.ftc.teamcode.Hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class ProgrammingBoard3 {
    private DcMotor motor;
    private double ticksPerRotation;

    public void init(HardwareMap hwMap) {
        motor = hwMap.get(DcMotor.class, "motor");
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        ticksPerRotation = motor.getMotorType().getTicksPerRev();
    }

    public void setMotorSpeed(double speed) {
        motor.setPower(speed);
    }

    public double getMotorRotations() {
        return motor.getCurrentPosition() / ticksPerRotation;
    }

    public void setZeroPowerBehavior(DcMotor.ZeroPowerBehavior zeroBehavior) {
        motor.setZeroPowerBehavior(zeroBehavior);
    }
}
