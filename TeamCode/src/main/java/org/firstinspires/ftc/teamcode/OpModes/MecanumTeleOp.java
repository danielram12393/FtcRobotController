/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Hardware.MecanumDriveConfig;
import org.firstinspires.ftc.teamcode.HardwareTests.TestItem;

import java.util.ArrayList;

/**
 * This OpMode uses the common Pushbot hardware class to define the devices on the robot.
 * All device access is managed through the HardwarePushbot class.
 * The code is structured as a LinearOpMode
 *
 * This particular OpMode executes a POV Game style Teleop for a PushBot
 * In this mode the left stick moves the robot FWD and back, the Right stick turns left and right.
 * It raises and lowers the claw using the Gampad Y and A buttons respectively.
 * It also opens and closes the claws slowly using the left and right Bumper buttons.
 *
 * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */
@Disabled
@TeleOp(name="Mecanum: Teleop", group="Mecanum")
public class MecanumTeleOp extends OpMode {

    /* Declare OpMode members. */
    MecanumDriveConfig robot = new MecanumDriveConfig();   // Use a Pushbot's hardware
    double angle, turn, magnitude;
    ArrayList<TestItem> tests;

    @Override
    public void init() {
        robot.init(hardwareMap);
        telemetry.addData("Say", "Hello Driver");    //
        telemetry.update();
        tests = robot.getTests();
    }

    public void loop() {
        angle = Math.atan2(gamepad1.left_stick_y, gamepad1.left_stick_x);
        magnitude = ((gamepad1.left_stick_x * gamepad1.left_stick_x) + (gamepad1.left_stick_y * gamepad1.left_stick_y));
        turn = gamepad1.right_stick_x * .7;
        magnitude *= .7;

                /*
                All of these calculations are subject to change due to motors.
                If they don't work for you, sometimes placing a negative sign right before
                Math.sin or replacing +/- between angle and 0.25 can help if it's
                a per-wheel error. If it still doesn't work, hit me up!
                */
        robot.leftFront.setPower((Math.sin(angle - 0.25 * Math.PI) * magnitude) - turn);
        robot.leftRear.setPower((Math.sin(angle - 0.25 * Math.PI) * magnitude) + turn);
        robot.rightFront.setPower((Math.sin(angle + 0.25 * Math.PI) * magnitude) + turn);
        robot.leftRear.setPower((Math.sin(angle + 0.25 * Math.PI) * magnitude) - turn);

        // Telemetry for all motor powers. Helpful for troubleshooting if necessary.
        telemetry.addData("FL", robot.leftFront.getPower());
        telemetry.addData("FR", robot.rightFront.getPower());
        telemetry.addData("RL", robot.leftRear.getPower());
        telemetry.addData("RR", robot.rightRear.getPower());


        telemetry.update();
    }
}
