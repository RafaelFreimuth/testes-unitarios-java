package br.ce.wcaquino.utils;

public class ObjectUtil {

	public static Boolean isNull(Object object) {
		return object.equals(null);
	}
	
	public static Boolean isNotNull(Object object) {
		return !isNull(object);
	}
}
