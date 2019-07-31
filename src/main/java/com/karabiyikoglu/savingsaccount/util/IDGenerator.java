package com.karabiyikoglu.savingsaccount.util;

public final class IDGenerator {

	private IDGenerator() {}
	
	private static int ACCOUNT_ID = 100;
	
	public static synchronized int getNewAccountID() {
		return ACCOUNT_ID++;
	}
}
