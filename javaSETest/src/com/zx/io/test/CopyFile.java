package com.zx.io.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class CopyFile {
	public static void main(String[] args) {
		new CopyFile().copyFile2();
	}
	
	public void copyFile(){
		try {
			InputStream in=new FileInputStream("D://aaa.txt");
			OutputStream out=new FileOutputStream("E://bbb.txt");
			byte[] b=new byte[200];
			while(-1!=in.read(b)){
				out.write(b);
			}
			in.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void copyFile2(){
		String s="";
		BufferedReader in=null;
		BufferedWriter out=null;
		System.out.println("请输入文件内容，若连续两次回车自动结束");
		try {
			in=new BufferedReader(new InputStreamReader(System.in)); //其实也可以用Scanner
			out=new BufferedWriter(new FileWriter("E://ccc.txt"));
			while((s=in.readLine()).length()!=0){  //如果想两次回车结束，不可写s=(in.readLine())!=null
				out.write(s);
				out.newLine(); //保证与控制台打印同步
				out.flush();  //保证文件内容能实时同步，否则运行过程中可能不会写人内容				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				in.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
