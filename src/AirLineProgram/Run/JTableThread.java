package AirLineProgram.Run;


public class JTableThread implements Runnable, SettingInterface {
	
	int uiSelectNum;
	Right_UI chk = StaticObject.chk;

	@Override
	public void run() {

		while (true) {
//			if (chk == null || chk != StaticObject.chk){
//				break;
//			}
//			
//			if (chk.search != null && chk.table != null) {
//				chk.remove(chk.search);
//				chk.remove(chk.table);
//			}
//			
//			System.out.println(chk.uiSelectNum);
//			chk.table = new Right_UI_JTable((int)(50*CHECK), (int)(325*CHECK), chk.uiSelectNum);
//			chk.search = new Right_UI_Search((int)(70*CHECK), (int)(275*CHECK), chk.table.getSorter());
//			
//			chk.add(chk.table, 5, 0);
//			chk.add(chk.search, 6, 0);
//			
//			chk.revalidate();
//			chk.repaint();
//		
			try {
					Thread.sleep(300001);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
