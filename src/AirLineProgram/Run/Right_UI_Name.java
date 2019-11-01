package AirLineProgram.Run;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Right_UI_Name extends JPanel implements SettingInterface{
	Image tmpImg = null;
	BufferedImage img = null;
	
	public Right_UI_Name(int uiSelectNum) throws IOException {
		if(uiSelectNum == 1) {
			tmpImg = ImageIO.read(UI_NAME_INCHEON);
		} else if (uiSelectNum == 2) {
			tmpImg = ImageIO.read(UI_NAME_JFK);
		} else if (uiSelectNum == 3) {
			tmpImg = ImageIO.read(UI_NAME_PARIS);
		} else if (uiSelectNum == 4) {
			tmpImg = ImageIO.read(UI_NAME_BOLE);
		} else if (uiSelectNum == 5) {
			tmpImg = ImageIO.read(UI_NAME_SYDNEY);
		} else if (uiSelectNum == 6) {
			tmpImg = ImageIO.read(UI_NAME_DUBAI);
		}

		int[] scale = FileSizeChk.getSize(tmpImg, CHECK);
		tmpImg = tmpImg.getScaledInstance(scale[0], scale[1], Image.SCALE_SMOOTH);
		img = new BufferedImage(tmpImg.getWidth(null), tmpImg.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		Graphics g = img.getGraphics();
		g.drawImage(tmpImg, 0, 0, null);
		g.dispose();
		
		setLayout(null);
		setBounds(UI_NAME[0], UI_NAME[1],img.getWidth(),img.getHeight());
	
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, img.getWidth(), img.getHeight(), this);
	}
}
