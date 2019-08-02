package com.ido.common;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BeanSearch {

	public static List<Object> beanFilter(List<Object> objs, String search) {
		if (objs == null || objs.size() == 0)
			return objs;
		Iterator<Object> iterator = objs.iterator();
		while (iterator.hasNext()) {
			String beanString = getBeanString(iterator.next().getClass());
			if (!beanString.contains(search))
				iterator.remove();
		}
		return objs;
	}

	public static String getBeanString(Object entity) {
		List<Method> methods = getBeanMethod(entity);
		String beanString = "";
		// 遍历执行方法
		for (Method method : methods) {
			try {
				beanString += method.invoke(entity).toString();
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				System.out.println("getBeanString：" + e.getMessage());
				e.printStackTrace();
			}
		}
		return beanString;
	}

	public static List<Method> getBeanMethod(Object entity) {
		// 获得当前bean所有方法对象
		Method[] methods = entity.getClass().getDeclaredMethods();
		// List容器存放所有带get字符串的Method对象
		List<Method> list = new ArrayList<Method>();
		// 过滤当前bean类所有带methodName字符串的Method对象,存入List容器
		for (int index = 0; index < methods.length; index++) {
			if (methods[index].getName().indexOf("get") != -1) {
				list.add(methods[index]);
			}
		}
		return list;
	}
}
