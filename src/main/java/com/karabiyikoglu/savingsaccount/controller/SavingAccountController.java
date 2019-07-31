package com.karabiyikoglu.savingsaccount.controller;

import java.time.LocalTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.karabiyikoglu.savingsaccount.dao.ISavingAccountRepository;
import com.karabiyikoglu.savingsaccount.dao.InMemorySavingAccountRepository;
import com.karabiyikoglu.savingsaccount.model.SavingAccount;

@Controller    							
@RequestMapping(path="/savingaccount")
public class SavingAccountController {

	private ISavingAccountRepository savingAccountRepository = new InMemorySavingAccountRepository();
	
	@PostMapping("/create")
	public ResponseEntity<Object> create(@RequestParam String user) {
		StringBuilder responseMessage = new StringBuilder();

		boolean isValidated = validate(user, responseMessage);
		if(!isValidated) {
			return new ResponseEntity<>(responseMessage.toString(), HttpStatus.BAD_REQUEST);
		}

		SavingAccount savingAccount =  new SavingAccount(user);
		savingAccountRepository.insert(savingAccount);

		responseMessage.append("Account is created successfully. Account ID : ").append(savingAccount.getId());

		return new ResponseEntity<>(responseMessage.toString(), HttpStatus.CREATED);
	}

	private boolean validate(String user, StringBuilder responseMessage) {
		if(checkIfUserHasAccount(user)) {
			SavingAccount account = savingAccountRepository.find(user);
			responseMessage.append("The user has already had an account. ").append(account.toString());
			return false;
		}
		
		if(!checkTime()) {
			responseMessage.append("Saving accounts can only be opened between 08:00 and 17:00.");
			return false;
		}
		return true;
	}

	/**
	 * If user has already had an account method returns true, otherwise return false
	 * @return
	 */
	private boolean checkIfUserHasAccount(String user) {
		if(savingAccountRepository.checkExists(user)) {
			return true;
		}
		return false;
	}

	/**
	 * If current time is between 08:00 and 17:00 it return true, otherwise return false
	 * @return
	 */
	private boolean checkTime() {
		LocalTime now = LocalTime.now();
		if(now.isAfter(LocalTime.parse("08:00")) && now.isBefore(LocalTime.parse("17:00"))) {
			return true;
		}
		return false;
	}
}
