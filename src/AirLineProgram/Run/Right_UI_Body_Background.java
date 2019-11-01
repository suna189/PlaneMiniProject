package AirLineProgram.Run;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Right_UI_Body_Background extends JPanel implements SettingInterface {

	Image tmpImg;
	BufferedImage rightUiBodyBackground;

	public Right_UI_Body_Background() {

		try {
			tmpImg = ImageIO.read(RIGHT_UI_BODY_BACKGOUND_PATH);
		} catch (IOException e) {
			System.out.println("Right_UI_Body_Background : image path error");
			e.printStackTrace();
		}

		int[] scale = FileSizeChk.getSize(tmpImg, CHECK);
		tmpImg = tmpImg.getScaledInstance(scale[0], scale[1], Image.SCALE_SMOOTH);

		rightUiBodyBackground = new BufferedImage(tmpImg.getWidth(null), tmpImg.getHeight(null),
				BufferedImage.TYPE_INT_ARGB);

		Graphics g = rightUiBodyBackground.getGraphics();
		g.drawImage(tmpImg, 0, 0, null);
		g.dispose();

		setLayout(null);
		setBounds(RIGHT_UI_BODY_BACKGOUND[0], RIGHT_UI_BODY_BACKGOUND[1], rightUiBodyBackground.getWidth(),rightUiBodyBackground.getHeight());
		setVisible(true);

	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub

		g.drawImage(rightUiBodyBackground, 0, 0, rightUiBodyBackground.getWidth(), rightUiBodyBackground.getHeight(),this);
	}
}
