package org.firstinspires.ftc.teamcode.Hardware;

import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.checkerframework.checker.units.qual.degrees;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.HardwareTests.ColorTest;
import org.firstinspires.ftc.teamcode.HardwareTests.DistanceTest;
import org.firstinspires.ftc.teamcode.HardwareTests.MotorTest;
import org.firstinspires.ftc.teamcode.HardwareTests.ServoTest;
import org.firstinspires.ftc.teamcode.HardwareTests.TestItem;

import java.util.ArrayList;

public class MecanumDriveConfig {
    public DcMotor leftFront, leftRear, rightRear, rightFront;

    public void init(HardwareMap hwMap, DcMotor.RunMode runMode) {
        //Gives each variable with the hardware type (DcMotor) and what hardware in our config to assign it to.
        leftFront = hwMap.get(DcMotor.class, "fL");
        leftRear = hwMap.get(DcMotor.class, "rL");
        rightRear = hwMap.get(DcMotor.class, "rR");
        rightFront = hwMap.get(DcMotor.class, "fR");
        //makes sure our motors travel in the correct direction, can be set back by replacing reverse with foward or
        //making the line of codes comments

        leftFront.setDirection(DcMotor.Direction.REVERSE);
        leftRear.setDirection(DcMotor.Direction.REVERSE);
        //rightRear.setDirection(DcMotor.Direction.REVERSE);
        //frontRight.setDirection(DcMotor.Direction.REVERSE);

        if(runMode == DcMotor.RunMode.RUN_TO_POSITION) {
            leftFront.setTargetPosition(0);
            leftRear.setTargetPosition(0);
            rightRear.setTargetPosition(0);
            rightFront.setTargetPosition(0);
        }
        leftFront.setMode(runMode);
        leftRear.setMode(runMode);
        rightRear.setMode(runMode);
        rightFront.setMode(runMode);

        //Makes it so when power of motors = 0 the motor quickly brakes instead of slowly lose power
        leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftRear.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightRear.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        for (LynxModule module : hwMap.getAll(LynxModule.class)) {
            module.setBulkCachingMode(LynxModule.BulkCachingMode.AUTO);
        }
    }

    public void resetEncoders() {
        leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftRear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightRear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public ArrayList<TestItem> getTests() {
        ArrayList<TestItem> tests = new ArrayList<>();
        tests.add(new MotorTest("front left motor and ticks", 1, leftFront));
        tests.add(new MotorTest("rear left motor and ticks", 1, leftRear));
        tests.add(new MotorTest("rear right motor and ticks", 1, rightRear));
        tests.add(new MotorTest("front right motor and ticks", 1, rightFront));
        return tests;
    }

    public void moveStraight(double inchDistance, double power) {
        final double wheelCircumference = 3.77953 * Math.PI;
        int encoderAmount = (int) Math.round(inchDistance / wheelCircumference * 537.7);

        leftFront.setTargetPosition(encoderAmount);
        leftRear.setTargetPosition(encoderAmount);
        rightRear.setTargetPosition(encoderAmount);
        rightFront.setTargetPosition(encoderAmount);

        leftFront.setPower(power);
        leftRear.setPower(power);
        rightRear.setPower(power);
        rightFront.setPower(power);

        if(!leftFront.isBusy() && !leftRear.isBusy() && !rightRear.isBusy() && !rightFront.isBusy()) {
            leftFront.setPower(0);
            leftRear.setPower(0);
            rightRear.setPower(0);
            rightFront.setPower(0);
        }
    }
    public void strafe(double inchDistance, double power) {
        final double STRAFE_ERROR = 1.14;
        final double wheelCircumference = 3.77953 * Math.PI;
        int encoderAmount = (int) Math.round(inchDistance / wheelCircumference * 537.7 * STRAFE_ERROR) ;

        leftFront.setTargetPosition(encoderAmount);
        leftRear.setTargetPosition(-encoderAmount);
        rightRear.setTargetPosition(encoderAmount);
        rightFront.setTargetPosition(-encoderAmount);

        leftFront.setPower(power);
        leftRear.setPower(power);
        rightRear.setPower(power);
        rightFront.setPower(power);

        if(!leftFront.isBusy() && !leftRear.isBusy() && !rightRear.isBusy() && !rightFront.isBusy()) {
            leftFront.setPower(0);
            leftRear.setPower(0);
            rightRear.setPower(0);
            rightFront.setPower(0);
        }
    }
    public void turn(int degrees, double power, int direction) {
        int encoderAmount =  1625 * degrees / 180;
        if(direction == -1) {
            leftRear.setTargetPosition(encoderAmount);
            leftFront.setTargetPosition(encoderAmount);
            rightFront.setTargetPosition(-encoderAmount);
            rightRear.setTargetPosition(-encoderAmount);
        }
        if(direction == 1) {
            leftRear.setTargetPosition(-encoderAmount);
            leftFront.setTargetPosition(-encoderAmount);
            rightFront.setTargetPosition(encoderAmount);
            rightRear.setTargetPosition(encoderAmount);
        }
        leftFront.setPower(power);
        leftRear.setPower(power);
        rightRear.setPower(power);
        rightFront.setPower(power);

    }
    public void moveDiagnally(double inchDistance, double power, int direction) {
        //when direction is 1 we move across y=x and when direction is -1 we move across y=-x line
        final double DIAGONOL_ERROR = 1.5;
        final double wheelCircumference = 3.77953 * Math.PI;
        int encoderAmount = (int) Math.round(inchDistance / wheelCircumference * 537.7 * DIAGONOL_ERROR) ;

        if(direction == -1) {
            leftRear.setTargetPosition(encoderAmount);
            rightFront.setTargetPosition(encoderAmount);
        }
        if(direction == 1) {
            leftFront.setTargetPosition(encoderAmount);
            rightRear.setTargetPosition(encoderAmount);
        }
        leftFront.setPower(power);
        leftRear.setPower(power);
        rightRear.setPower(power);
        rightFront.setPower(power);

        if(!leftFront.isBusy() && !leftRear.isBusy() && !rightRear.isBusy() && !rightFront.isBusy()) {
            leftFront.setPower(0);
            leftRear.setPower(0);
            rightRear.setPower(0);
            rightFront.setPower(0);
        }
    }

    public void resetRunMode(DcMotor.RunMode runMode) {
        leftFront.setMode(runMode);
        leftRear.setMode(runMode);
        rightRear.setMode(runMode);
        rightFront.setMode(runMode);
    }

    public boolean motorsAreBusy() {
        return leftFront.isBusy() || leftRear.isBusy() || rightRear.isBusy() || rightFront.isBusy();
    }
}
