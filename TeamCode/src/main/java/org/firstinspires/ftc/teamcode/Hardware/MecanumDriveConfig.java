package org.firstinspires.ftc.teamcode.Hardware;

import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.HardwareTests.ColorTest;
import org.firstinspires.ftc.teamcode.HardwareTests.DistanceTest;
import org.firstinspires.ftc.teamcode.HardwareTests.MotorTest;
import org.firstinspires.ftc.teamcode.HardwareTests.ServoTest;
import org.firstinspires.ftc.teamcode.HardwareTests.TestItem;

import java.util.ArrayList;

public class MecanumDriveConfig {
    public DcMotor leftFront, leftRear, rightRear, rightFront;

    public void init(HardwareMap hwMap) {
        //Gives each variable with the hardware type (DcMotor) and what hardware in our config to assign it to.
        leftFront = hwMap.get(DcMotor.class, "fL");
        leftRear = hwMap.get(DcMotor.class, "rL");
        rightRear = hwMap.get(DcMotor.class, "rR");
        rightFront = hwMap.get(DcMotor.class, "fR");
        //makes sure our motors travel in the correct direction, can be set back by replacing reverse with foward or
        //making the line of codes comments

        //frontLeft.setDirection(DcMotor.Direction.REVERSE);
        //rearLeft.setDirection(DcMotor.Direction.REVERSE);
        rightRear.setDirection(DcMotor.Direction.REVERSE);
        //frontRight.setDirection(DcMotor.Direction.REVERSE);

        //Makes it so when power of motors = 0 the motor quickly brakes instead of slowly lose power
        leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftRear.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightRear.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        for (LynxModule module : hwMap.getAll(LynxModule.class)) {
            module.setBulkCachingMode(LynxModule.BulkCachingMode.AUTO);
        }
    }

    public ArrayList<TestItem> getTests() {
        ArrayList<TestItem> tests = new ArrayList<>();
        tests.add(new MotorTest("front left motor and ticks", .5, leftFront));
        tests.add(new MotorTest("rear left motor and ticks", .5, leftRear));
        tests.add(new MotorTest("rear right motor and ticks", .5, rightRear));
        tests.add(new MotorTest("front right motor and ticks", .5, rightFront));
        return tests;
    }
}
