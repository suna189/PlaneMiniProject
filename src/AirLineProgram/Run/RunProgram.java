package AirLineProgram.Run;

public class RunProgram implements SettingInterface{

	/*
	 * Program Setting List ( 2019 . 10. 16 )
	 * 
	 * interface
	 * 
	 * - SettingInterface : All Button X, Y, Size Setting All Panel X, Y, Size
	 * Setting All File Path Setting -> All Class Connect
	 * 
	 * class
	 * 
	 * - FileSizeChk : File Size Check - DisplayChk : Check Your Computer Resolution
	 * Setting - ImageDirChk : Image Directory Location Check - StaticObject :
	 * Static Object Setting - JFrameMake : Main Frame Object Setting -
	 * AirPortButton : AirPort Button Object Setting - Right_UI : Right Panel Object
	 * Setting - Right_UI_EXIT : Right Panel Exit Button Object Setting -
	 * MouseEvnetCall : AirPortButton, Right_UI, Right_UI_EXIT Button Click Event
	 * Setting - RunProgram : Main Method Class
	 * 
	 * 
	 * 
	 * ( 2019 . 10 . 20 )
	 * 
	 * SettingInterface Add 133 Line Right_UI 126 line Add RIght_UI_Name Class Add
	 * Right_UI_Header Class Modify
	 * 
	 * ( 2019 . 10 . 21 )
	 * 
	 * SettingInterface Add 159 Line Right_UI Add 88 ~ Line Right_UI_Header Modify
	 * AirLineList Add
	 * 
	 * ( 2019 . 10 . 23 )
	 * 
	 * JFrameMake,  MouseEvntCall, RunProgram Modify
	 * FlyingAir, DataDummy, Rotation  Add
	 * AirLneList, AirPortButton, DisplayChk Modify
	 * StaticObject, Right_UI_Body_Background, Right_UI_EXIT, Right_UI_Header Modify
	 * Right_UI_Name, Right_UI Modify
	 */
	
	// ( 2019 . 10. 23 Modify )
	
	public static Thread mainThread;
	public static JFrameMake mainFrame;
	public static Thread daemonThread;

	public static void main(String[] args) {

		// other Thread Setting Start

		
		StaticObject createObject = new StaticObject();

		daemonThread = new Thread(data);
		daemonThread.setDaemon(true);
		daemonThread.start();
		
		
		mainFrame = new JFrameMake();
		mainThread = new Thread(mainFrame);
		mainThread.start();
		
		new PicturePanel(1);
		
	}
}
