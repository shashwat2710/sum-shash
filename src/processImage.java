//import java.awt.image.BufferedImage;
import org.opencv.core.Core;

import org.opencv.core.Core.MinMaxLocResult;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.highgui.HighGui;
import org.opencv.highgui.ImageWindow;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.core.Core.*;

class processImage {
	Mat img;
	processImage(Mat img)//constructor to load image
	{
		this.img=img;
		
	};
	void Process(){
	Mat grey = new Mat();
	Imgproc.cvtColor( this.img,grey,Imgproc.COLOR_BGR2GRAY );
//	Mat sobelx = new Mat();
  //  Imgproc.Sobel(grey, sobelx, CvType.CV_32F, 1, 0);
  //  MinMaxLocResult res = Core.minMaxLoc(sobelx); // find minimum and maximum intensities
    //Mat draw = new Mat();
    //double maxVal = res.maxVal, minVal = res.minVal;
    //sobelx.convertTo(draw, CvType.CV_8U, 255.0 / (maxVal - minVal), -minVal * 255.0 / (maxVal - minVal));
//    HighGui.namedWindow("Vechile", HighGui.WINDOW_AUTOSIZE);
//    HighGui.imshow("Vechile", draw);
//    HighGui.waitKey();
    
	
     //********************************greyscale*****************/
     Mat dst=new Mat();
     Mat dst2=new Mat();
     Mat dst3=new Mat();
     Mat dst4=new Mat();
     Imgproc.blur(grey, dst, new Size(3, 3));
    Imgproc.GaussianBlur(dst, dst, new Size(3, 3), 0);
    Mat kernel_1= Mat.ones(new Size(5, 5),0);
    
    // Imgproc.medianBlur(dst, dst, 3);
    // Imgproc.bilateralFilter(dst, dst, -1, 0, 0);
    Imgproc.erode(dst, dst, kernel_1);
    Imgproc.dilate(dst, dst, kernel_1);
     
     
//     fastNlMeansDenoising(dst.nativeObj, dst2.nativeObj);
     System.out.println("Gaussian blur called:");
     //*****************************gaussian ******************//
  ;
    // cvSmooth(this.img,dst2,CV_GAUSSIAN,7);
     
     Imgproc.threshold(grey,dst2,150,255,Imgproc.THRESH_BINARY);
    // Imgproc.Canny(dst2,dst2, 0, 0);
     Mat horizontal = dst2.clone();
     Mat vertical = dst2.clone();
     int horizontalsize = horizontal.cols() / 30;
     
     Mat horizontalStructure = Imgproc.getStructuringElement(Imgproc.MORPH_RECT,new Size(horizontalsize,1));
     
     Imgproc.erode(horizontal, horizontal, horizontalStructure, new Point(-1, -1),0);
     Imgproc.dilate(horizontal, horizontal, horizontalStructure,new Point(-1, -1),0);
//   HighGui.imshow("horizontal", horizontal);
//   HighGui.waitKey();
   int verticalsize = vertical.rows() / 30;
   Mat verticalStructure =Imgproc.getStructuringElement(Imgproc.MORPH_RECT,new Size( 1,verticalsize));
   Imgproc.erode(vertical, vertical, verticalStructure,new Point(-1, -1),0);
  Imgproc.dilate(vertical, vertical, verticalStructure,new Point(-1, -1),0);
//  HighGui.imshow("vertical", vertical);
//  HighGui.waitKey();
  Core.bitwise_not(vertical, vertical);

   // Imgproc.findContours(dst3, null, dst3, 0, 0);
//     Mat floodfilled = Mat.zeros(dst3.rows() + 2, dst3.cols() + 2, CvType.CV_8U);
//     Point flood=new Point(1,1);
  
     
  Mat edges=new Mat();
  Imgproc.threshold(vertical,edges,0,255,Imgproc.THRESH_BINARY_INV);
  Mat kernel= Mat.ones(2, 2,CvType.CV_8UC1);
  Imgproc.dilate(edges, edges, kernel);
  Mat smooth=new Mat();
  vertical.copyTo(smooth);
  Imgproc.blur(smooth, smooth, new Size(2, 2));
  smooth.copyTo(vertical, edges);
  Imgproc.floodFill(edges ,dst4,new Point(1,1),new Scalar(255, 255, 255));

  
  
  
     
  //  displayimage.displayImage(displayimage.Mat2BufferedImage(vertical));
    displayimage.displayImage(displayimage.Mat2BufferedImage(edges));
     
	}
	
	

}
