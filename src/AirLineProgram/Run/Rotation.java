package AirLineProgram.Run;

import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Rotation implements SettingInterface {
	
	BufferedImage img;

	double startX, startY, arriveX, arriveY;
	
	double x, y;
	
	int chk = 0;
	
	
	public Rotation(double[] startCity, double[] arriveCity, int chk) {
		this.chk = chk;
		
		try {
			img = ImageIO.read(new ByteArrayInputStream(getByteArr()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.startX = startCity[0];
		this.startY = startCity[1];
		this.arriveX = arriveCity[0];
		this.arriveY = arriveCity[1];
		this.x = arriveCity[0] - startCity[0];
		this.y = arriveCity[1] - startCity[1];
		img = getLotation(img, angle());
	
	}
	
	
	private byte[] getByteArr() throws IOException {
		
		BufferedImage imgPlane = null;
		
		if (chk == 1) {
			imgPlane = ImageIO.read(INCHEON_AIRPLANE);
		} else if (chk == 2) {
			imgPlane = ImageIO.read(NEWYORK_AIRPLANE);
		} else if (chk == 3) {
			imgPlane = ImageIO.read(PARIS_AIRPLANE);
		} else if (chk == 4) {
			imgPlane = ImageIO.read(BOLE_AIRPLANE);
		} else if (chk == 5) {
			imgPlane = ImageIO.read(SYDNEY_AIRPLANE);
		} else if (chk == 6) {
			imgPlane = ImageIO.read(DUBAI_AIRPLANE);
		}
		
		// 바이트 배열을 차례대로 출력한다
		ByteArrayOutputStream byteArray = new ByteArrayOutputStream();

		// 이미지를 OutputStream에 씁니다. 여기서 outputStream은 byteArray
		ImageIO.write(imgPlane, "png", byteArray);
		// stream에 남아 있는 데이터를 강제로 내보내는 역할, 버퍼에 데이터가 쌓이면 한번에 내보낸다.
		byteArray.flush();

		byte[] arr = byteArray.toByteArray();

		return arr;
	}
	
	
	private double angle() {
		// 반환된 각도값이 라디언이므로 TO_DEGREES를 곱해 각도로 만들어줘야 한다.
		double angle = Math.toDegrees(Math.atan2(y, x));
		if (angle < 0) { // 각도가 0보다 작으면 360을 더해 각도의 값이 항상 0과 360 사이일 수 있게 한다.
			angle += 360;
		}

		return angle + 90;
	}
	
	private BufferedImage getLotation(BufferedImage img, double degree) {
		// 각도를 Radian으로 변경
		double angleRadian = Math.toRadians(degree);
		// abs = 절대값 반환, sin = 각도의 삼각 사인을 반환, cos = 각도의 삼각 코사인을 반환
		double sin = Math.abs(Math.sin(angleRadian));
		double cos = Math.abs(Math.cos(angleRadian));

		// 이미지의 가로, 세로
		double width = img.getWidth();
		double height = img.getHeight();
		// floor = 반올림 //회전했을때의 이미지 가로세로 구하기? |x1-x2|²/r(빗변) + |y1-y2|²/r(빗변)
		int n_width = (int) Math.floor(width * cos + height * sin);

		int n_height = (int) Math.floor(width * sin + height * cos);

		// GraphicsConfiguration 클래스는 프린터 또는 모니터와 같은 그래픽 대상의 특성을 설명
		// GraphicsConfiguration 객체의 경계는 가상 좌표계를 기준.
		// getBounds를 사용하여 원하는 GraphicsConfiguration의 경계를 가져오고 GraphicsConfiguration의
		// 좌표로 위치를 오프셋합니다.
		GraphicsConfiguration gc = getDefaultConfiguration();
		// GraphicsConfiguration과 호환되는 데이터 레이아웃 및 색상 모델이있는 BufferedImage를 리턴
		// 투명화
		BufferedImage result = gc.createCompatibleImage(n_width, n_height, Transparency.TRANSLUCENT);
		// BufferedImage에 그릴 수있는 Graphics2D를 작성합니다.
		Graphics2D g = result.createGraphics();
		// Graphics2D의 원점을 현재의 좌표계의 점 (x, y)으로 이동합니다.
		g.translate((n_width - width) / 2, (n_height - height) / 2);
		// 원점을 기준으로 각도만큼 회전한다. 각도의 단위는 radian이다.
		// 현재 Graphics2D를 변환된 회전 변형과 연결
		// 후속 렌더링은 지정된 위치로 이동하고 지정된 라디안으로 회전하며 원래 이미지와 동일한 양으로 변환됩니다.
		g.rotate(angleRadian, width / 2, height / 2);
		// 이미지 공간으로부터 유저 공간에 변환을 적용하고 나서, RenderableImage 를 표현 합니다. 유저 공간으로부터 디바이스 공간에의
		// 변환은
		// Graphics2D 에서의 현재의 Transform 에 의해 행해집니다. 지정된 변환은 Graphics2D 문맥의 변환 속성이 적용되기
		// 전에 이미지에 적용됩니다.
		// xform - 이미지 공간으로부터 유저 공간에의 변환
		g.drawRenderedImage(img, null);
		// 이 그래픽 컨텍스트를 삭제하고 사용중인 시스템 리소스를 해제. Graphics 객체 dispose 의 호출 후에 사용불가.
		g.dispose();

		return result;

	}
	
	private GraphicsConfiguration getDefaultConfiguration() {
		// GraphicsEnvironment 객체는 픽셀 형식 및 해상도라고 하는 렌더링 타겟의 특성을 정의
		// 현재 위치에 있는 GraphicsEnvironment를 리턴
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		// 이 객체는 GraphicsDevice를 사용할 수있는 다른 구성을 지정하며 하나 이상의 GraphicsConfiguration 객체가 필요
		// 특정 그래픽 환경에서 사용 가능한 그래픽 장치
		// 다중 화면 환경에서 GraphicsConfiguration 객체를 사용하여 여러 화면에서 구성 요소를 렌더링(완성 예상도) 할 수
		// 있습니다.
		// 기본 화면 GraphicsDevice를 반환합니다.
		GraphicsDevice gd = ge.getDefaultScreenDevice();
		return gd.getDefaultConfiguration();
	}

}
