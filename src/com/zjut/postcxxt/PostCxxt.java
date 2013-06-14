package com.zjut.postcxxt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import com.zjut.bean.Bean;
import com.zjut.constant.Constant;
import com.zjut.getcookie.GetCookie;
import com.zjut.getcxxt.GetCxxt;

public class PostCxxt {
	public static List getResult(Cookie[] cookie,String VIEWSTATE,String year,String number) 
			            throws HttpException, IOException{
		String s;
		String out="";
		int i=0;
		String Cbo_Xueqi=year+"("+number+")";
		List list =new ArrayList();
		Bean bean = new Bean();
		HttpClient httpClient=new HttpClient();
		String url = Constant.URL;
		PostMethod postMethod = new PostMethod(url);
		NameValuePair[] data = { 
				new NameValuePair("__EVENTTARGET","LB_cxxt"),
				new NameValuePair("__EVENTARGUMENT",""),
				new NameValuePair("__VIEWSTATE",VIEWSTATE),
				new NameValuePair("Cbo_Xueqi",Cbo_Xueqi),
				new NameValuePair("Button1","≤È—Ø")
				};
		postMethod.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=gb2312");
		postMethod.setRequestHeader("cookie", cookie[0].getName()+"="+cookie[0].getValue());
		postMethod.setRequestBody(data);
	    httpClient.executeMethod(postMethod);
		InputStream instr=postMethod.getResponseBodyAsStream();
		BufferedReader in = new BufferedReader(new InputStreamReader(instr,"GBK"));
		String[] information=new String[5];
		while((s = in.readLine()) != null)
		{
			if(s.contains("<span id=\"DG_PTHasselect__"))
			{
			 Pattern p = Pattern.compile("(.*)>(.*)<(.*)",Pattern.DOTALL);
			 Matcher m = p.matcher(s);
					 while(m.find())
					 { 
						 switch(i%6){
						 case 1:
							 System.out.println(i);
							 bean.setTeacherName(m.group(2));
							 break;
						 case 2:
							 System.out.println(i);
							 bean.setCourseName(m.group(2));
							 break;
						 case 3:
							 System.out.println(i);
							 bean.setDate(m.group(2));
							 break;
						 case 4:
							 System.out.println(i);
							 bean.setExamTime(m.group(2));
							 break;
						 case 5:
							 System.out.println(i);
							 bean.setClassroomName(m.group(2));
							 break;
						 case 0:
							 System.out.println(i);
							 if(i!=0){
								 list.add(bean);
								 bean=new Bean();
							 }
							 
						 }
						 
						  
					       }
					 i++;
	    }
			
		
		
		}
		postMethod.releaseConnection();
		return list;


}
}