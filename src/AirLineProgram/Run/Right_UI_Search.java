package AirLineProgram.Run;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class Right_UI_Search extends JPanel implements ActionListener, SettingInterface{
	Label l;
	JTextField tf;
	JButton b;
	String str = null;


	TableRowSorter<DefaultTableModel> sorter;
	
	
	public Right_UI_Search(int x, int y, TableRowSorter<DefaultTableModel> sorter) {
		tf = new JTextField(20);
		b = new JButton("검색");
		this.sorter = sorter;


		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		setLayout(gbl);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1.0;

		gbl.setConstraints(tf, gbc);
		add(tf);

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 0.1;

		gbl.setConstraints(tf, gbc);
		add(b);
		b.addActionListener(this);

		tf.addKeyListener(new KeyAdapter() {
	         public void keyPressed(KeyEvent e) {
	            if(e.getKeyCode() == KeyEvent.VK_ENTER) {
	               b.doClick();
	            }
	         }
	      });
		
		setVisible(true);
		setBounds(x, y, (int)(320*CHECK), (int)(35*CHECK));
		setOpaque(false); 
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String str = tf.getText();
		sorter.setRowFilter(RowFilter.regexFilter(str));
		sorter.setSortKeys(null);
	}

	
}

