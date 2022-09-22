package org.firstinspires.ftc.teamcode.Pipelines;

import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvPipeline;

public class DrawRectanglePipeline extends OpenCvPipeline {
    public Scalar nonSelectorColor = new Scalar(0, 255, 0);

    public Rect rect1 = new Rect(20, 150, 50, 50);

    @Override
    public Mat processFrame(Mat input) {
        Imgproc.rectangle(input, rect1, nonSelectorColor);
        return input;
    }
}
