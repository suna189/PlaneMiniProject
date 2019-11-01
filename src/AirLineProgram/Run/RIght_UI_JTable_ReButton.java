package AirLineProgram.Run;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class RIght_UI_JTable_ReButton extends JButton implements ActionListener, SettingInterface {
	
	Image img = null;
	int uiSelectNum;

	public RIght_UI_JTable_ReButton(int uiSelectNum) {
		this.uiSelectNum = uiSelectNum;

		setBounds(393, 279, 26, 26);
		setBorderPainted(false);
		setContentAreaFilled(false);

		try {
			img = ImageIO.read(REFLESHICON);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		setIcon(new ImageIcon(img));
		addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		StaticObject.chk.remove(StaticObject.table);
		StaticObject.chk.remove(StaticObject.search);
		StaticObject.table = new Right_UI_JTable(50, 325, uiSelectNum);
		StaticObject.search = new Right_UI_Search(50, 275, StaticObject.table.getSorter());
		StaticObject.chk.add(StaticObject.search, 150, 0);
		StaticObject.chk.add(StaticObject.table, 151, 0);
		RunProgram.mainFrame.getFrame().revalidate();
		RunProgram.mainFrame.getFrame().repaint();
		
	}
}
