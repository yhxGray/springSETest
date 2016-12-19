package com.zx.exception.test;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import org.junit.Test;

public class CSVTest {
	
	@Test
	public void csvExportTest(){
		writeCSV(); 
	}
	
	public void writeCSV(){
		try {
			FileOutputStream fo=new FileOutputStream("E:/test/aa.csv");
			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(fo));
			for(int i=0;i<10000;i++){
				bw.append("1,aa,2,ss,dd"+i);
				bw.newLine();
			}
			bw.close();
			fo.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
