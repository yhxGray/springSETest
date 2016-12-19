
package com.zx.i18n.test;

import java.text.MessageFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class I18NTest {
	public static void main(String[] args) {
		Locale lc=null;
		if(args.length==2){
			lc=new Locale(args[0], args[1]);
		}else{
			lc=Locale.getDefault();
		}
		ResourceBundle rb=ResourceBundle.getBundle("my", lc);
		String msg=rb.getString("msg");
		System.out.println(rb.getString("hello"));
		System.out.println(MessageFormat.format(msg, "wkk",new Date()));
	}
}
