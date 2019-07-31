package com.karabiyikoglu.savingsaccount.dao;

import com.karabiyikoglu.savingsaccount.model.SavingAccount;

public interface ISavingAccountRepository {

	SavingAccount find(String user);

	void insert(SavingAccount account);

	void update(SavingAccount account);

	void delete(SavingAccount account);

	boolean checkExists(String user);

}