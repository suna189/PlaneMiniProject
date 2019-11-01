package AirLineProgram.Run;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static AirLineProgram.Run.StaticObject.*;

public class MouseEventCall implements ActionListener,SettingInterface {
	
	JTableThread jtableSetting;

	/*
	 * 
	 * MouseEventCall Setting List ( 2019 . 10. 16 )
	 * 
	 * ( 2019 . 10 . 23 Modify )
	 * 
	 * Very Danger, Do not modify
	 * 
	 * 
	 * select : 2 >>> AirPortButton Event
	 * select : 3 >>> Right_UI_EXIT Button Event
	 * 
	 */
	
	
	Right_UI GUI;
	int select;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (select == 2) {
			
			if(StaticObject.chk != null && StaticObject.table !=null && StaticObject.search != null) {
				
				StaticObject.chk.remove(StaticObject.table);
				StaticObject.chk.remove(StaticObject.search);
				
			}
			
			
			for(int i = 0 ; i< objectArray.length ; i++) {
				Right_UI guiChk = (Right_UI)objectArray[i][1];
				AirPortButton btnChk = (AirPortButton) objectArray[i][0];
				RunProgram.mainFrame.getFrame().remove(guiChk);
				if(btnChk.getX() > RIGHT_UI[0]) {
					btnChk.setEnabled(false);
				}
			}
			RunProgram.mainFrame.getFrame().add(this.GUI,1000,0);
			this.GUI.setVisible(true);
			StaticObject.chk = this.GUI;
			
			StaticObject.table = new Right_UI_JTable(50, 325, StaticObject.chk.uiSelectNum);
			StaticObject.search = new Right_UI_Search(50, 275, StaticObject.table.getSorter());
			
			
			StaticObject.chk.add(StaticObject.table, 102, 0);
			StaticObject.chk.add(StaticObject.search, 103, 0);
			
			
			// ( 2019 . 10 .26 Modify ) Thread JTable
			
//			JTableThread jtableSetting = new JTableThread();
//			Thread jtablethread = new Thread(jtableSetting);
//			jtablethread.start();
			RunProgram.mainFrame.getFrame().revalidate();
			RunProgram.mainFrame.getFrame().repaint();
		}
		if (select == 3) {
			
			// ( 2019 . 10 . 25 Modify )
			
			if(StaticObject.picturePanel != null) {
				StaticObject.picturePanel.setVisible(false);
				RunProgram.mainFrame.getFrame().remove(StaticObject.picturePanel);
				StaticObject.picturePanel = null;
			}
			for(int i = 0 ; i< StaticObject.objectArray.length ; i++) {
				Right_UI guiChk = (Right_UI) objectArray[i][1];
				AirPortButton btnChk = (AirPortButton) objectArray[i][0];
				RunProgram.mainFrame.getFrame().remove(guiChk);
				StaticObject.chk=null;
				btnChk.setEnabled(true);
			}
			RunProgram.mainFrame.getFrame().revalidate();
			RunProgram.mainFrame.getFrame().repaint();
		}
	}

	public MouseEventCall(Right_UI GUI, int select) {
		this.GUI = GUI;
		this.select = select;
	}

	public MouseEventCall(AirPortButton btn, int select) {
		this.select = select;
		for (int i = 0; i < objectArray.length; i++) {
			if (objectArray[i][0].equals((Object)btn)) {
				this.GUI = (Right_UI) StaticObject.objectArray[i][1];
			}
		}
	}
}

































