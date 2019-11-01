package AirLineProgram.Run;

import java.io.File;

public interface SettingInterface {

	// Image File Directory Location Setting

	/*
	 * 
	 * 
	 */

	// Warning
	// If you can't take the path
	// Path Variable Change Image Directory

	String path = imageDirChk.getPath();

//  지애씨 전용 패쓰~
//	String path = "/Users/jiaemin/OneDrive - u-paris10.fr/★KH정보교육원/Workspace_GUI/MiniProject_Airline/src/AirLineProgram/ProgramImage/";

	File BACKGROUND_PATH = new File(path + "WorldMap.jpg");
	File RIGHTGUISCREEN_PATH = new File(path + "RightGUI.png");


	File SEOUL_ICON_PAHT = new File(path + "Seoul_Icon.png");
	File SYDNEY_ICON_PAHT = new File(path + "Sydney_icon.png");
	File ADDIS_ABABBA_ICON_PAHT = new File(path + "Addis_Ababba_Icon.png");
	File PARIS_ICON_PAHT = new File(path + "Paris_icon.png");
	File DUBAI_ICON_PAHT = new File(path + "Dubai_Icon.png");
	File NEWYORK_ICON_PAHT = new File(path + "NewYork_icon.png");

	File X_BUTTON_PAHT = new File(path + "RightGUI_Top_Exit_Button.png");
	
	// ( 2019 . 10 . 26 add )
	
	File INCHEON_AIRPLANE = new File(path + "Incheon_Airplane.png");
	File NEWYORK_AIRPLANE = new File(path + "JFK_Airplane.png");
	File PARIS_AIRPLANE = new File(path + "Paris_Airplane.png");
	File BOLE_AIRPLANE = new File(path + "Bole_Airplane.png");
	File SYDNEY_AIRPLANE = new File(path + "Sydney_Airplane.png");
	File DUBAI_AIRPLANE = new File(path + "Dubai_Airplane.png");

	// Display Resolution Setting :
	// 1920 x 1050 = 1.0 ( Default )
	// etc >> Computer Display Resolution / 1920

	 double CHECK = DisplayChk.getDisplaySetting();

	//double CHECK = 1.0; // Test

	// AirPort Button Location :
	// [0] = X * Display Resolution Setting
	// [1] = Y * Display Resolution Setting

	int[] SEOUL = { (int) (1350 * CHECK), (int) (180 * CHECK) };

	int[] NEWYORK = { (int) (450 * CHECK), (int) (160 * CHECK) };

	int[] PARIS = { (int) (810 * CHECK), (int) (130 * CHECK) };

	int[] DUBAI = { (int) (1035 * CHECK), (int) (245 * CHECK) };

	int[] ADDIS_ABABBA = { (int) (985 * CHECK), (int) (315 * CHECK) };

	int[] SYDNEY = { (int) (1450 * CHECK), (int) (565 * CHECK) };

	// AirCraft Image Size :
	// [0] = width
	// [1] = Height

	int[] AIRCRAFT_SIZE = FileSizeChk.getSize(INCHEON_AIRPLANE, CHECK);

	// AirCraft Image Location :
	// [0] = X
	// [1] = Y

	double[] SEOUL_AIRTRIP = { (1365 * CHECK - AIRCRAFT_SIZE[0] / 2),  (237 * CHECK - AIRCRAFT_SIZE[1] / 2) };

	double[] NEWYORK_AIRTRIP = {  (470 * CHECK - AIRCRAFT_SIZE[0] / 2), (229 * CHECK - AIRCRAFT_SIZE[1] / 2) };

	double[] PARIS_AIRTRIP = {  (825 * CHECK - AIRCRAFT_SIZE[0] / 2), (188 * CHECK - AIRCRAFT_SIZE[1] / 2) };

	double[] DUBAI_AIRTRIP = {  (1050 * CHECK - AIRCRAFT_SIZE[0] / 2), (295 * CHECK - AIRCRAFT_SIZE[1] / 2) };

	double[] ADDIS_ABABBA_AIRTRIP = { (1000 * CHECK - AIRCRAFT_SIZE[0] / 2), (385 * CHECK - AIRCRAFT_SIZE[1] / 2) };

	double[] SYDNEY_AIRTRIP = { (1470 * CHECK - AIRCRAFT_SIZE[0] / 2), (621 * CHECK - AIRCRAFT_SIZE[1] / 2) };

	// Right Panel UI Location :
	// [0] = X
	// [1] = Y

	int[] RIGHT_UI = { (int) (1240 * CHECK), 0 };

	// Right Panel UI Exit Button Location :
	// [0] = X
	// [1] = Y

	int[] RIGHT_UI_EXIT_BUTTON = { (int) (18 * CHECK), (int) (6 * CHECK) };

	// RIGHT_UI_EXIT_BUTTON Size :
	// [0] = width
	// [1] = height

