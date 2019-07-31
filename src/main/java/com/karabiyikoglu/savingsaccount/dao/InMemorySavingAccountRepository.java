package com.karabiyikoglu.savingsaccount.dao;

import java.util.Map;
import java.util.TreeMap;

import com.karabiyikoglu.savingsaccount.model.SavingAccount;

public class InMemorySavingAccountRepository implements ISavingAccountRepository {

	private static Map<String, SavingAccount> accountTable = new TreeMap<>();
	
	static {
		SavingAccount dummyAccount1 = new SavingAccount("Dummy1");
		accountTable.put(dummyAccount1.getUser(), dummyAccount1);

		SavingAccount dummyAccount2 = new SavingAccount("Dummy2");
		accountTable.put(dummyAccount2.getUser(), dummyAccount2);
	}
	
	@Override
	public SavingAccount find(String user) {
		return accountTable.get(user);
	}
	
	@Override
	public void insert(SavingAccount account) {
		accountTable.put(account.getUser(), account);
	}
	
	@Override
	public void update(SavingAccount account) {
		accountTable.remove(account.getUser());
		accountTable.put(account.getUser(), account);
	}
	
	@Override
	public void delete(SavingAccount account) {
		accountTable.remove(account.getUser());
	}
	
	@Override
	public boolean checkExists(String user) {
		return accountTable.containsKey(user);
	}
}
