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

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Hardware.LiftConfig;
import org.firstinspires.ftc.teamcode.Hardware.MecanumDriveConfig;



@TeleOp
public class PowerPlayBot extends OpMode {

    /* Declare OpMode members. */
    MecanumDriveConfig robot = new MecanumDriveConfig();   // Use a Pushbot's hardware

    LiftConfig lift = new LiftConfig();

    Servo servo1;
    Servo servo2;
    boolean leftBumperAlreadyPressed;

    boolean servoIn;
    public static int targetPosition = 0;
    double magnitude = .8;
    public void init() {
        robot.init(hardwareMap, DcMotor.RunMode.RUN_USING_ENCODER);
        lift.init(hardwareMap);
        servo1 = hardwareMap.get(Servo.class,"claw1");
        servo2 = hardwareMap.get(Servo.class,"claw2");
        telemetry.addData("Say", "Hello Driver");    //
        telemetry.update();
    }

    public void start() {
        gamepad1.rumble(1000);
    }

    public void loop() {
        telemetry.addData("Speed from 0-1.0 : adjust using dpad", magnitude);
        if(gamepad1.dpad_up) {
            magnitude += .01;
        }
        else if(gamepad1.dpad_down) {
            magnitude -= .001;
        }
        double y = -gamepad1.left_stick_y; // Remember, this is reversed!
        double x = gamepad1.left_stick_x * 1.1; // Counteract imperfect strafing
        double rx = gamepad1.right_stick_x;

        // Denominator is the largest motor power (absolute value) or 1
        // This ensures all the powers maintain the same ratio, but only when
        // at least one is out of the range [-1, 1]
        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
        double frontLeftPower = (y + x + rx) / denominator * magnitude;
        double backLeftPower = (y - x + rx) / denominator * magnitude;
        double frontRightPower = (y - x - rx) / denominator * magnitude;
        double backRightPower = (y + x - rx) / denominator * magnitude;

        robot.leftFront.setPower(frontLeftPower);
        robot.leftRear.setPower(backLeftPower);
        robot.rightFront.setPower(frontRightPower);
        robot.rightRear.setPower(backRightPower);

        lift.leftLift.setTargetPosition(targetPosition);
        lift.rightLift.setTargetPosition(-targetPosition);

        telemetry.addData("left",lift.leftLift.getCurrentPosition());
        telemetry.addData("right", lift.rightLift.getCurrentPosition());

        if(lift.liftBusy()) {
            lift.leftLift.setPower(1.0);
            lift.rightLift.setPower(1.0);
        }
        if(gamepad1.a) {
            targetPosition = 1000;
        }
        if(gamepad1.y) {
            targetPosition = 2300;
        }
        if(gamepad1.x) {
            targetPosition = 1800;
        }
        else if(gamepad1.b){
            targetPosition = 0;
        }
        if(gamepad1.left_bumper && !leftBumperAlreadyPressed) {
            servoIn = !servoIn;
            telemetry.addData("Motor", servoIn);
            if(servoIn) {
                servo1.setPosition(.7);
                servo2.setPosition(.3);
                targetPosition = 0;

            }
            else {
                servo1.setPosition(.45);
                servo2.setPosition(.55);
                resetRuntime();
            }
        }
        leftBumperAlreadyPressed = gamepad1.left_bumper;
        if(getRuntime() >.5 && getRuntime() < .6) {
            targetPosition = 150;
        }
        telemetry.addData("target pos",targetPosition);
        telemetry.addData("Servo Position",servo1.getPosition());
    }
}
