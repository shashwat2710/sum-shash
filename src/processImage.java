//import java.awt.image.BufferedImage;
import org.opencv.core.Core;

import org.opencv.core.Core.MinMaxLocResult;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgproc.Imgproc;

class processImage {
	Mat img;
	processImage(Mat img)//constructor to load image
	{
		this.img=img;
		System.out.println("process Image called");
	};
	void Process(){
	Mat grey = new Mat();
	Imgproc.cvtColor( this.img,grey,Imgproc.COLOR_BGR2GRAY );
	 Mat sobelx = new Mat();
     Imgproc.Sobel(grey, sobelx, CvType.CV_32F, 1, 0);
     MinMaxLocResult res = Core.minMaxLoc(sobelx); // find minimum and maximum intensities
     Mat draw = new Mat();
     double maxVal = res.maxVal, minVal = res.minVal;
     sobelx.convertTo(draw, CvType.CV_8U, 255.0 / (maxVal - minVal), -minVal * 255.0 / (maxVal - minVal));
//     HighGui.namedWindow("Vechile", HighGui.WINDOW_AUTOSIZE);
//     HighGui.imshow("Vechile", draw);
//     HighGui.waitKey();
     //********************************greyscale*****************/
     Mat thresh = new Mat();
     Imgproc.threshold(grey, thresh, 30, 255, Imgproc.THRESH_BINARY_INV);
   HighGui.namedWindow("Vechile", HighGui.WINDOW_AUTOSIZE);
   HighGui.imshow("Vechile", draw);
   HighGui.waitKey();
     
	};

}
