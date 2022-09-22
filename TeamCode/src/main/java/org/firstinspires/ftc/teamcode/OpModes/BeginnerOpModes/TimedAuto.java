package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.Hardware.FinalBoard;
@Autonomous
@Disabled
public class TimedAuto extends OpMode {
    FinalBoard board = new FinalBoard();
    private int count = 0;
    double lastTime;

    public void init() {
        board.init(hardwareMap);
    }

    public void start() {
        count = 0;
        resetRuntime();
        lastTime = getRuntime();
    }

    public void loop() {
        telemetry.addData("Stage", count);
        telemetry.addData("Runtime", getRuntime());
        telemetry.addData("Time in State", getRuntime() - lastTime);
        telemetry.addData("Motor Speed", board.getMotorSpeed());
        switch (count) {
            case 0:
                if(getRuntime() >= 3); {
                    count++;
                    lastTime = getRuntime();
                    board.setMotorSpeed(.25);
            }
            break;
            case 1:
                if(getRuntime() >= lastTime + 3) {
                    count++;
                    lastTime = getRuntime();
                    board.setMotorSpeed(.5);
                }
                break;
            case 2:
                if(getRuntime() >= lastTime + 3) {
                    count++;
                    lastTime = getRuntime();
                    board.setMotorSpeed(.75);
                }
                break;
            case 3:
                if(getRuntime() >= lastTime + 3) {
                    count++;
                    lastTime = getRuntime();
                    board.setMotorSpeed(1.0);
                }
                break;
            case 4:
                if(getRuntime() >= lastTime + 5.0) {
                    count++;
                    lastTime = getRuntime();
                }
                break;
            default:
                board.setMotorSpeed(0.0);
                telemetry.addData("Auto", "Finished");

        }
    }
}
