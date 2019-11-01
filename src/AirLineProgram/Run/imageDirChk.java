package AirLineProgram.Run;

import java.io.File;

public class imageDirChk {

	/*
	 * imageDirChk ( 2019.10.16 )
	 * 
	 * Search Range ( Project Directory )
	 * 
	 */

	public static String getPath() {

		
		// Project Directory Select
		
		
		String path = imageDirChk.class.getResource("imageDirChk.class").getPath();
		
		System.out.println(path);
		String[] arrayPath = path.split("/");
		
		int length = arrayPath.length;

		int length02 = 0;

		for (int i = 0; i < length; i++) {
			if (arrayPath[i].equals("MiniProject_1024")) {
				length02 = i+1;
				break;
			}
		}
		//System.out.println(arrayPath[1]);
		path = "";

		for (int i = 0; i < length - (length - length02); i++) {

			path += arrayPath[i] + "/";
		}
		
		System.out.println(path);
		
		// Project Under Directory Search
		
		path = SearchDir(path);
		
		System.out.println(path);
		
		if(path.equals(null)) {
			System.out.println("File Path Error : imageDirChk.java Modify Please!");
			System.exit(0);
		}
		
		
		return path;
	}

		
	// Project Under Directory Search Method
	
	private static String SearchDir(String path) {

		String tmp = null;

		String[] tmpArray = new File(path).list();
		
		System.out.println(path);
		
		for (int i = 0; i < tmpArray.length; i++) {
			if (tmpArray[i].equals("ProgramImage")) {
				tmp = path + tmpArray[i] + "/";
				break;
			} else if (new File(path + tmpArray[i]).isDirectory()) {
				
				tmp = SearchDir(path + tmpArray[i]+"/");
			}
			if(tmp != null) {
				break;
			}
		}
		
		return tmp;
	}
}
