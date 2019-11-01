package AirLineProgram.Run;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import static AirLineProgram.Run.StaticObject.*;

public class JFrameMake extends WindowAdapter implements Runnable, SettingInterface {

	/*
	 * Frame Setting ( 2019 . 10. 16 )
	 * 
	 */

// Variable Start --------------------------------------------------------------------------------------------------------------------

	private JFrame frame; // Main Frame
	private JPanel background; // World Map Print
	private BufferedImage img; // World Map Image Variable

// Variable End  --------------------------------------------------------------------------------------------------------------------

// Frame Object Constructor Start --------------------------------------------------------------------------------------------------------

	public JFrameMake() {

		// Frame Object Setting

		frame = new JFrame("항공관리 프로그램");

		// World Map Print Object Setting

		// World Map Image Resizing

		Image tmpImg = null;
		try {
			tmpImg = ImageIO.read(BACKGROUND_PATH);

		} catch (IOException e) {

			System.out.println("JFrame : background image error");
			e.printStackTrace();
		}

		int[] scale = FileSizeChk.getSize(BACKGROUND_PATH, CHECK);

		tmpImg = tmpImg.getScaledInstance(scale[0], scale[1], Image.SCALE_SMOOTH);
		img = new BufferedImage(tmpImg.getWidth(null), tmpImg.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		Graphics g = img.getGraphics();
		g.drawImage(tmpImg, 0, 0, null);
		g.dispose();

		// World Map Image Painting

		background = new JPanel() {

			private static final long serialVersionUID = 1L;

			@Override
			public void paint(Graphics g) {
				g.drawImage(img, 0, 0, img.getWidth(), img.getHeight(), background);
			}
		};

		// AirCraft Print Object Test

	}

// Frame Object Constructor End --------------------------------------------------------------------------------------------------------

// Thread Run Start --------------------------------------------------------------------------------------------------------------------

	@Override
	public void run() {

		// Frame Setting

		frame.setLayout(null);
		frame.setSize(img.getWidth() + (int) (6 * CHECK), img.getHeight() + (int) (35 * CHECK));
		frame.addWindowListener(this);

		// WorldMap Put in

		background.setBounds(0, 0, img.getWidth(), img.getHeight());
		background.setLayout(null);

		frame.add(background);

		// AirPort Button Event Put in

		seoulBtn.setEvent(seoulBtn);
		sydneyBtn.setEvent(sydneyBtn);
		newYorkBtn.setEvent(newYorkBtn);
		parisBtn.setEvent(parisBtn);
		addisAbabbaBtn.setEvent(addisAbabbaBtn);
		dubaiBtn.setEvent(dubaiBtn);

		// AirPort Button Put in
		frame.add(new FlyLine(), 5,0);
		frame.add(seoulBtn, 10, 0);
		frame.add(sydneyBtn, 20, 0);
		frame.add(newYorkBtn, 30, 0);
		frame.add(parisBtn, 40, 0);
		frame.add(addisAbabbaBtn, 50, 0);
		frame.add(dubaiBtn, 60, 0);

		// AirCraft Print

		// ( 2019 . 10. 23 Modify )

		Thread runFly = new Thread(new FlyingAir(RunProgram.mainFrame.getFrame()));
		runFly.start();

		// AirPort Right Panel Put in
		
		Image tmpImg = null;
		try {
			tmpImg = ImageIO.read(FRAMEICON);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		frame.setIconImage(tmpImg);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.revalidate();

	}

// Thread run End --------------------------------------------------------------------------------------------------------------------

// Event Start --------------------------------------------------------------------------------------------------------------------

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public JFrame getFrame() {
		return frame;
	}

}

// Event End --------------------------------------------------------------------------------------------------------------------
