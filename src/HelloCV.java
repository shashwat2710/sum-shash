//import java.awt.image.BufferedImage;
//import org.opencv.core.Core;
//import org.opencv.core.CvType;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
public class HelloCV {
		public static void main(String[] args){
//                System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
//                Mat mat = Mat.eye(3, 3, CvType.CV_8UC1);
//                System.out.println("mat = " + mat.dump());
			System.out.println("Calling load Image");
			loadImage load=new loadImage();
			Mat buffer =load.Load();//calling function to load image
			processImage process=new processImage(buffer);
			process.Process();
			
			
			
	
        }
}


//Mat grad_x=new Mat(), grad_y=new Mat();
//Mat abs_grad_x=new Mat(), abs_grad_y=new Mat();
//int scale = 1;
//int delta = 0;
//int ddepth=CvType.CV_16S;
//Imgproc.Sobel( dst2, grad_x, ddepth, 1, 0, 3, scale, delta, 4 );
///// Gradient Y
//Core.convertScaleAbs(grad_x,abs_grad_x);
//Imgproc.Sobel( dst2, grad_y, ddepth, 0, 1, 3, scale, delta, 4 );
////
//Core.convertScaleAbs(grad_y,abs_grad_y);
////
//Core.addWeighted(abs_grad_x,0.5,abs_grad_y,0.5,0,dst2);