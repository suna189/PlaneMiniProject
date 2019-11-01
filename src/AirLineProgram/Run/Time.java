package AirLineProgram.Run;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;


public class Time {
	int startH;
	int startM;
	int arriveH;
	int arriveM;
	int nowHour;
	int nowMinute;
	int nowSecond;
	int flightTime;

	public Time(String startTime, String arriveTime) {
		String[] startTimeString = startTime.split(":");
		String[] arriveTimeString = arriveTime.split(":");

		for (int i = 0; i < startTimeString.length; i++) {

			// startH,M / arriveT,M 에 데이터의 시간과 분 입력
			if(i%2 == 0) {
				//출발시간을 분으로 환산
				startH = Integer.parseInt(startTimeString[i]) * 60;
				arriveH = Integer.parseInt(arriveTimeString[i]) * 60;
				//출발 분
				startM = Integer.parseInt(startTimeString[i + 1]);
				arriveM = Integer.parseInt(arriveTimeString[i + 1]);
			}		
			
//			System.out.println(startTimeString[i]);
			
			// 비행시간 구함 (초)
			flightTime = Math.abs(((arriveH) - (startH)) + (arriveM - startM)) * 60;
			
//			System.out.println(arriveH + " " + startH + " " + arriveM + " " + startM);
//			System.out.println(flightTime/600);

		}
		

		// 현재 시간
		Date nowTime = new Date();
		// 시간만
		SimpleDateFormat dateFormatH = new SimpleDateFormat("HH");
		// 분만
		SimpleDateFormat dateFormatM = new SimpleDateFormat("mm");
		//초만
		SimpleDateFormat dateFormatS = new SimpleDateFormat("ss");
		// 현재시간
		nowHour = Integer.parseInt(dateFormatH.format(nowTime));
		// 현재 분
		nowMinute = Integer.parseInt(dateFormatM.format(nowTime));
		//현재 초
		nowSecond = Integer.parseInt(dateFormatS.format(nowTime));

	}

	public int getNowSecond() {
		return nowSecond;
	}

	public int getStartH() {
		return startH;
	}

	public int getStartM() {
		return startM;
	}

	public int getArriveH() {
		return arriveH;
	}

	public int getArriveM() {
		return arriveM;
	}

	public int getNowHour() {
		return nowHour;
	}

	public int getNowMinute() {
		return nowMinute;
	}

	public int getFlightTime() {
		return flightTime;
	}

	public static void main(String[] args) {

		Time time = new Time("07:15", "09:15");
		System.out.println(time.getNowSecond());
	}

}
