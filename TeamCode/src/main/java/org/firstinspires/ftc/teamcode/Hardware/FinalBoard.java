package org.firstinspires.ftc.teamcode.Hardware;
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.teamcode.HardwareTests.ColorTest;
import org.firstinspires.ftc.teamcode.HardwareTests.DistanceTest;
import org.firstinspires.ftc.teamcode.HardwareTests.MotorTest;
import org.firstinspires.ftc.teamcode.HardwareTests.ServoTest;
import org.firstinspires.ftc.teamcode.HardwareTests.TestItem;

import java.util.ArrayList;

public class FinalBoard {
    private DcMotor motor;
    private double ticksPerRotation;
    private Servo servo;
    private AnalogInput pot;
    private ColorSensor colorSensor;
    private DistanceSensor distanceSensor;
    private BNO055IMU imu;

    public void init(HardwareMap hwMap) {
        motor = hwMap.get(DcMotor.class, "motor");
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        ticksPerRotation = motor.getMotorType().getTicksPerRev();
        servo = hwMap.get(Servo.class, "servo");
        pot = hwMap.get(AnalogInput.class, "pot");

        colorSensor = hwMap.get(ColorSensor.class, "colorSensor");
        distanceSensor = hwMap.get(DistanceSensor.class, "distanceSensor");
        imu = hwMap.get(BNO055IMU.class, "imu");
        BNO055IMU.Parameters params = new BNO055IMU.Parameters();
        // change to default set of parameters go here
        imu.initialize(params);
    }

    public void setMotorSpeed(double speed){
        motor.setPower(speed);
    }
    public double getMotorRotations(){
        return motor.getCurrentPosition() / ticksPerRotation;
    }
    public void setServoPosition(double position){
        servo.setPosition(position);
        }
    public double getPotAngle(){
        return Range.scale(pot.getVoltage(), 0, pot.getMaxVoltage(), 0, 270);
    }
    public int getAmountRed(){
        return colorSensor.red();
    }
    public double getDistance(DistanceUnit du){
        return distanceSensor.getDistance(du);
    }
    public double getHeading(AngleUnit angleUnit) {
        Orientation angles = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX,angleUnit);
        return angles.firstAngle;
    }
    public double getMotorSpeed() {
        return motor.getPower();
    }

    public ArrayList<TestItem> getTests() {
        ArrayList<TestItem> tests = new ArrayList<>();
        tests.add(new MotorTest("Runs Motor Forward and Tracks Ticks", .5, motor));
        tests.add(new ServoTest("Runs servo to position", 1.0, servo));
        tests.add(new ColorTest("Gives Color amounts", colorSensor));
        tests.add(new DistanceTest("Gives Distance in inches: ", DistanceUnit.INCH, distanceSensor));
        return tests;
    }
}


