package AirLineProgram.Run;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class FileSizeChk {
	
	/*
	 * FileSizeChk ( 2019.10.16 )
	 * 
	 */
	
	public static int[] getSize(File path, double chk) {
		int[] size = new int[2];

		try {
			BufferedImage img = ImageIO.read(path);
			size[0] = (int) ( img.getWidth() * chk );
			size[1] = (int) ( img.getHeight() * chk );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("FileSizeChk : Size Check Error");
			e.printStackTrace();
		}

		return size;
	}
	
	// ( 2019. 10 17 )
	
	public static int[] getSize(Image img, double chk) {
		int[] size = new int[2];

			size[0] = (int) ( img.getWidth(null) * chk );
			size[1] = (int) ( img.getHeight(null) * chk );
		
		return size;

	}

}
