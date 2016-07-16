package cc.hdp.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;


public class ConvertUtils {
	//对象属性null转换为""
	public static void nullConverNullString(Object obj) { 
		if (obj != null) { 

		Class classz = obj.getClass(); 
		// 获取所有该对象的属性值 
		Field fields[] = classz.getDeclaredFields(); 

		// 遍历属性值，取得所有属性为 null 值的 
		for (Field field : fields) { 
			try { 
			Type t = field.getGenericType(); 
			if (!t.toString().equals("boolean")) { 
			Method m = classz.getMethod("get" + change(field.getName())); 
			Object name = m.invoke(obj);// 调用该字段的get方法 
			if (name == null) { 
	
			Method mtd = classz.getMethod("set" + change(field.getName()), new Class[] { String.class });// 取得所需类的方法对象 
			mtd.invoke(obj, new Object[] { "" });// 执行相应赋值方法 
			} 
			} 
			} catch (Exception e) { 
			e.printStackTrace(); 
			} 
		} 
		}
	} 

	public static String change(String src) { 
		if (src != null) { 
		StringBuffer sb = new StringBuffer(src); 
		sb.setCharAt(0, Character.toUpperCase(sb.charAt(0))); 
			return sb.toString(); 
		} else { 
			return null; 
		}
	} 
}
