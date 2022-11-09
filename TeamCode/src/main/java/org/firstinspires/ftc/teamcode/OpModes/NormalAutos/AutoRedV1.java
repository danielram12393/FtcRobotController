package org.firstinspires.ftc.teamcode.OpModes.NormalAutos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Hardware.ColorSensorConfig;
import org.firstinspires.ftc.teamcode.Hardware.MecanumDriveConfig;
@Autonomous
public class AutoRedV1 extends OpMode {

    MecanumDriveConfig robot = new MecanumDriveConfig();

    ColorSensorConfig color = new ColorSensorConfig();

    private double fLEncoder;
    private double rLEncoder;
    private double rREncoder;
    private double fREncoder;

    private int selectedZone;

    enum State {
        MOVE_TO_SIGNAL,
        DETECT,
        MOVE_TO_SCORE,
        SCORE,
        PARK_IN_ZONE_1,
        PARK_IN_ZONE_2,
        PARK_IN_ZONE_3;
    };

    State state = State.MOVE_TO_SIGNAL;



    public void init() {
        robot.init(hardwareMap, DcMotor.RunMode.RUN_TO_POSITION);
        robot.resetEncoders();
        robot.resetRunMode(DcMotor.RunMode.RUN_TO_POSITION);
        color.init(hardwareMap);

    }
    public void start() {
        resetRuntime();
    }
    @Override
    public void loop() {
        telemetry.addData("State", state);
        switch (state) {
            case MOVE_TO_SIGNAL:
                if(getRuntime() < 2 && getRuntime() > .5) {
                    robot.moveStraight(16.8, .4);
                }
                if(getRuntime() > 3) {
                    state = State.DETECT;
                    resetRuntime();
                    robot.resetEncoders();
                    robot.resetRunMode(DcMotor.RunMode.RUN_TO_POSITION);
                }
                break;
            case DETECT:
                selectedZone = color.getMostColor();
                telemetry.addData("Zone",selectedZone);
                if(getRuntime() > 2) {
                    state = State.MOVE_TO_SCORE;
                    resetRuntime();
                }
                break;
            case MOVE_TO_SCORE:
                if(getRuntime() < 1.5 && getRuntime() >.5 ) {
                    robot.moveStraight(10,.5);
                }
                if(getRuntime() > 1.6 && getRuntime() <2) {
                    robot.resetEncoders();
                    robot.resetRunMode(DcMotor.RunMode.RUN_TO_POSITION);
                }
                if(getRuntime() > 2 && getRuntime() < 3) {
                    robot.turn(90, .5, 1);
                }

                if(getRuntime() > 8) {
                    if(selectedZone == 0) {
                        state = State.PARK_IN_ZONE_1;
                    }
                    else if(selectedZone == 1) {
                        state = State.PARK_IN_ZONE_2;
                    }
                    else {
                        state = State.PARK_IN_ZONE_3;
                    }
                    robot.resetEncoders();
                    robot.resetRunMode(DcMotor.RunMode.RUN_TO_POSITION);
                }
                break;
            case SCORE:
                break;
            case PARK_IN_ZONE_1:
                robot.moveStraight(20,.5);
                break;
            case PARK_IN_ZONE_2:
                break;
            case PARK_IN_ZONE_3:
                robot.moveStraight(-26,.5);
                break;
            default:
                break;
        }
        telemetry.update();

    }
}
