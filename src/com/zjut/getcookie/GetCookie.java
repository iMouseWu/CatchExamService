package com.zjut.getcookie;

import java.io.IOException;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import com.zjut.constant.Constant;

public class GetCookie {
	static Cookie[] cookie;
	public static Cookie[] getCookie(String user,String password) throws HttpException, IOException
	{
		HttpClient httpClient = new HttpClient();
		String url = Constant._URL;
		PostMethod postMethod = new PostMethod(url);
		NameValuePair[] data = { 
				new NameValuePair("Txt_UserName",user),
				new NameValuePair("Txt_Password",password),
				new NameValuePair("__EVENTTARGET",""),
				new NameValuePair("__EVENTARGUMENT",""),
				new NameValuePair("__VIEWSTATE",Constant.VIEWSTATE),
				new NameValuePair("Cbo_LX","Ñ§Éú"),
				new NameValuePair("Img_DL.x","22"),
				new NameValuePair("Img_DL.y","2")
				};
		postMethod.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=gb2312");
		postMethod.setRequestBody(data);
		httpClient.executeMethod(postMethod);
		cookie=httpClient.getState().getCookies();
		postMethod.releaseConnection();
		return cookie;
		}
	
}
