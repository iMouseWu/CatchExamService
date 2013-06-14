package com.zjut.change;

import java.util.List;

import net.sf.json.JSONArray;

public class Change {
	public static JSONArray changeToJson(List list)
	{
		JSONArray jsonArray2= JSONArray.fromObject( list );
		return jsonArray2;
		}

}
