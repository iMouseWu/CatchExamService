package com.zjut.getcxxt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;

import com.zjut.constant.Constant;
import com.zjut.getcookie.GetCookie;

public class GetCxxt {
	
	public static String getCxxt(Cookie[] cookie ) throws HttpException, IOException{
		String s;
		String out="";
		HttpClient httpClient=new HttpClient();
		String url = Constant.URL;
		GetMethod getMethod = new GetMethod(url);
		getMethod.setRequestHeader("cookie", cookie[0].getName()+"="+cookie[0].getValue());
		httpClient.executeMethod(getMethod);
		InputStream instr=getMethod.getResponseBodyAsStream();
		BufferedReader in = new BufferedReader(new InputStreamReader(instr,"GBK"));
		while(( s = in.readLine()) != null)
		{
			if(s.contains("<input type=\"hidden\" name=\"__VIEWSTATE\" "))
		{
			String[] match=s.split("\"");
			out=match[5];
			}
			}
		getMethod.releaseConnection();
		return out;
		}

}
