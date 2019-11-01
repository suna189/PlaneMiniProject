package AirLineProgram.Run;


public class StaticObject implements SettingInterface {
	
	/*
	 * StaticObject ( 2019.10.16 )
	 * 
	 */
	
	
	// AirPortButton Object
	
	public static AirPortButton seoulBtn = new AirPortButton(SEOUL[0], SEOUL[1], SEOUL_ICON_PAHT);
	public static AirPortButton newYorkBtn = new AirPortButton(NEWYORK[0], NEWYORK[1], NEWYORK_ICON_PAHT);
	public static AirPortButton parisBtn = new AirPortButton(PARIS[0], PARIS[1], PARIS_ICON_PAHT);
	public static AirPortButton addisAbabbaBtn = new AirPortButton(ADDIS_ABABBA[0], ADDIS_ABABBA[1], ADDIS_ABABBA_ICON_PAHT);
	public static AirPortButton sydneyBtn = new AirPortButton(SYDNEY[0], SYDNEY[1], SYDNEY_ICON_PAHT);
	public static AirPortButton dubaiBtn = new AirPortButton(DUBAI[0], DUBAI[1], DUBAI_ICON_PAHT);
	
	// Right Panel UI Object
	// ( 2019 . 10 . 17 )
	// ( 2019 . 10 . 20 modify )
	
	public static Right_UI seoulUI;
	public static Right_UI newYorkUI;
	public static Right_UI parisUI;
	public static Right_UI addisAbabbaUI;
	public static Right_UI sydneyUI;
	public static Right_UI dubaiUI;
	
	public static Right_UI chk = null;

	public static PicturePanel picturePanel = null;
	
	//public static JTableThread chkThread = null;
	
	public static Right_UI_JTable table = null;
	public static Right_UI_Search search = null;
	
	/*
	 * 1 : Seoul
	 * 2 : NewYork
	 * 3 : Paris
	 * 4 : Addis Ababba
	 * 5 : Sydney
	 * 6 : Dubai
	 * 
	 */

	
	// AirPortButton & Right Panel UI Array Object

	public static Object[][] objectArray;
	public StaticObject() {
		
		seoulUI = new Right_UI(1);
		newYorkUI = new Right_UI(2);
		parisUI = new Right_UI(3);
		addisAbabbaUI = new Right_UI(4);
		sydneyUI = new Right_UI(5);
		dubaiUI = new Right_UI(6);
		
		objectArray = new Object[][]{
				{seoulBtn, seoulUI}, {newYorkBtn, newYorkUI}, {parisBtn, parisUI}, {addisAbabbaBtn, addisAbabbaUI}, {sydneyBtn, sydneyUI}, {dubaiBtn, dubaiUI}
		};
		
	}
}
