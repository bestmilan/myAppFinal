package com.wonders.utils;

import java.util.UUID;

public class RandomManage {
	// genarate random number
	public static long getRandomNum(long max, long min) {
		return Math.round(Math.random() * (max - min) + min);
	}

	// genarate uuid 
	public static String getUuid() {
		return UUID.randomUUID().toString();
	}

	// genarate random
	public static String getRandom() {
		return DateManage.getNowTimeWithOutSign() + "_" + getUuid();
	}

	
}
