package AirLineProgram.Run;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

public class DisplayChk {

	/*
	 * DisplayChk ( 2019.10.16 )
	 * 
	 */

	public static double getDisplaySetting() {
		double set = 1.0;

		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();

		//set = width / 1920.0;

		return set;
	}
}
