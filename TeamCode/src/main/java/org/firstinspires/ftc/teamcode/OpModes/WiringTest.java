package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Hardware.FinalBoard;
import org.firstinspires.ftc.teamcode.Hardware.MecanumDriveConfig;
import org.firstinspires.ftc.teamcode.HardwareTests.TestItem;

import java.util.ArrayList;

@TeleOp(name = "Mecanum: Wiring Test", group = "Mecanum")
public class WiringTest extends OpMode {
    MecanumDriveConfig board = new MecanumDriveConfig();
    ArrayList<TestItem> tests;
    boolean wasUp, wasDown;
    int testNum;

    public void init() {
        board.init(hardwareMap, DcMotor.RunMode.RUN_USING_ENCODER);
        tests = board.getTests();
    }

    public void loop() {
        if (gamepad1.dpad_up && !wasUp) {
            testNum--;
            if (testNum < 0) {
                testNum = tests.size() - 1 ;
            }
        }
        wasUp = gamepad1.dpad_up;
        if (gamepad1.dpad_down && !wasDown) {
            testNum++;
            if (testNum >= tests.size()) {
                testNum = 0;
            }
        }
        wasDown = gamepad1.dpad_down;
        telemetry.addLine("Use up and down Dpad to scroll through tests");
        telemetry.addLine("Press A to run test");
        telemetry.addLine("==========================================");
        TestItem currTest = tests.get(testNum);
        telemetry.addData("Current Test Description: ", currTest.getDescription());
        currTest.run(gamepad1.a, telemetry);
        telemetry.addLine("==========================================");
        telemetry.addLine("Test List:");
        for(int i = 0; i < tests.size(); i++) {
            telemetry.addLine(tests.get(i).getDescription());
        }
    }
}
