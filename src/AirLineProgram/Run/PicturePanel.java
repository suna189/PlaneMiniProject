package AirLineProgram.Run;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PicturePanel extends JPanel implements SettingInterface {

	String select;
	List<Image> imgList;
	int selectImgNum = 0;
	int chk;

	JButton btn00;
	JButton btn01;
	JButton btn02;

	JPanel me;

	mainPicture mainPanel;
	subPicture subPanel;

	Evnet btnEvent00;
	Evnet btnEvent01;
	Evnet btnEvent02;

	Image notImg;

	public PicturePanel(int selectNum) {

		if (selectNum == 1) {
			select = "incheon";
		} else if (selectNum == 2) {
			select = "jfk";
		} else if (selectNum == 3) {
			select = "paris";
		} else if (selectNum == 4) {
			select = "bole";
		} else if (selectNum == 5) {
			select = "sydney";
		} else if (selectNum == 6) {
			select = "dubai";
		}
		// TODO Auto-generated constructor stub

		setLayout(null);
		setBounds((int) (125 * CHECK), (int) (150 * CHECK), (int) (1005 * CHECK), (int) (580 * CHECK));
		setVisible(true);

		setting();
	}

	public void setting() {

		ImageIcon tmp;
		Image tmpImg = null;

		imgList = new ArrayList<Image>();
		String imgPath = path + "AirportPicture/" + select;
		String[] dir = new File(imgPath).list();
		
		try {
			notImg = ImageIO.read(NOTIMG);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (String input : dir) {
			int[] scale = FileSizeChk.getSize(new File(imgPath + "/" + input), CHECK);
			try {
				tmpImg = ImageIO.read(new File(imgPath + "/" + input));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tmpImg = tmpImg.getScaledInstance(scale[0], scale[1], Image.SCALE_SMOOTH);
			imgList.add(tmpImg);
		}

		this.me = this;
		mainPanel = new mainPicture();
		subPanel = new subPicture();
		add(new background(), 0, 0);
		add(mainPanel, 1, 0);
		add(subPanel, 2, 0);
		add(new PictureExit(), 3, 0);
	}

	class PictureExit extends JButton {

		Image tmpImg = null;

		public PictureExit() {
			setLayout(null);
			setBounds((int) (18 * CHECK), (int) (11 * CHECK), (int) (28 * CHECK), (int) (28 * CHECK));
			setBorderPainted(false);
			setContentAreaFilled(false);

			try {
				tmpImg = ImageIO.read(new File(path + "PictureExitBtn.png"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				System.err.println("RIGHT UI : Screen Error");
				e1.printStackTrace();
			}

			int[] scale = FileSizeChk.getSize(tmpImg, CHECK);
			tmpImg = tmpImg.getScaledInstance(scale[0], scale[1], Image.SCALE_SMOOTH);
			setIcon(new ImageIcon(tmpImg));
			addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					for (int i = 0; i < StaticObject.objectArray.length; i++) {
						AirPortButton btn = (AirPortButton) (StaticObject.objectArray[i][0]);
						if (btn.getX() < RIGHT_UI[0]) {
							btn.setEnabled(true);
						}
					}

					StaticObject.picturePanel.setVisible(false);
					RunProgram.mainFrame.getFrame().remove(StaticObject.picturePanel);
					RunProgram.mainFrame.getFrame().repaint();
					StaticObject.picturePanel = null;
				}
			});
		}
	}

	class background extends JPanel {
		BufferedImage imgBack;

		public background() {
			Image tmpImg = null;

			try {
				tmpImg = ImageIO.read(new File(path + "PicturePanelBackground.png"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				System.err.println("RIGHT UI : Screen Error");
				e1.printStackTrace();
			}

			int[] scale = FileSizeChk.getSize(tmpImg, CHECK);
			tmpImg = tmpImg.getScaledInstance(scale[0], scale[1], Image.SCALE_SMOOTH);
			imgBack = new BufferedImage(tmpImg.getWidth(null), tmpImg.getHeight(null), BufferedImage.TYPE_INT_ARGB);
			Graphics g = imgBack.getGraphics();
			g.drawImage(tmpImg, 0, 0, null);
			g.dispose();

			setBounds(0, 0, imgBack.getWidth(), imgBack.getHeight());
		}

		public void paint(Graphics g) {

			g.drawImage(imgBack, 0, 0, imgBack.getWidth(), imgBack.getHeight(), this);
		}
	}

	class mainPicture extends JPanel implements SettingInterface {
		Image mainImg;

		public mainPicture() {
			if(imgList.size() == 0) {
				mainImg=notImg.getScaledInstance((int) (725 * CHECK), (int) (491 * CHECK), Image.SCALE_SMOOTH);
			} else {
			this.mainImg = imgList.get(selectImgNum).getScaledInstance((int) (725 * CHECK), (int) (491 * CHECK),
					Image.SCALE_SMOOTH);
			}
			setBounds((int) (18 * CHECK), (int) (72 * CHECK), (int) (725 * CHECK), (int) (491 * CHECK));
			setVisible(true);
		}

		@Override
		public void paint(Graphics g) {
			g.drawImage(mainImg, 0, 0, mainImg.getWidth(null), mainImg.getHeight(null), this);
		}
	}

	class subPicture extends JPanel {

		public subPicture() {


			setLayout(null);
			setBounds((int) (757 * CHECK), (int) (72 * CHECK), (int) (230 * CHECK), (int) (492 * CHECK));
			setBackground(new Color(0, 0, 0, 0));

			btn00 = new JButton();
			btn01 = new JButton();
			btn02 = new JButton();

			btn00.setBounds(0, 0, (int) (230 * CHECK), (int) (156 * CHECK));
			btn01.setBounds(0, (int) (169 * CHECK), (int) (230 * CHECK), (int) (156 * CHECK));
			btn02.setBounds(0, (int) (336 * CHECK), (int) (230 * CHECK), (int) (156 * CHECK));

			btn00.setBorderPainted(false);
			btn01.setBorderPainted(false);
			btn02.setBorderPainted(false);

			btn00.setContentAreaFilled(false);
			btn01.setContentAreaFilled(false);
			btn02.setContentAreaFilled(false);

			add(btn00, 0, 0);
			add(btn01, 1, 0);
			add(btn02, 3, 0);

			btnEvent00 = new Evnet(btn00, me);
			btnEvent01 = new Evnet(btn01, me);
			btnEvent02 = new Evnet(btn02, me);

			btn00.setIcon(new ImageIcon(
					notImg.getScaledInstance((int) (230 * CHECK), (int) (156 * CHECK), Image.SCALE_SMOOTH)));

			if (imgList.size() == 0) {
				btn01.setIcon(new ImageIcon(
						notImg.getScaledInstance((int) (230 * CHECK), (int) (156 * CHECK), Image.SCALE_SMOOTH)));
			} else {
				btn01.setName("" + (selectImgNum));
				btn01.setIcon(new ImageIcon(imgList.get(selectImgNum).getScaledInstance((int) (230 * CHECK),
						(int) (156 * CHECK), Image.SCALE_SMOOTH)));
			}
			
			btn01.setEnabled(false);

			if (selectImgNum + 1 <= imgList.size()) {
				btn02.setName("" + (selectImgNum + 1));
				btn02.setIcon(new ImageIcon(imgList.get(selectImgNum + 1).getScaledInstance((int) (230 * CHECK),
						(int) (156 * CHECK), Image.SCALE_SMOOTH)));
				btn02.addActionListener(btnEvent02);
			} else {
				btn02.setIcon(new ImageIcon(
						notImg.getScaledInstance((int) (230 * CHECK), (int) (156 * CHECK), Image.SCALE_SMOOTH)));
			}

		}
	}

	class Evnet implements ActionListener {

		JButton btn;
		JPanel back;

		@Override
		public void actionPerformed(ActionEvent e) {

			selectImgNum = Integer.parseInt(btn.getName());

			btn00.removeActionListener(btnEvent00);
			btn02.removeActionListener(btnEvent02);

			if (selectImgNum - 1 >= 0) {
				btn00.setName("" + (selectImgNum - 1));
				btn00.setIcon(new ImageIcon(imgList.get(selectImgNum - 1).getScaledInstance((int) (230 * CHECK),
						(int) (156 * CHECK), Image.SCALE_SMOOTH)));
				btn00.addActionListener(btnEvent00);
			} else {
				btn00.setIcon(new ImageIcon(
						notImg.getScaledInstance((int) (230 * CHECK), (int) (156 * CHECK), Image.SCALE_SMOOTH)));
			}
			btn01.setName("" + (selectImgNum));
			btn01.setIcon(new ImageIcon(imgList.get(selectImgNum).getScaledInstance((int) (230 * CHECK),
					(int) (156 * CHECK), Image.SCALE_SMOOTH)));

			if (selectImgNum + 1 <= imgList.size() - 1) {
				btn02.setName("" + (selectImgNum + 1));
				btn02.setIcon(new ImageIcon(imgList.get(selectImgNum + 1).getScaledInstance((int) (230 * CHECK),
						(int) (156 * CHECK), Image.SCALE_SMOOTH)));
				btn02.addActionListener(btnEvent02);
			} else {
				btn02.setIcon(new ImageIcon(
						notImg.getScaledInstance((int) (230 * CHECK), (int) (156 * CHECK), Image.SCALE_SMOOTH)));
			}

			back.remove(mainPanel);
			mainPanel = new mainPicture();
			back.add(mainPanel, 1, 0);

			RunProgram.mainFrame.getFrame().repaint();

		}

		public Evnet(JButton btn, JPanel back) {
			this.btn = btn;
			this.back = back;
		}

	}
}
