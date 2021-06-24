package com.nit.test;

public class TestApp {

	public static void main(String[] args) throws Exception {

//		loading class using Class.forName(-)
		Class<?> clazz1 = Class.forName("java.util.Date");
		System.out.println(clazz1);
		System.out.println(clazz1.getClass() + "     " + clazz1.newInstance());
		System.out.println("---------------------------------------------");

//		loading class object using newInstance()
		Class<System> clazz2 = System.class;
		System.out.println(clazz2.getClass());
		
		String s1= "java.util.Date";
		System.out.println(Class.forName(s1).newInstance());

	}

}
