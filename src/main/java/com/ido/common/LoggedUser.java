package com.ido.common;

import java.util.HashMap;
import java.util.UUID;

import com.ido.bean.Employee;

public class LoggedUser {
	public static HashMap<String, Employee> loggedUser = new HashMap<>();

	public static Employee GetEmpByUUID(String uuid) {
		return loggedUser.get(uuid);
	}

	public static String AddUUID(Employee emp) {
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		loggedUser.put(uuid, emp);
		return uuid;
	}
}
