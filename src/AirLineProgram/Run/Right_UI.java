package AirLineProgram.Run;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Right_UI extends JPanel implements SettingInterface {

	/*
	 * Right_UI ( 2019.10.16 )
	 * 
	 */

// Variable Start --------------------------------------------------------------------------------------------------------------------	

	AirPortButton btn;
	JButton exit;
	JPanel BackScreen;
	BufferedImage RightUI;
	
	int uiSelectNum;

// Variable End  --------------------------------------------------------------------------------------------------------------------

// Right_UI Object Constructor Start ------------------------------------------------------------------------------------------------

	public Right_UI(int uiSelectNum) {

		// ( 2019 . 10 .17 )
		this.uiSelectNum = uiSelectNum;

		// Right_UI Background Image Print Object Setting

		// Right_UI Background Image Resizing

		Image tmpImg = null;
		try {
			tmpImg = ImageIO.read(RIGHTGUISCREEN_PATH);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.err.println("RIGHT UI : Screen Error");
			e1.printStackTrace();
		}

		int[] scale = FileSizeChk.getSize(tmpImg, CHECK); // ( 2019 . 10 . 23 Modify )
		tmpImg = tmpImg.getScaledInstance(scale[0],scale[1], Image.SCALE_SMOOTH);
		RightUI = new BufferedImage(tmpImg.getWidth(null), tmpImg.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		Graphics g = RightUI.getGraphics();
		g.drawImage(tmpImg, 0, 0, null);
		g.dispose();

		// Right_UI Background Image Painting

		BackScreen = new JPanel() {

			private static final long serialVersionUID = 1L;

			@Override
			public void paint(Graphics g) {
				// TODO Auto-generated method stub
				g.drawImage(RightUI, 0, 0, RightUI.getWidth(), RightUI.getHeight(), this);
			}
		};

		// Right_UI Background Image Size & Location Setting

		BackScreen.setBounds(0, 0, RightUI.getWidth(), RightUI.getHeight());
		add(BackScreen, 0, 0);

		// ( 2019 . 10. 21 add )
		AirLineList airList = null;
		try {
			airList = new AirLineList(uiSelectNum);
		} catch (IOException e1) {
			System.out.println("Right_UI_Header : AirLinePlusList Error");
			e1.printStackTrace();
		}

		// add JPanel, JScroll, JButton, JTable.... Put in Please!
		
		
		

		add(new Right_UI_Header(uiSelectNum, airList), 1, 0); // ( 2019. 10 . 17 ) add ( 2019 . 10 .21 ) modify
		add(new Right_UI_Body_Background(), 2, 0); // ( 2019. 10 . 17 ) add

//		StaticObject.table = new Right_UI_JTable(50, 325, uiSelectNum);
//		StaticObject.search = new Right_UI_Search(50, 275, StaticObject.table.getSorter());
//		
//		add(StaticObject.table,3,0);
//		add(StaticObject.search,4,0);
		
		add(new RIght_UI_JTable_ReButton(uiSelectNum),5,0);
		
		// Right Panel UI Setting

		add(new Right_UI_EXIT(RIGHT_UI_EXIT_BUTTON[0], RIGHT_UI_EXIT_BUTTON[1], this), 100, 0);

		// ( 2019. 10. 21 add )
		add(airList, 99, 0);

		// Panel name ( 2019 . 10 . 20 ) add

		Right_UI_Name name = null;
		try {
			name = new Right_UI_Name(uiSelectNum);
		} catch (IOException e) {

			System.out.println("Right_UI : Name Error");
			e.printStackTrace();
		}

		add(name, 101, 0);

		setLayout(null);
		setBackground(new Color(100,100,75));
		setBounds(RIGHT_UI[0], RIGHT_UI[1], RightUI.getWidth(), RightUI.getHeight()); // ( 2019 . 10. 23 Modify )
		setVisible(false);

	}

// Right_UI Object Constructor End ------------------------------------------------------------------------------------------------	

}
