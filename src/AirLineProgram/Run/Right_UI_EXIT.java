package AirLineProgram.Run;

import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Right_UI_EXIT extends JButton implements SettingInterface {
	
	/*
	 * Right_UI_EXIT ( 2019.10.16 )
	 * 
	 */
	
	
// Right_UI_EXIT Button Object Constructor Start ------------------------------------------------------------------------------------------------
	
	public Right_UI_EXIT(int x, int y, Right_UI GUI) {

		// Right_UI_EXIT Button Image Setting
		
		// Right_UI_EXIT Button Image Resizing
		
		Image img = null;

		try {
			img  = ImageIO.read(X_BUTTON_PAHT);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("RIGHT UI : X Button Error");
			e.printStackTrace();
		}
		
		int[] scale = FileSizeChk.getSize(X_BUTTON_PAHT, CHECK);
		
		img = img.getScaledInstance(scale[0], scale[1], Image.SCALE_SMOOTH);

		// Right_UI_EXIT Button Image Painting
		
		ImageIcon exitImageIcon = new ImageIcon(img);

		
		
		// Right_UI_EXIT Button Setting
		
		setLayout(null);
		setIcon(exitImageIcon); // Button Image add
		setBounds(x, y, exitImageIcon.getIconWidth(), exitImageIcon.getIconHeight()); // Location Setting
		setBorderPainted(false);
		setContentAreaFilled(false);
		
		
		
		// Right_UI_EXIT Button Event Setting
		
		addActionListener(new MouseEventCall(GUI, 3));
	}


// Right_UI_EXIT Button Object Constructor End ------------------------------------------------------------------------------------------------	
	
}
