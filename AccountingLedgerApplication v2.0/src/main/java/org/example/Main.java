package org.example;

import org.springframework.stereotype.Component;

@Component
public class Main {
    private final TransactionService transactionService;

    public Main(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    public void runApp() {
        // Instantiates the Screens class with the transaction service
        Screens screens = new Screens(transactionService);

        // Show loading animation
        screens.loadingSpinner();

        // Displays the main menu to the user
        screens.displayMainMenu();
    }



//    public static void main(String[] args) {
//        ApplicationContext context = SpringApplication.run(Main.class, args);
//
//        // Get the TransactionManager bean from the context
//        TransactionService transactionService = context.getBean(TransactionService.class);
//
//        // Load transactions from the database (if needed)
//        // transactionManager.readTransactions(); // Not needed as transactions will be managed by JPA
//
//        // Instantiates the Screens class with the transaction manager
//        Screens screens = new Screens(transactionService);
//
//        // Show loading animation
//        screens.loadingSpinner();
//
//        // Displays the main menu to the user
//        screens.displayMainMenu();
//    }




//    public static void main(String[] args) {
//        // Creates a new instance of TransactionManager
//        TransactionManager transactionManager = new TransactionManager("src/main/resources/transactions.csv");
//
//        // Load transactions from CSV file
//        transactionManager.readTransactions();
//
//        // Instantiates the Screens class with the transaction manager
//        Screens screens = new Screens(transactionManager);
//
//        // Show loading animation
//        screens.loadingSpinner();
//
//        // Displays the main menu to the user
//        screens.displayMainMenu();
//    }
}