import org.opencv.core.Core;

import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.core.Mat;
//import java.awt.*;
//import javax.swing.*;
import java.awt.image.*;
public class loadImage {
	public Mat Load(){
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		System.out.println("CAlled:load Image Function");
		String file="D:\\car.jpg";
		Mat matrix = Imgcodecs.imread(file);
		 System.out.println("Image Loaded");
		 displayimage disp=new displayimage();
		 BufferedImage image=disp.Mat2BufferedImage(matrix);
		 displayimage.displayImage(image);
		 return matrix;
	}
	
}
