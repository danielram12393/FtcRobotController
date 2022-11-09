package org.firstinspires.ftc.teamcode.Hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class ProgrammingForDerick {
    private DcMotor motor;
    private DigitalChannel touchSensor;

    public void init(HardwareMap hwMap) {
        motor = hwMap.get(DcMotor.class, "motor1");
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        touchSensor = hwMap.get(DigitalChannel.class, "ts");
    }

    public void setPower(double power) {
        motor.setPower(power);
    }

    public boolean isPressed() {
        return touchSensor.getState();
    }
}
