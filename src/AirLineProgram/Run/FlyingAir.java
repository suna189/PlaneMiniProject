package AirLineProgram.Run;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FlyingAir implements Runnable, SettingInterface {

	List<JPanel> flyData;

	JFrame flyFrame;

	public FlyingAir(JFrame flyFrame) {
		this.flyFrame = flyFrame;
	}

	public void flyPaint(double[] startCity, double[] arriveCity, String startTime, String arriveTime, int paintCount, int chk) {

		Time time = new Time(startTime, arriveTime);
		BufferedImage img;
		double startX, startY;
		double x, y;
		int startT = ((time.getStartH() + time.getStartM()) * 60) - 1;

		startX = startCity[0];
		startY = startCity[1];
		x = arriveCity[0] - startCity[0];
		y = arriveCity[1] - startCity[1];
		img = new Rotation(startCity, arriveCity, chk).img;

		startX = startX - ((x / time.getFlightTime()) * 2.0);
		startY = startY - ((y / time.getFlightTime()) * 2.0);

		while (startT + time.getNowSecond() <= (((time.getNowHour() * 60) + time.getNowMinute()) * 60)) {

			// 출발도시의 X,Y를 거리와 비례해서 더하여 도착도시의 X,Y와 같아질때까지 비행기 좌표를 설정
			startX += x / (time.getFlightTime());
			startY += y / (time.getFlightTime());
			startT += 1;

		}
		
		System.out.println("그리기 체크  : " + paintCount);

		flyData.add(new airlinePanel(img, startX, startY));
		flyFrame.add(flyData.get(paintCount), paintCount+500, 0);
		
		if(StaticObject.chk != null) {
			flyFrame.remove(StaticObject.chk);
			flyFrame.add(StaticObject.chk,1000,0);
		}
		
		if(StaticObject.picturePanel!=null) {
			
			flyFrame.remove(StaticObject.picturePanel);
			flyFrame.add(StaticObject.picturePanel,2000,0);
			
		}
		
		flyFrame.revalidate();
		flyFrame.repaint();

	}

	@Override
	public void run() {

		while (true) {

			// 기존 값들 Visible(false)
			if (flyData != null) {
				for (int i = 0; i < flyData.size(); i++) {
					flyData.get(i).setVisible(false);
					flyFrame.remove(flyData.get(i));
				}
			}

			// 데이터 초기화
			flyData = new ArrayList<JPanel>();
			int airNum = DataDummy.flight_Code.length;
			int count = 0;
			int paintCount = 0;

			// 상공의 총 비행기 갯수

			while (count < airNum) {
				if (DataDummy.state[count].equals("출발")) {
					double[] startCity = null;
					double[] arriveCity = null;
					String startTime = null;
					String arriveTime = null;
					int chk = 0;

					// 구분

					if (DataDummy.s_airport[count].equals("시드니")) {
						startCity = SYDNEY_AIRTRIP;
						chk = 5;
					} else if (DataDummy.s_airport[count].equals("인천")) {
						startCity = SEOUL_AIRTRIP;
						chk = 1;
					} else if (DataDummy.s_airport[count].equals("파리")) {
						startCity = PARIS_AIRTRIP;
						chk = 3;
					} else if (DataDummy.s_airport[count].equals("두바이")) {
						startCity = DUBAI_AIRTRIP;
						chk = 6;
					} else if (DataDummy.s_airport[count].equals("볼레")) {
						startCity = ADDIS_ABABBA_AIRTRIP;
						chk = 4;
					} else if (DataDummy.s_airport[count].equals("뉴욕")) {
						startCity = NEWYORK_AIRTRIP;
						chk = 2;
					}

					if (DataDummy.a_airport[count].equals("시드니")) {
						arriveCity = SYDNEY_AIRTRIP;
					} else if (DataDummy.a_airport[count].equals("인천")) {
						arriveCity = SEOUL_AIRTRIP;
					} else if (DataDummy.a_airport[count].equals("파리")) {
						arriveCity = PARIS_AIRTRIP;
					} else if (DataDummy.a_airport[count].equals("두바이")) {
						arriveCity = DUBAI_AIRTRIP;
					} else if (DataDummy.a_airport[count].equals("볼레")) {
						arriveCity = ADDIS_ABABBA_AIRTRIP;
					} else if (DataDummy.a_airport[count].equals("뉴욕")) {
						arriveCity = NEWYORK_AIRTRIP;
					}

					startTime = DataDummy.s_time[count];
					arriveTime = DataDummy.a_time[count];
					
					System.out.println("시간 체크(출발) : " + startTime);
					System.out.println("시간 체크(도착) : " + startTime);
					
					// 비행기 그리기
					flyPaint( startCity,arriveCity, startTime, arriveTime, paintCount, chk);
					
					System.out.println("그린 도시 : " + DataDummy.a_airport[count]);
					
					paintCount++;
				}
				count++;
			}
			
			int cnt = 0;
			try {
				Time time = new Time("00:00", "01:01");
				System.out.println("그리기 완료");
				if(cnt == 0) {	
					Thread.sleep(60000 - (time.getNowSecond()*1000)); 
					cnt++;
				} else {
					// 60000 -> 1M
					Thread.sleep(60000);
				}
				
			} catch (InterruptedException e) {
				
				
				e.printStackTrace();
				
			}
		}

	}

	class airlinePanel extends JPanel {

		BufferedImage img;

		public airlinePanel(BufferedImage img, double startX, double startY) {
			this.img = img;
			setLayout(null);
			setBounds((int) (startX*CHECK)-5, (int) (startY*CHECK)-5, (int)(img.getWidth()*CHECK), (int)(img.getHeight()*CHECK));
			setVisible(true);
		}

		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			// 이미지 그리기
			g.drawImage(img, 0, 0, (int)(img.getWidth()*CHECK), (int)(img.getHeight()*CHECK), this);
		}
	}
}
