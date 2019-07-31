# savings-account
A simple endpoint that allows user to open a savings account

Usage : 
After successfully fetching this project into workspace and updating maven dependencies; 
* Run com.karabiyikoglu.savingsaccount.SavingsAccountDemoApplication class as Java application. 
* Then it will start a spring boot application server on default port 8080.
* After server started, open the web browser and type http://localhost:8080/home
* There will be a form that can provide the data to the backend application endpoint(http://localhost:8080/savingaccount/create).
* Enter a username to submit form.
* When you submit the form, backend service controls the required conditions to open savings account.
* If everything is ok then new saving account is opened. 
* The service returns a proper message (whether the account is opened or not).

I stored the data in memory( a TreeMap) to implement this project. In the below, you can find the project files and descriptions.


src/main/java
* com.karabiyikoglu.savingsaccount.MvcConfig.java // Configuration class  
* com.karabiyikoglu.savingsaccount.SavingsAccountDemoApplication.java //Main class to run application
* com.karabiyikoglu.savingsaccount.controller.SavingAccountController.java //Endpoint service class
*	com.karabiyikoglu.savingsaccount.dao.ISavingAccountRepository.java //Saving account repository interface
*	com.karabiyikoglu.savingsaccount.dao.InMemorySavingAccountRepository.java //Saving account repository implemented in Memory
*	com.karabiyikoglu.savingsaccount.model.SavingAccount.java //Saving account object class
*	com.karabiyikoglu.savingsaccount.util.IDGenerator.java // ID generator util class

src/main/resources
* application.properties // configuration file for spring boot
* templates/home.html // Data form web page file

pom.xml 
