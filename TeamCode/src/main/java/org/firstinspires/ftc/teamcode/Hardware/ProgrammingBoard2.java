package org.firstinspires.ftc.teamcode.Hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

//
public class ProgrammingBoard2 {
    private DcMotor motor;

    public void init(HardwareMap hwMap) {
        motor = hwMap.get(DcMotor.class, "cesar");
        motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    public void setMotorSpeed(double speed) {
        motor.setPower(speed);
    }
}
// ProgammingBoard2 robot = new ProgrammingBoard2();
//robot.init(HardwareMap)