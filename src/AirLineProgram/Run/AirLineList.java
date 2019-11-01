package AirLineProgram.Run;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class AirLineList extends JPanel implements SettingInterface{

	Image tmpImg = null;
	BufferedImage img = null;
	int x;
	int y = (int) (123 * CHECK);

	public AirLineList(int uiSelectNum) throws IOException {
		
		if (uiSelectNum == 1) {
			tmpImg = ImageIO.read(INCHEON_AIRLINE_LIST);
			this.x = (int) (205 * CHECK);
		} else if (uiSelectNum == 2) {
			tmpImg = ImageIO.read(JFK_AIRLINE_LIST);
			this.x = (int) (156 * CHECK);
		} else if (uiSelectNum == 3) {
			tmpImg = ImageIO.read(PARIS_AIRLINE_LIST);
			this.x = (int) (218 * CHECK);
		} else if (uiSelectNum == 4) {
			tmpImg = ImageIO.read(BOLE_AIRLINE_LIST);
			this.x = (int) (184* CHECK);
		} else if (uiSelectNum == 5) {
			tmpImg = ImageIO.read(SYDNEY_AIRLINE_LIST);
			this.x = (int) (214 * CHECK);
		} else if (uiSelectNum == 6) {
			tmpImg = ImageIO.read(DUBAI_AIRLINE_LIST);
			this.x = (int) (184 * CHECK);
		}
		
		int[] scale = FileSizeChk.getSize(tmpImg, CHECK);
		
		tmpImg = tmpImg.getScaledInstance(scale[0], scale[1], Image.SCALE_SMOOTH);
		img = new BufferedImage(tmpImg.getWidth(null), tmpImg.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		Graphics g = img.getGraphics();
		g.drawImage(tmpImg, 0, 0, null);
		g.dispose();
		
		setLayout(null);
		setBounds(x, y, img.getWidth(), img.getHeight());
		setVisible(false);
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(img, 0, 0, img.getWidth(), img.getHeight(), this);

	}
}