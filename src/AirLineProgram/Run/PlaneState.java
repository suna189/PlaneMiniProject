package AirLineProgram.Run;

public class PlaneState {

	String state;
	
	public PlaneState(String startTime, String arriveTime) {
//		String startInputData = "DestimatedDateTime";
//		String arriveInputData = "AestimatedDateTime";
//		
//		Data_Export startData = new Data_Export(startInputData);
//		Data_Export arriveData = new Data_Export(arriveInputData);
		Time time;
//		
//		for(int i=0; i < startData.getlength(); i++) {
//			time = new Time(startData.getDEstimatedDateTime(i), arriveData.getAEstimatedDateTime(i));
//			System.out.println(startData.getDEstimatedDateTime(i));
//			
//			if((time.getStartH() + time.getStartM()) < ((time.nowHour * 60) + time.nowMinute) && 
//					(time.arriveH + time.arriveM) < ((time.nowHour * 60) + time.nowMinute)){
//				state = "대기";
//				System.out.println("*");
//			} else if((time.getStartH() + time.getStartM()) <= ((time.nowHour * 60) + time.nowMinute) && 
//					((time.nowHour * 60) + time.nowMinute) <= (time.arriveH + time.arriveM)){
//					state = "출발";
//			} else {
//				state = "대기";
//			}
//			
//			System.out.println(state);
//		}
		
		
		
		
		//Test

		time = new Time(startTime, arriveTime);
	
		if((time.getStartH() + time.getStartM()) < ((time.nowHour * 60) + time.nowMinute) && 
				(time.arriveH + time.arriveM) < ((time.nowHour * 60) + time.nowMinute)){
			state = "대기";
		} else if((time.getStartH() + time.getStartM()) <= ((time.nowHour * 60) + time.nowMinute) && 
				((time.nowHour * 60) + time.nowMinute) <= (time.arriveH + time.arriveM)){
				state = "출발";
		} else {
			state = "대기";
		}
		
//		System.out.println((time.getStartH() + time.getStartM())+ " " + ((time.nowHour * 60) + time.nowMinute) + " " + (time.arriveH + time.arriveM));
//		System.out.println(state);
	}
	
	public String getState() {
		return state;
	}


}
