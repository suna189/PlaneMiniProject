package AirLineProgram.Run;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class AirPortButton extends JButton implements SettingInterface {

	ImageIcon btnIcon;

	public AirPortButton(int x, int y, File BUTTON_PATH) {

		// ImageIcon 스케일 조정
		Image img = null;
		try {
			img = ImageIO.read(BUTTON_PATH);
		} catch (IOException e) {
			System.out.println("BUTTON : AirPortButton error");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int[] scale = FileSizeChk.getSize(BUTTON_PATH, CHECK);
		
		img = img.getScaledInstance(scale[0], scale[1], Image.SCALE_SMOOTH);

		btnIcon = new ImageIcon(img);

		// 버튼 생성
		setIcon(btnIcon);

		// 버튼 크기 및 투명화
		setBounds(x, y, btnIcon.getIconWidth(), btnIcon.getIconHeight());
		setBorderPainted(false);
		setContentAreaFilled(false);

	}

	public void setEvent(AirPortButton btn) {
		addActionListener(new MouseEventCall(this, 2));

	}

	public ImageIcon getBtnIcon() {
		return btnIcon;
	}

}
