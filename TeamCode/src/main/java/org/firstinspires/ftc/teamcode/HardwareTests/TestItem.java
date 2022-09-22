package org.firstinspires.ftc.teamcode.HardwareTests;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.Telemetry;

abstract public class TestItem {
    private String description;

    public TestItem(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    abstract public void run(boolean on, Telemetry telemetry);
}
