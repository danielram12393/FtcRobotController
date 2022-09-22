package org.firstinspires.ftc.teamcode.Pipelines;


import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvPipeline;

public class FirstPipelineRevised extends OpenCvPipeline {
    Scalar nonSelectedColor = new Scalar(0, 255, 0);
    Scalar selectedColor = new Scalar(0, 0, 255);

    public int selectedRect = -1;

    public Rect rect1 = new Rect(110, 42, 40, 40);
    public Rect rect2 = new Rect(160, 42, 40, 40);
    public Rect rect3 = new Rect(210, 42, 40, 40);

    Mat hsvMat = new Mat();
    Mat destMat = new Mat();
    Mat detectionMat = new Mat();

    @Override
    public Mat processFrame(Mat input) {
        Imgproc.cvtColor(input, hsvMat, Imgproc.COLOR_RGB2HSV);
        Core.extractChannel(hsvMat, detectionMat, 1);
        Imgproc.cvtColor(detectionMat, destMat, Imgproc.COLOR_GRAY2RGB);

        drawRectangles(destMat);

        return destMat;
    }

    public void drawRectangles(Mat input) {
        Imgproc.rectangle(input, rect1, nonSelectedColor);
        Imgproc.rectangle(input, rect2, nonSelectedColor);
        Imgproc.rectangle(input, rect3, nonSelectedColor);
        if(selectedRect == 1) {
            Imgproc.rectangle(input, rect1, selectedColor);
        }
        else if(selectedRect == 2) {
            Imgproc.rectangle(input, rect2, selectedColor);
        }
        else if(selectedRect == 3) {
            Imgproc.rectangle(input, rect3, selectedColor);
        }
    }
}
