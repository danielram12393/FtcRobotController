package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.Pipelines.DrawRectanglePipeline;
import org.firstinspires.ftc.teamcode.Pipelines.GrayPipeline;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvWebcam;

@Autonomous
public class OpenCVOpMode2  extends OpMode {
    OpenCvWebcam webcam;

    @Override
    public void init() {
        int cameraMoniterViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        webcam = OpenCvCameraFactory.getInstance().createWebcam(hardwareMap.get(WebcamName.class, "WebcamMain"), cameraMoniterViewId);
        webcam.setPipeline(new DrawRectanglePipeline());
        webcam.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener() {
        @Override
        public void onOpened() {
            webcam.startStreaming(320, 240, OpenCvCameraRotation.UPRIGHT);
            }

        @Override
        public void onError(int errorCode) {
            /*
            * This will be called if the camera could not be opened
            */
            }
        });
    }
    @Override
    public void start() {
        webcam.stopStreaming();
    }
    @Override
    public void loop() {

    }
}
