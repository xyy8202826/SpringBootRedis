package com.xyy.sbr.util;

import java.util.Collection;

public abstract class ListUtil {
	
	public static <T> String  printCollection(Collection<T> listT){
		StringBuilder sb=new StringBuilder();
		if(listT==null){
			sb.append("null");
		}else{
			sb.append("{");
			for(T t:listT){
				sb.append("[");
				sb.append(t.toString());
				sb.append("]");
			}
			sb.append("}");
		}
		return sb.toString();
	}
}
