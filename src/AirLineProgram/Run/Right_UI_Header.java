package AirLineProgram.Run;

import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Right_UI_Header extends JPanel implements SettingInterface {

	int uiSelectNum;
	AirLineList airList;

	public Right_UI_Header(int uiSelectNum, AirLineList airList) {
		this.airList = airList;
		this.uiSelectNum = uiSelectNum;

		try {
			add(new AirPort_Image(), 0, 0);
		} catch (IOException e) {
			System.out.println("Right_UI_Header : AirPort_Image Error ( AirPort_Image Class )");
			e.printStackTrace();
		}

		try {
			add(new shadow_back(), 1, 0);

		} catch (IOException e1) {
			System.out.println("Right_UI_Header : Shadow_back image error)");
			e1.printStackTrace();
		}
		try {
			add(new Header_Box(), 2, 0);
		} catch (IOException e) {
			System.out.println("Right_UI_Header : Header_Box Error ( Header_Box Class )");
			e.printStackTrace();
		}

		try {
			add(new AirLinePlusBtn(), 3, 0);
		} catch (IOException e) {
			System.out.println("Right_UI_Header : AirLinePlusBtn Error");
			e.printStackTrace();
		}

		add(new pictureBtn(), 4, 0); // ( 2019 . 10 . 24 add )

		add(new HomepageBtn(), 5, 0); // ( 2019 . 10. 24 add )

		setLayout(null);
		setBounds(RIGHT_UI_HEADER[0], RIGHT_UI_HEADER[1], RIGHT_UI_HEADER_SIZE[0], RIGHT_UI_HEADER_SIZE[1]);
		setVisible(true);

	}

	class shadow_back extends JPanel {
		Image tmpImg = null;
		BufferedImage img = null;

		public shadow_back() throws IOException {

			int[] scale = FileSizeChk.getSize(SHADOW_BACK, CHECK);

			tmpImg = ImageIO.read(SHADOW_BACK);
			tmpImg = tmpImg.getScaledInstance(scale[0], scale[1], Image.SCALE_SMOOTH);
			img = new BufferedImage(tmpImg.getWidth(null), tmpImg.getHeight(null), BufferedImage.TYPE_INT_ARGB);
			Graphics g = img.getGraphics();
			g.drawImage(tmpImg, 0, 0, null);
			g.dispose();

			setLayout(null);
			setBounds(0, 0, img.getWidth(), img.getHeight());

		}

		@Override
		public void paint(Graphics g) {
			g.drawImage(img, 0, 0, img.getWidth(), img.getHeight(), this);
		}

	}

	class AirPort_Image extends JPanel implements SettingInterface {

		Image tmpImg = null;
		BufferedImage airPortImg = null;

		public AirPort_Image() throws IOException {

			if (uiSelectNum == 1) {
				tmpImg = ImageIO.read(INCHEON_AIRPORT_IMAGE);
			} else if (uiSelectNum == 2) {
				tmpImg = ImageIO.read(JFK_AIRPORT_IAMGE);
			} else if (uiSelectNum == 3) {
				tmpImg = ImageIO.read(PARIS_AIRPORT_IMAGE);
			} else if (uiSelectNum == 4) {
				tmpImg = ImageIO.read(BOLE_AIRPORT_IMAGE);
			} else if (uiSelectNum == 5) {
				tmpImg = ImageIO.read(SYDNEY_AIRPORT_IMAGE);
			} else if (uiSelectNum == 6) {
				tmpImg = ImageIO.read(DUBAI_AIRPORT_IMAGE);
			}

			int[] scale = FileSizeChk.getSize(SHADOW_BACK, CHECK);
			tmpImg = tmpImg.getScaledInstance(scale[0], scale[1], Image.SCALE_SMOOTH);
			airPortImg = new BufferedImage(tmpImg.getWidth(null), tmpImg.getHeight(null), BufferedImage.TYPE_INT_ARGB);
			Graphics g = airPortImg.getGraphics();
			g.drawImage(tmpImg, 0, 0, null);
			g.dispose();

			setLayout(null);
			setBounds(0, 0, airPortImg.getWidth(), airPortImg.getHeight());

		}

		@Override
		public void paint(Graphics g) {
			g.drawImage(airPortImg, 0, 0, airPortImg.getWidth(), airPortImg.getHeight(), this);
		}

	}

	// ( 2019 . 10 . 20 add )

	class Header_Box extends JPanel implements SettingInterface {
		Image tmpImg = null;
		BufferedImage img = null;

		public Header_Box() throws IOException {

			if (uiSelectNum == 1) {
				tmpImg = ImageIO.read(UI_HEAD_INCHEON);
			} else if (uiSelectNum == 2) {
				tmpImg = ImageIO.read(UI_HEAD_JFK);
			} else if (uiSelectNum == 3) {
				tmpImg = ImageIO.read(UI_HEAD_PARIS);
			} else if (uiSelectNum == 4) {
				tmpImg = ImageIO.read(UI_HEAD_BOLE);
			} else if (uiSelectNum == 5) {
				tmpImg = ImageIO.read(UI_HEAD_SYDNEY);
			} else if (uiSelectNum == 6) {
				tmpImg = ImageIO.read(UI_HEAD_DUBAI);
			}

			tmpImg = tmpImg.getScaledInstance(FileSizeChk.getSize(tmpImg, CHECK)[0],
					FileSizeChk.getSize(tmpImg, CHECK)[1], Image.SCALE_SMOOTH);
			img = new BufferedImage(tmpImg.getWidth(null), tmpImg.getHeight(null), BufferedImage.TYPE_INT_ARGB);
			Graphics g = img.getGraphics();
			g.drawImage(tmpImg, 0, 0, null);
			g.dispose();

			setLayout(null);
			setBounds(UI_HEAD[0], UI_HEAD[1], UI_HEAD_SIZE[0], UI_HEAD_SIZE[1]);

		}

		@Override
		public void paint(Graphics g) {

			g.drawImage(img, 0, 0, img.getWidth(), img.getHeight(), this);
		}
	}

	// ( 2019. 10 . 21 add )

	class AirLinePlusBtn extends JButton implements SettingInterface {

		Image tmpImg = null;
		BufferedImage img = null;
		int x;
		int y = (int) (87 * CHECK);

		public AirLinePlusBtn() throws IOException {
			tmpImg = ImageIO.read(HEAD_AIRLINE_PLUS_BTN);
			tmpImg = tmpImg.getScaledInstance(FileSizeChk.getSize(tmpImg, CHECK)[0],
					FileSizeChk.getSize(tmpImg, CHECK)[1], Image.SCALE_SMOOTH);
			img = new BufferedImage(tmpImg.getWidth(null), tmpImg.getHeight(null), BufferedImage.TYPE_INT_ARGB);
			Graphics g = img.getGraphics();
			g.drawImage(tmpImg, 0, 0, null);
			g.dispose();

			if (uiSelectNum == 1) {
				this.x = (int) (403 * CHECK);

			} else if (uiSelectNum == 2) {
				this.x = (int) (353 * CHECK);

			} else if (uiSelectNum == 3) {
				this.x = (int) (400 * CHECK);

			} else if (uiSelectNum == 4) {
				this.x = (int) (366 * CHECK);

			} else if (uiSelectNum == 5) {
				this.x = (int) (396 * CHECK);

			} else if (uiSelectNum == 6) {
				this.x = (int) (366 * CHECK);

			}

			setLayout(null);
			setBounds(x, y, img.getWidth(), img.getHeight());
			setContentAreaFilled(false);
			setBorderPainted(false);
			addMouseListener(new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(MouseEvent e) {
					airList.setVisible(false);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseClicked(MouseEvent e) {
					airList.setVisible(true);
				}
			});
		}

		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			g.drawImage(img, 0, 0, img.getWidth(), img.getHeight(), this);

		}
	}

	// ( 2019 . 10 . 24 add )

	class pictureBtn extends JButton {

		Image tmpImg = null;

		public pictureBtn() {

			try {
				tmpImg = ImageIO.read(new File(path + "pictureicon.png"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			int[] scale = FileSizeChk.getSize(tmpImg, CHECK);
			tmpImg = tmpImg.getScaledInstance(scale[0], scale[1], Image.SCALE_SMOOTH);
			setIcon(new ImageIcon(tmpImg));

			setBounds((int) (374 * CHECK), (int) (152 * CHECK), (int) (36 * CHECK), (int) (30 * CHECK));
			setContentAreaFilled(false);
			setBorderPainted(false);
			addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					for (int i = 0; i < StaticObject.objectArray.length; i++) {
						AirPortButton btn = (AirPortButton) (StaticObject.objectArray[i][0]);
						btn.setEnabled(false);
					}

					if (StaticObject.picturePanel == null) {
						StaticObject.picturePanel = new PicturePanel(uiSelectNum);
						RunProgram.mainFrame.getFrame().add(StaticObject.picturePanel, 2000, 0);
					}
					RunProgram.mainFrame.getFrame().repaint();

				}
			});

		}
	}

	class HomepageBtn extends JButton {

		Image tmpImg = null;

		public HomepageBtn() {

			try {
				tmpImg = ImageIO.read(new File(path + "homepageBtn.png"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			int[] scale = FileSizeChk.getSize(tmpImg, CHECK);
			tmpImg = tmpImg.getScaledInstance(scale[0], scale[1], Image.SCALE_SMOOTH);
			setIcon(new ImageIcon(tmpImg));

			setBounds((int) (326 * CHECK), (int) (152 * CHECK), scale[0], scale[1]);
			setContentAreaFilled(false);
			setBorderPainted(false);
			addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					URI uri = null;
					try {
						if (uiSelectNum == 1) {
							uri = new URI("https://www.airport.kr/ap/ko/index.do");
						} else if (uiSelectNum == 2) {
							uri = new URI("https://www.jfkairport.com/");
						} else if (uiSelectNum == 3) {
							uri = new URI("https://www.parisaeroport.fr/en");
						} else if (uiSelectNum == 4) {
							uri = new URI("https://addisairport.com/");
						} else if (uiSelectNum == 5) {
							uri = new URI("https://www.sydneyairport.com.au/");
						} else if (uiSelectNum == 6) {
							uri = new URI("https://www.dubaiairports.ae/");
						}
					} catch (Exception e1) {
						// TODO: handle exception
						e1.printStackTrace();
					}

					try {
						Desktop.getDesktop().browse(uri);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			});

		}
	}

}
