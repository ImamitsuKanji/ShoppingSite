package jp.co.aforce.tool;

import java.util.Random;

public class IDGenerator {
	
	public static String createID(int length) {
		
		Random random= new Random();
		StringBuilder sb= new StringBuilder();
		
		for(int i=0; i < length; i++) {
			sb.append(random.nextInt(10));
		}
		
		return sb.toString();
	}
}
