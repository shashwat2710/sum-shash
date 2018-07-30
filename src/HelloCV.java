//import java.awt.image.BufferedImage;
//import org.opencv.core.Core;
//import org.opencv.core.CvType;
import org.opencv.core.Mat;
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