package AirLineProgram.Run;

import java.awt.Desktop;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Right_UI_JTable_PopUp extends JFrame implements SettingInterface {

	JLayeredPane jlp; // 컴포넌트간 위계 생성 (component , index) index가 클수록 상위

//	String background_ar = "/Users/jiaemin/OneDrive - u-paris10.fr/★KH정보교육원/Workspace_GUI/MiniProject_Airline/src/AirLineProgram/ProgramImage/PopUpBackground_arrival.png";
//	String background_dp = "/Users/jiaemin/OneDrive - u-paris10.fr/★KH정보교육원/Workspace_GUI/MiniProject_Airline/src/AirLineProgram/ProgramImage/PopUpBackground_departure.png";
	
	BufferedImage img = null;
	Right_UI_JTable jtable ;
	String Whereto;

	// 로고 설정
	// ---------------------------------------------------------------------------------------------
	String Airline;
	
//	String imgOriginalPath = "/Users/jiaemin/OneDrive - u-paris10.fr/★KH정보교육원/Workspace_GUI/MiniProject_Airline/src/AirLineProgram/ProgramImage/AirlineLogos/";
	
	String imgFormat = "png";

	BufferedImage logo = null;
	Image resizeLogo = null;
	int logoWidth;
	int logoHeight;
	int w;
	int h;
	double ratio;

	int newWidth = 100;
	int newHeight = 25;
	String mainPosition = "W";
	// ------------------------------------------------------------------------------------------------------------

	public Right_UI_JTable_PopUp(int i, Right_UI_JTable tb) {
		// 데이터 불러와서 String으로 저장
	
		
		String City = tb.table.getValueAt(i, 0).toString();
		String Airline = tb.table.getValueAt(i, 1).toString();
		String Flight = tb.table.getValueAt(i, 2).toString();
		String TakeoffTime = tb.table.getValueAt(i, 3).toString();
		String ArriveTime = tb.table.getValueAt(i, 4).toString();
		String Terminal = tb.table.getValueAt(i, 5).toString();
		String CheckInORBaggage = tb.table.getValueAt(i, 6).toString();
		String Gate = tb.table.getValueAt(i, 7).toString();
		String State = tb.table.getValueAt(i, 8).toString();
		
		
		System.out.println(City);
		System.out.println(Airline);
		System.out.println(Flight);
		System.out.println(TakeoffTime);
		System.out.println(ArriveTime);
		System.out.println(Terminal);
		System.out.println(CheckInORBaggage);
		System.out.println(Gate);
		System.out.println(State);
		

		// JLayeredPane 생성
		// ----------------------------------------------------------------------------------------

		jlp = new JLayeredPane();
		jlp.setBounds(0, 0, (int)(400* CHECK), (int)(525* CHECK));
		jlp.setLayout(null);

		// background-----------------------------------------------------------------------------------------------

		try {
			if (State.equals("도착")) {
				img = ImageIO.read(new File(path+ "PopUpBackground_arrival.png")); // ( 2019 . 10 . 24 수정 )
//				img = ImageIO.read(new File(background_ar));
			} else if (State.equals("출발")) {
				img = ImageIO.read(new File(path + "PopUpBackground_departure.png")); // ( 2019 . 10 . 24 수정 )
//				img = ImageIO.read(new File(background_dp));
			} 
		} catch (IOException e) {

			JOptionPane.showMessageDialog(null, "loading image failure");

		}

		myPanel panel = new myPanel();
		panel.setSize((int)(400* CHECK), (int)(525* CHECK));

		// -----------------------------------------------------------------------------------------------------------
		// logo-------------------------------------------------------------------------------------------------------
		// 로고 이미지 사진 조절
		// -----------------------------------------------------------------------------------------------------------

		try {
			logo = ImageIO.read(new File(path + "AirlineLogos/" + Airline + ".png")); // ( 2019 . 10 . 24 수정 )
//			logo = ImageIO.read(new File(imgOriginalPath + Airline + ".png")); 
			logoWidth = logo.getWidth(null);
			logoHeight = logo.getHeight(null);

			if (mainPosition.equals("W")) {
				ratio = (double) newWidth / (double) logoWidth;
				w = (int) (logoWidth * ratio);
				h = (int) (logoHeight * ratio);
			} else if (mainPosition.equals("H")) {
				ratio = (double) newHeight / (double) logoHeight;
				w = (int) (logoWidth * ratio);
				h = (int) (logoHeight * ratio);
			} else {
				w = (int)(newWidth* CHECK) ;
				h = (int)(newHeight* CHECK);
			}

			resizeLogo = logo.getScaledInstance(w, h, Image.SCALE_SMOOTH);
			BufferedImage newLogo = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
			Graphics g = newLogo.getGraphics();
			g.dispose();

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "loading image failure");
		}

		// 만든 이미지를 버튼으로 만들기
		// ---------------------------------------------------------------------------------------------------------

		JButton label = new JButton(new ImageIcon(resizeLogo));
		label.setBorderPainted(false);
		label.setContentAreaFilled(false); // ( 2019 . 10 . 24 수정 )
		label.setBounds((int)(150* CHECK), (int)(45* CHECK), resizeLogo.getWidth(null), resizeLogo.getHeight(null));
		label.setHorizontalAlignment(JLabel.CENTER);

		label.addActionListener(new ActionListener() { // 액션 연결 -> 항공사 이름에 따라 분류해서 URI 연결 --------------------

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					if (Airline.equals("아시아나 항공")) {
						Desktop.getDesktop().browse(URI.create("https://flyasiana.com/C/KR/KO/index"));
					} else if (Airline.equals("대한항공")) {
						Desktop.getDesktop().browse(URI.create("https://www.koreanair.com/korea/ko.html"));
					} else if (Airline.equals("에어프랑스 항공")) {
						Desktop.getDesktop().browse(URI.create("https://www.airfrance.co.kr"));
					} else if (Airline.equals("델타항공")) {
						Desktop.getDesktop().browse(URI.create("https://ko.delta.com/mytrips/"));
					} else if (Airline.equals("싱가포르 항공")) {
						Desktop.getDesktop().browse(URI.create("https://www.singaporeair.com/"));
					} else if (Airline.equals("콴타스 항공")) {
						Desktop.getDesktop().browse(URI.create("http://www.qantas.com.au/"));
					} else if (Airline.equals("핀에어 항공")) {
						Desktop.getDesktop().browse(URI.create("http://www.finnair.com/"));
					} else if (Airline.equals("노르웨이 항공")) {
						Desktop.getDesktop().browse(URI.create("https://www.norwegian.com/"));
					} else if (Airline.equals("에미레이트 항공")) {
						Desktop.getDesktop().browse(URI.create("http://www.emirates.com/"));
					} else if (Airline.equals("에티오피아 항공")) {
						Desktop.getDesktop().browse(URI.create("http://www.ethiopianairlines.co.kr/"));
					} else if (Airline.equals("플라이두바이 항공")) {
						Desktop.getDesktop().browse(URI.create("http://www.flydubai.com/"));
					} else if (Airline.equals("유나이티드 항공")) {
						Desktop.getDesktop().browse(URI.create("http://www.united.com/"));
					} else if (Airline.equals("코파 항공")) {
						Desktop.getDesktop().browse(URI.create("http://www.copaair.com/"));
					} else if (Airline.equals("아르헨티나 항공")) {
						Desktop.getDesktop().browse(URI.create("http://www.aerolineas.com/"));
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		});

		// 데이터 폰트,크기 설정, 죄표에 박기
		// ----------------------------------------------------------------------------------------------

		if (City == "인천") {
			Whereto = "INC";
		} else if (City == "시드니") {
			Whereto = "SYD";
		} else if (City == "볼레") {
			Whereto = "ADD";
		} else if (City == "두바이") {
			Whereto = "DXB";
		} else if (City == "파리") {
			Whereto = "CDG";
		} else if (City == "시드니") {
			Whereto = "SYD";
		} else if (City == "뉴욕") {
			Whereto = "JFK";
		}

		JLabel e01 = new JLabel(Flight);
		JLabel a = new JLabel(tb.AirportCode);
		JLabel b = new JLabel(Whereto);
		JLabel c = new JLabel(TakeoffTime);
		JLabel d = new JLabel(ArriveTime);
		JLabel f = new JLabel(Terminal);
		JLabel g = new JLabel(CheckInORBaggage);
		JLabel h = new JLabel(Gate);
		
		
		if (State.equals("출발")) {

			a.setFont(new Font("돋움", Font.BOLD, 40));
			a.setBounds(43, 265, 95, 49);
			a.setHorizontalAlignment(JLabel.CENTER);

			b.setFont(new Font("돋움", Font.BOLD, 40));
			b.setBounds(260, 265, 95, 49);
			b.setHorizontalAlignment(JLabel.CENTER);

			c.setFont(new Font("돋움", Font.PLAIN, 30));
			c.setBounds(44, 315, 95, 49);
			c.setHorizontalAlignment(JLabel.CENTER);

			d.setFont(new Font("돋움", Font.PLAIN, 30));
			d.setBounds(259, 315, 95, 49);
			d.setHorizontalAlignment(JLabel.CENTER);
			
		} else {

			b.setFont(new Font("돋움", Font.BOLD, 40));
			b.setBounds(43, 265, 95, 49);
			b.setHorizontalAlignment(JLabel.CENTER);

			a.setFont(new Font("돋움", Font.BOLD, 40));
			a.setBounds(260, 265, 95, 49);
			a.setHorizontalAlignment(JLabel.CENTER);

			d.setFont(new Font("돋움", Font.PLAIN, 30));
			d.setBounds(44, 315, 95, 49);
			d.setHorizontalAlignment(JLabel.CENTER);
			
			c.setFont(new Font("돋움", Font.PLAIN, 30));
			c.setBounds(259, 315, 95, 49);
			c.setHorizontalAlignment(JLabel.CENTER);
		}
		
		e01.setFont(new Font("돋움", Font.PLAIN, 20));
		e01.setBounds(137, 155, 130, 25);
		e01.setHorizontalAlignment(JLabel.CENTER);

		f.setFont(new Font("돋움", Font.BOLD, 25));
		f.setBounds(38, 425, 95, 49);
		f.setHorizontalAlignment(JLabel.CENTER);

		
		g.setFont(new Font("돋움", Font.BOLD, 25));
		g.setBounds(153, 425, 95, 49);
		g.setHorizontalAlignment(JLabel.CENTER);

		
		h.setFont(new Font("돋움", Font.BOLD, 25));
		h.setBounds((int)(272*CHECK), (int)(425 * CHECK), (int)(95*CHECK), (int)(49*CHECK));
		h.setHorizontalAlignment(JLabel.CENTER);

		// JLayeredPane 에 붙히기
		// ----------------------------------------------------------------------------------------
		
		
		jlp.setLayout(null);
		
		
		
		jlp.add(label);
		jlp.add(a);
		jlp.add(b);
		jlp.add(c);
		jlp.add(d);
		jlp.add(f);
		jlp.add(g);
		jlp.add(h);
		jlp.add(e01);
		jlp.add(panel);

		
		jlp.setBounds(0, 0, (int)(400* CHECK), (int)(525* CHECK));
		jlp.setVisible(true);

		// 프레임
		// 설정------------------------------------------------------------------------------------------------------------

		add(jlp);

//		( 2019 . 10 . 24 )
		int[] winSize = new int[2];
		if(System.getProperty("os.name").indexOf("Win") >= 0 ) {
			winSize[0] = 19;
			winSize[1] = 24;
		}
		

		
		setTitle("항공기 상세정보");
		
		Image tmpImg = null;
		try {
			tmpImg = ImageIO.read(FRAMEICON);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setIconImage(tmpImg);
		setLayout(null);
		setVisible(true);
		setBounds((int) (940 * CHECK), (int) (50 * CHECK), (int) (img.getWidth() * CHECK) + (int) (winSize[0] * CHECK), (int) (525 * CHECK) + (int) (winSize[1] * CHECK));
		setLocationRelativeTo(null);
		setResizable(true);

	}

	class myPanel extends JPanel {
		public void paint(Graphics g) {
			// ( 2019 . 10 .26 Modify ) 
			g.drawImage(img, 0, 0,(int)(img.getWidth()*CHECK),(int)(img.getHeight()*CHECK),this);
		}
	}
}
