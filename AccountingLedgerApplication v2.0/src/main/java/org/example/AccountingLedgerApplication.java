package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AccountingLedgerApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(AccountingLedgerApplication.class, args);
        Main main = context.getBean(Main.class);
        main.runApp();
    }
}
