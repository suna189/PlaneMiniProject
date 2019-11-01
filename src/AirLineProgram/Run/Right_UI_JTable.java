package AirLineProgram.Run;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

public class Right_UI_JTable extends JPanel implements SettingInterface{

	JScrollPane sp;
	JTextField tf;
	JButton b01;
	TableRowSorter<DefaultTableModel> sorter;
	int uiSelectNum;
	DefaultTableModel model;
	Right_UI_JTable_PopUp pop;
	JTable table;
	String AirportCode;

	// Class 선언해줘야 getResource를 쓸 수 있어용~
	protected static final Class thisClass = Right_UI_JTable.class;

	public Right_UI_JTable(int x, int y, int uiSelectNum) {
		setLayout(new BorderLayout());
		//setPreferredSize(new Dimension(500, 200));
		String inputDataSearch = null;

		if (uiSelectNum == 1) {

			inputDataSearch = "ICN";

		} else if (uiSelectNum == 2) {
			inputDataSearch = "JFK";

		} else if (uiSelectNum == 3) {
			inputDataSearch = "CDG";

		} else if (uiSelectNum == 4) {
			inputDataSearch = "ADD";

		} else if (uiSelectNum == 5) {
			inputDataSearch = "SYD";

		} else if (uiSelectNum == 6) {
			inputDataSearch = "DXB";

		}
		AirportCode = inputDataSearch;

		table = new JTable();
		JScrollPane pane = new JScrollPane(table);

		// column title
		model = (DefaultTableModel) table.getModel();

		model.addColumn("도시");
		model.addColumn("항공사");
		model.addColumn("비행편");
		model.addColumn("출발시간");
		model.addColumn("도착시간");
		model.addColumn("Terminal");
		model.addColumn("CheckInORBaggage");
		model.addColumn("Gate");
		model.addColumn("출발/도착");

		Date nowTime = new Date();
		// 시간만
		SimpleDateFormat dateFormatH = new SimpleDateFormat("HH");
		// 분만
		SimpleDateFormat dateFormatM = new SimpleDateFormat("mm");
		int nowHour = Integer.parseInt(dateFormatH.format(nowTime)) * 60;
		// 현재 분
		int nowMinute = Integer.parseInt(dateFormatM.format(nowTime));
		
		
//		System.out.println("시작");
		// data
		int row = 0;
		for (int i = 0; i < DataDummy.airLine.length; i++) {
//			System.out.println(inputDataSearch);
			int a_Hour = Integer.parseInt(DataDummy.a_time[i].split(":")[0]) * 60;
			int a_Min = Integer.parseInt(DataDummy.a_time[i].split(":")[1]);
			
			if(a_Hour + a_Min > nowHour + nowMinute) {
				if (DataDummy.s_airportCode[i].equals(inputDataSearch)) {
//
//					System.out.println("출발 : " + DataDummy.s_airportCode[i] + DataDummy.s_airport[i]);
//					System.out.println("도착 : " + DataDummy.a_airportCode[i] + DataDummy.a_airport[i]);

					model.addRow(new Object[0]);

					if (DataDummy.a_airportCode[i].equals("DXB")) {

						model.setValueAt(new DataWithIcon(DataDummy.a_airport[i],
								new ImageIcon(path+"/flag/UAE_icon.png")), row, 0);
					} else if (DataDummy.a_airportCode[i].equals("SYD")) {

						model.setValueAt(
								new DataWithIcon(DataDummy.a_airport[i],
										new ImageIcon(path+"/flag/Australia_icon.png")),
								row, 0);
					} else if (DataDummy.a_airportCode[i].equals("JFK")) {

						model.setValueAt(
								new DataWithIcon(DataDummy.a_airport[i],
										new ImageIcon(path+"/flag/America_icon.png")),
								row, 0);
					} else if (DataDummy.a_airportCode[i].equals("CDG")) {

						model.setValueAt(
								new DataWithIcon(DataDummy.a_airport[i],
										new ImageIcon(path+"/flag/France_icon.png")),
								row, 0);
					} else if (DataDummy.a_airportCode[i].equals("ADD")) {

						model.setValueAt(
								new DataWithIcon(DataDummy.a_airport[i],
										new ImageIcon(path+"/flag/Ethiopia_icon.png")),
								row, 0);
					} else if (DataDummy.a_airportCode[i].equals("ICN")) {

						model.setValueAt(
								new DataWithIcon(DataDummy.a_airport[i],
										new ImageIcon(path+"/flag/Korea_icon.png")),
								row, 0);
					}

					model.setValueAt(DataDummy.airLine[i], row, 1);
					model.setValueAt(DataDummy.flight_Code[i], row, 2);
					model.setValueAt(DataDummy.s_time[i], row, 3);
					model.setValueAt(DataDummy.a_time[i], row, 4);
					model.setValueAt(DataDummy.s_terminal[i], row, 5);
					model.setValueAt(DataDummy.checkin[i], row, 6);
					model.setValueAt(DataDummy.s_gate[i], row, 7);
					model.setValueAt("출발", row, 8);
					row++;

					table.getColumn("Terminal").setMinWidth(0);
					table.getColumn("Terminal").setMaxWidth(0);
					table.getColumn("CheckInORBaggage").setMinWidth(0);
					table.getColumn("CheckInORBaggage").setMaxWidth(0);
					table.getColumn("Gate").setMinWidth(0);
					table.getColumn("Gate").setMaxWidth(0);
				}

				if (DataDummy.a_airportCode[i].equals(inputDataSearch)) {
					model.addRow(new Object[0]);

					if (DataDummy.s_airportCode[i].equals("DXB")) {
						model.setValueAt(new DataWithIcon(DataDummy.s_airport[i],
								new ImageIcon(path+"/flag/UAE_icon.png")), row, 0);
					} else if (DataDummy.s_airportCode[i].equals("SYD")) {
						model.setValueAt(
								new DataWithIcon(DataDummy.s_airport[i],
										new ImageIcon(path+"/flag/Australia_icon.png")),
								row, 0);
					} else if (DataDummy.s_airportCode[i].equals("JFK")) {
						model.setValueAt(
								new DataWithIcon(DataDummy.s_airport[i],
										new ImageIcon(path+"/flag/America_icon.png")),
								row, 0);
					} else if (DataDummy.s_airportCode[i].equals("CDG")) {
						model.setValueAt(
								new DataWithIcon(DataDummy.s_airport[i],
										new ImageIcon(path+"/flag/France_icon.png")),
								row, 0);
					} else if (DataDummy.s_airportCode[i].equals("ADD")) {
						model.setValueAt(
								new DataWithIcon(DataDummy.s_airport[i],
										new ImageIcon(path+"/flag/Ethiopia_icon.png")),
								row, 0);
					} else if (DataDummy.s_airportCode[i].equals("ICN")) {
						model.setValueAt(
								new DataWithIcon(DataDummy.s_airport[i],
										new ImageIcon(path+"/flag/Korea_icon.png")),
								row, 0);
					}

					model.setValueAt(DataDummy.airLine[i], row, 1);
					model.setValueAt(DataDummy.flight_Code[i], row, 2);
					model.setValueAt(DataDummy.s_time[i], row, 3);
					model.setValueAt(DataDummy.a_time[i], row, 4);
					model.setValueAt(DataDummy.s_terminal[i], row, 5);
					model.setValueAt(DataDummy.baggage[i], row, 6);
					model.setValueAt(DataDummy.a_gate[i], row, 7);
					model.setValueAt("도착", row, 8);
//					
					table.getColumn("Terminal").setMinWidth(0);
					table.getColumn("Terminal").setMaxWidth(0);
					table.getColumn("CheckInORBaggage").setMinWidth(0);
					table.getColumn("CheckInORBaggage").setMaxWidth(0);
					table.getColumn("Gate").setMinWidth(0);
					table.getColumn("Gate").setMaxWidth(0);
					row++;
				}
			}
		}

		// Header Sort
		sorter = new TableRowSorter<DefaultTableModel>(model);
		table.setRowSorter(sorter);

		table.setShowHorizontalLines(true);
		table.setDefaultEditor(Object.class, null);
//		table.setIntercellSpacing(new Dimension(10,4));
		table.getTableHeader().setReorderingAllowed(false);

		// cell renderer 와 연결
		TableColumnModel tcm = table.getColumnModel();
		TextWithIconCellRenderer renderer = new TextWithIconCellRenderer();
		tcm.getColumn(0).setCellRenderer(renderer);
		// 컬럼 사이즈 조정
		tcm.getColumn(0).setPreferredWidth((int)(120*CHECK));
		tcm.getColumn(1).setPreferredWidth((int)(160*CHECK));
		tcm.getColumn(2).setPreferredWidth((int)(80*CHECK));
		tcm.getColumn(3).setPreferredWidth((int)(75*CHECK));
		tcm.getColumn(4).setPreferredWidth((int)(75*CHECK));
		tcm.getColumn(5).setPreferredWidth((int)(50*CHECK));
		// 컬럼 가운데 정렬
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(8).setCellRenderer(centerRenderer);

		DefaultTableCellRenderer rdr = (DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer();
		rdr.setHorizontalAlignment(SwingConstants.CENTER);
		table.getTableHeader().setDefaultRenderer(rdr);

		pane.setOpaque(false);
		table.setOpaque(false);
		add(pane, BorderLayout.CENTER);

		
		setBounds(x, y, (int)(370*CHECK), (int)(500*CHECK));
		setOpaque(false);
		setVisible(true);

		MyMouseListener ml = new MyMouseListener(table, pop, this);
		table.addMouseListener(ml);

	}
	class MyMouseListener extends MouseAdapter {
		JTable chk;
		Right_UI_JTable_PopUp chk2;
		Right_UI_JTable tb;
		int i;

		@Override
		public void mouseClicked(MouseEvent e) {

			if (e.getClickCount() > 1) {

				i = table.rowAtPoint(e.getPoint());
				System.out.println(i);
				chk2 = new Right_UI_JTable_PopUp(i, tb);
				chk2.setVisible(true);

			}

		}

		public MyMouseListener(JTable chk, Right_UI_JTable_PopUp chk2, Right_UI_JTable tb) {
			this.chk = chk;
			this.chk2 = chk2;
			this.tb = tb;
		}
	}

	public TableRowSorter<DefaultTableModel> getSorter() {
		return sorter;
	}
}

class DataWithIcon {
	protected Icon icon;
	protected Object data;

	public DataWithIcon(Object data, Icon icon) {
		this.data = data;
		this.icon = icon;
	}

	public Icon getIcon() {
		return icon;
	}

	public Object getDate() {
		return data;
	}

	public String toString() {
		return data.toString();
	}
}

class TextWithIconCellRenderer extends DefaultTableCellRenderer {
	protected void setValue(Object value) {
		if (value instanceof DataWithIcon) {
			if (value != null) {
				DataWithIcon d = (DataWithIcon) value;
				Object dataValue = d.getDate();

				setText(dataValue == null ? "" : dataValue.toString());
				setIcon(d.getIcon());
			} else {
				setText("");
				setIcon(null);
			}
		} else {
			super.setValue(value);
		}
	}
}
