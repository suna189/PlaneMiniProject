package AirLineProgram.Run;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class FlyLine extends JPanel implements SettingInterface{

	BufferedImage imgLine;
	
	public FlyLine() {
		
		Image tmpImg = null;

		try {
			tmpImg = ImageIO.read(new File(path + "Line.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.err.println("RIGHT UI : Screen Error");
			e1.printStackTrace();
		}

		int[] scale = FileSizeChk.getSize(tmpImg, CHECK);
		tmpImg = tmpImg.getScaledInstance(scale[0], scale[1], Image.SCALE_SMOOTH);
		imgLine = new BufferedImage(tmpImg.getWidth(null), tmpImg.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		Graphics g = imgLine.getGraphics();
		g.drawImage(tmpImg, 0, 0, null);
		g.dispose();

		
		setLayout(null);
		setBounds(0, 0, imgLine.getWidth() , imgLine.getHeight());
		setVisible(true);
	
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(imgLine, 0, 0, imgLine.getWidth(), imgLine.getHeight(), this);
	
	}
	
	
}
