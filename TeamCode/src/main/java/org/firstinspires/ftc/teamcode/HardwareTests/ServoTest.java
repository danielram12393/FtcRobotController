package org.firstinspires.ftc.teamcode.HardwareTests;

import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class ServoTest extends TestItem {
    private Servo servo;
    private double targetPosition1;
    boolean on;

    public ServoTest(String description, double targetPosition1, Servo servo) {
        super(description);
        this.targetPosition1 = targetPosition1;
        this.servo = servo;
    }

    public void run(boolean on, Telemetry telemetry) {
        if(on) {
            servo.setPosition(targetPosition1);
        } else {
            servo.setPosition(0.0);
        }
        telemetry.addData("Position", servo.getPosition());
    }
}
