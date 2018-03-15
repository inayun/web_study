package com.example.spring.basic02;

public final class GlobalObject {

		
		private static Object value = null;
		public GlobalObject() {}
		
		public synchronized static void setValue(Object o) {
			value = o;
		}
		
		public static Object getValue() {
			return value;
		}
		
	
}
