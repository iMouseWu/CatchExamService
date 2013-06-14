package com.zjut.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetData {
	
	public static String getDate(BufferedReader in) throws IOException{
		String s;
		String backdata[] = new String[100];
		while((s = in.readLine()) != null){
			if(s.contains("<span id=\"DG_PTHasselect__")){
				 Pattern p = Pattern.compile("(.*)>(.*)<(.*)",Pattern.DOTALL);
				 Matcher m = p.matcher(s);
			}
			
		}
		
		return "";
	}
	

}
