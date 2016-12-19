package com.zx.io.test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;

public class MarkRestTest {
	@Test
	public void test(){
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(new File("E:/test/cutelog.txt"))));
			String s="";
			
			s=br.readLine();
			System.out.println(s);
			System.out.println(br.readLine());
			br.mark(1);
			System.out.println(br.readLine());
			System.out.println(br.readLine());
			br.reset();
			System.out.println(br.readLine());
//			System.out.println(br.readLine());
//			System.out.println(br.readLine());
//			System.out.println(br.readLine());
//			System.out.println(br.readLine());
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void test2(){
		try {
			BufferedInputStream bi=new BufferedInputStream(new FileInputStream("E:/test/cutelog.txt"));
			byte[] b=new byte[255];
			
			System.out.println(bi.read());
			bi.mark(0);
			System.out.println(bi.read());
			System.out.println(bi.read());
			System.out.println(bi.read());
			bi.reset();
			System.out.println(bi.read());
			bi.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