	int[] RIGHT_UI_EXIT_BUTTON_SIZE = FileSizeChk.getSize(X_BUTTON_PAHT, CHECK);

	// 국기
	File AMERICA_ICON = new File(path + "flag/America_icon.png");
	File AUSTRALIA_ICON = new File(path + "flag/Australia_icon.png");
	File ETHIOPIA_ICON = new File(path + "flag/Ethiopia_icon.png");
	File FRANCE_ICON = new File(path + "flag/France_icon.png");
	File KOREA_ICON = new File(path + "flag/korea.png");
	File UAE_ICON = new File(path + "flag/UAE_icon.png");

	// ( 2019 . 10 . 17 )

	File INCHEON_AIRPORT_IMAGE = new File(path + "Incheon_AirPort.png");
	File PARIS_AIRPORT_IMAGE = new File(path + "Paris_AirPort.png");
	File JFK_AIRPORT_IAMGE = new File(path + "JFK_AirPort.png");
	File SYDNEY_AIRPORT_IMAGE = new File(path + "Sydney_AirPort.png");
	File BOLE_AIRPORT_IMAGE = new File(path + "Bole_AirPort.png");
	File DUBAI_AIRPORT_IMAGE = new File(path + "Dubai_AirPort.png");

	File RIGHT_UI_BODY_BACKGOUND_PATH = new File(path + "Right_UI_Body_Backgound.png");

	// ( 2019 . 10 . 17 Add )

	int[] RIGHT_UI_HEADER = { (int) (10 * CHECK), (int) (43 * CHECK) };
	int[] RIGHT_UI_HEADER_SIZE = { (int) (450 * CHECK), (int) (600 * CHECK) };

	int[] RIGHT_UI_BODY_BACKGOUND = { (int) (25 * CHECK), (int) (250 * CHECK) };
	
	
	
	// ( 2019 . 10. 20 add )
	
	File UI_HEAD_INCHEON = new File(path+"AirPortHead_incheon.png");
	File UI_HEAD_PARIS = new File(path+"AirPortHead_Paris.png");
	File UI_HEAD_DUBAI = new File(path+"AirPortHead_dubai.png");
	File UI_HEAD_SYDNEY = new File(path+"AirPortHead_Sydney.png");
	File UI_HEAD_BOLE = new File(path+"AirPortHead_bole.png");
	File UI_HEAD_JFK = new File(path+"AirPortHead_jfk.png");
	
	File UI_NAME_INCHEON = new File(path+"incheon_name.png");
	File UI_NAME_PARIS = new File(path+"Paris_name.png");
	File UI_NAME_DUBAI = new File(path+"Dubai_name.png");
	File UI_NAME_SYDNEY = new File(path+"Sydney_name.png");
	File UI_NAME_BOLE = new File(path+"bole_name.png");
	File UI_NAME_JFK = new File(path+"JFK_name.png");
	
	
	
	// name xy location
	int[] UI_NAME = { (int)(55*CHECK), (int)(8*CHECK) };

	// head xy location
	int[] UI_HEAD = { (int)(15 * CHECK) , (int)(10*CHECK) };
	int[] UI_HEAD_SIZE = { FileSizeChk.getSize(UI_HEAD_BOLE, CHECK)[0], FileSizeChk.getSize(UI_HEAD_BOLE, CHECK)[1] };
	
	
	// ( 2019 . 10 .21 add )
	
	// Text Box
	
	int[] HEAD_TEXT_LOCATION = { (int)(175 * CHECK) , (int)(17*CHECK)};
	int[] HEADTEXT_SIZE = { (int)(250*CHECK), (int)(170*CHECK) };
	
	// plus btn
	File HEAD_AIRLINE_PLUS_BTN = new File(path + "AirLinePlusBtn.png");
	
	
	// AirLineListPlus
	
	File INCHEON_AIRLINE_LIST = new File(path + "Incheon_AirLineList.png");
	File JFK_AIRLINE_LIST = new File(path + "JFK_AirLineList.png");
	File PARIS_AIRLINE_LIST = new File(path + "Paris_AirLineList.png");
	File BOLE_AIRLINE_LIST = new File(path + "Bole_AirLineList.png");
	File SYDNEY_AIRLINE_LIST = new File(path + "Sydney_AirLineList.png");
	File DUBAI_AIRLINE_LIST = new File(path + "Dubai_AirLineList.png");
	
	File SHADOW_BACK = new File(path + "shadow_back.png");
	
	
	// ( 2019  10 .24 add )
	
	DataDummy data = new DataDummy();
	
	File NOTIMG = new File(path + "NotImg.jpg");
	
	// ( 2019 . 10 . 26 add )
	
	File FRAMEICON = new File(path + "FrameIcon.png");
	File REFLESHICON = new File(path + "RefleshIcon.png");
}
