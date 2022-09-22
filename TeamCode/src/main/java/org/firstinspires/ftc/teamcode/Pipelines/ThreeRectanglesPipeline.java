package org.firstinspires.ftc.teamcode.Pipelines;


import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvPipeline;

public class ThreeRectanglesPipeline extends OpenCvPipeline {
    Scalar nonSelectedColor = new Scalar(0, 255, 0);
    Scalar selectedColor = new Scalar(0, 0, 255);

    public int selectedRect = -1;

    public Rect rect1 = new Rect(110, 42, 40, 40);
    public Rect rect2 = new Rect(160, 42, 40, 40);
    public Rect rect3 = new Rect(210, 42, 40, 40);

    Mat hsvMat = new Mat();

    public int findRect(Mat input) {
        Imgproc.cvtColor(input, hsvMat, Imgproc.COLOR_RGB2HSV);
        double satRect1 = getAvgSaturation(hsvMat, rect1);
        double satRect2 = getAvgSaturation(hsvMat, rect2);
        double satRect3 = getAvgSaturation(hsvMat, rect3);

        if((satRect1 > satRect2) && (satRect1 > satRect3)) {
            return 1;
        }
        else if((satRect2 > satRect3) && (satRect2 > satRect1)) {
            return 2;
        }
        return 3;
    }

    protected double getAvgSaturation(Mat input, Rect rect) {
        Mat submat = input.submat(rect);
        Scalar color = Core.mean(submat);
        return color.val[1];
    }

    @Override
    public Mat processFrame(Mat input) {
        selectedRect = findRect(input);
        //when making decisions based on selected rectangle, call it using ThreeRectanglesPipeline.selectedRect as an int
        //then make if or while statements based on that, a number 1-3.
        drawRectangles(input);

        return input;
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
