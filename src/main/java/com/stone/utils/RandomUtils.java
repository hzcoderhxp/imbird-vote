package com.stone.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class RandomUtils {
	public static String getRandom(int c) {
		Random r = new Random();
		SimpleDateFormat format = new SimpleDateFormat("ssSSS");
		Date d = new Date();
		StringBuffer sb = new StringBuffer();
		// for(int i = 0; i < c; i ++){
		sb.append(format.format(d));
		sb.append(r.nextInt(10));
		// }
		//// System.out.println(sb.toString());
		// return sb.toString().substring(1,7);
		return sb.toString();
	}
	public static String getRandomWithLength(int length) {
		Random random = new Random();
		StringBuilder ret = new StringBuilder();
		for (int i = 0; i < length; i++) {
			boolean isChar = (random.nextInt(2) % 2 == 0);
			if (isChar) {
				int choice = (random.nextInt(2) % 2 == 0) ? 65 : 97;
				ret.append((char) (choice + random.nextInt(26)));
			} else {
				ret.append(Integer.toString(random.nextInt(10)));
			}
		}
		return ret.toString();
	}

	public static String getSMSCODE() {
		int x = (int) (Math.random() * 9000 + 1000);
		return String.valueOf(x);
	}

	public static void main(String args[]) {
		System.out.println(RandomUtils.getRandom(6));
		// System.out.println(RandomUtil.genMobile());
	}

	public static String genMobile() {
		StringBuffer sb = new StringBuffer();
		Random r = new Random();
		SimpleDateFormat format = new SimpleDateFormat("DDssSSS");
		Date d = new Date();
		sb.append("1");
		sb.append("3");
		sb.append(r.nextInt(10));
		sb.append(format.format(d));
		return sb.toString();
	}
}