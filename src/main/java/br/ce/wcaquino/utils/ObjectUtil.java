package br.ce.wcaquino.utils;

public class ObjectUtil {

	public static Boolean isNull(Object object) {
		return object == null;
	}
	
	public static Boolean isNotNull(Object object) {
		return !isNull(object);
	}
}
