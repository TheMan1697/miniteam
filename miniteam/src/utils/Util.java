package utils;

import java.util.Scanner;

public class Util {
	static Scanner scanner = new Scanner(System.in);

//	public static String nextLine1(String tmp) {
//		System.out.println(tmp);
//		return scanner.nextLine();
//	}
	public static String nextLine(String input) {
		System.out.println(input);
		return scanner.nextLine();
	}
	
	public static int nextInt(String input) {
		return Integer.parseInt(nextLine(input));
	}
}
