package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public void addTransaction(Transaction t) {
        transactionRepository.save(t);
    }

    public List<Transaction> getTransactions() {
        return transactionRepository.findAll();
    }

    public List<Transaction> filterDeposits() {
        return transactionRepository.findByAmountGreaterThan(0);
    }

    public List<Transaction> filterPayments() {
        return transactionRepository.findByAmountLessThan(0);
    }

    public List<Transaction> customSearch(String startDate, String endDate, String description, String vendor, Double amount) {
        List<Transaction> transactions = new ArrayList<>();

        if (!description.isEmpty()) {
            transactions = transactionRepository.findByDescriptionIgnoreCase(description);
        } else if (!vendor.isEmpty()) {
            transactions = transactionRepository.findByVendorIgnoreCase(vendor);
        } else {
            LocalDate start = startDate.isEmpty() ? LocalDate.MIN : LocalDate.parse(startDate);
            LocalDate end = endDate.isEmpty() ? LocalDate.MAX : LocalDate.parse(endDate);
            transactions = transactionRepository.findByDateBetween(start, end);
        }

        if (amount != null) {
            transactions = transactions.stream()
                    .filter(t -> t.getAmount() == amount)
                    .collect(Collectors.toList());
        }

        return transactions;
    }

    public List<Transaction> findByDescriptionIgnoreCase(String description) {
        return transactionRepository.findByDescriptionIgnoreCase(description);
    }

    public List<Transaction> findByVendorIgnoreCase(String vendor) {
        return transactionRepository.findByVendorIgnoreCase(vendor);
    }

    // Remove readTransactions and writeTransaction methods as they are not needed with the database



//    private List<Transaction> transactions;
//    private String filePath;
//
//    public TransactionManager(String filePath) {
//        this.transactions = new ArrayList<>();
//        this.filePath = filePath;
//    }
//
//    public void addTransaction(Transaction t) {
//        transactions.add(t);
//        writeTransaction(t);
//    }
//
//    public List<Transaction> getTransactions() {
//        return new ArrayList<>(transactions);
//    }
//
//    public List<Transaction> filterDeposits() {
//        List<Transaction> deposits = new ArrayList<>();
//        for (Transaction t : transactions) {
//            if (t.getAmount() > 0) {
//                deposits.add(t);
//            }
//        }
//        return deposits;
//    }
//
//    public List<Transaction> filterPayments() {
//        List<Transaction> payments = new ArrayList<>();
//        for (Transaction t : transactions) {
//            if (t.getAmount() < 0) {
//                payments.add(t);
//            }
//        }
//        return payments;
//    }
//
//    public List<Transaction> customSearch(String startDate, String endDate, String description, String vendor, Double amount) {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        return transactions.stream()
//                .filter(t -> (startDate.isEmpty() || !LocalDate.parse(t.getDate(), formatter).isBefore(LocalDate.parse(startDate, formatter))) &&
//                        (endDate.isEmpty() || !LocalDate.parse(t.getDate(), formatter).isAfter(LocalDate.parse(endDate, formatter))) &&
//                        (description.isEmpty() || t.getDescription().equalsIgnoreCase(description)) &&
//                        (vendor.isEmpty() || t.getVendor().equalsIgnoreCase(vendor)) &&
//                        (amount == null || t.getAmount() == amount))
//                .collect(Collectors.toList());
//    }
//
//
//    public void readTransactions() {
//        File file = new File(filePath);
//        if (!file.exists()) {
//            System.out.println("File does not exist: " + filePath);
//            return;
//        }
//
//        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                // Assuming the first line is headers, which should be skipped
//                if (line.contains("date|time|description|vendor|amount")) continue;
//                String[] data = line.split("\\|");
//                if (data.length == 5) {
//                    String date = data[0];
//                    String time = data[1];
//                    String description = data[2];
//                    String vendor = data[3];
//                    double amount = Double.parseDouble(data[4]);
//                    Transaction transaction = new Transaction(date, time, description, vendor, amount);
//                    transactions.add(transaction);
//                }
//            }
//        } catch (IOException e) {
//            System.out.println("Error reading the file: " + e.getMessage());
//        } catch (NumberFormatException e) {
//            System.out.println("Error parsing amount: " + e.getMessage());
//        }
//        System.out.println("\nLOADING APPLICATION, PLEASE WAIT..." );
////        System.out.println("Total transactions loaded: " + transactions.size());
//
//    }
//
//
//    public void writeTransaction(Transaction t) {
//        File file = new File(filePath);
//        boolean isFirstTransaction = file.length() == 0;  // Check if the file is empty
//
//        try (FileWriter fw = new FileWriter(file, true);
//             BufferedWriter bw = new BufferedWriter(fw);
//             PrintWriter out = new PrintWriter(bw)) {
//            // Format the transaction data
//            String transactionData = String.format("%s|%s|%s|%s|%.2f",
//                    t.getDate(),
//                    t.getTime(),
//                    t.getDescription(),
//                    t.getVendor(),
//                    t.getAmount());
//
//            // Write transaction data directly without a leading newline
//            if (!isFirstTransaction) {
//                out.println();  // Write a newline before the transaction if it's not the first transaction
//            }
//            out.print(transactionData);  // Use print to avoid automatic newline from println
//
//        } catch (IOException e) {
//            System.out.println("Error writing to the file: " + e.getMessage());
//        }
//    }
//
//
//    public static class Transaction {
//        private String date;
//        private String time;
//        private String description;
//        private String vendor;
//        private double amount;
//
//
//        public Transaction(String date, String time, String description, String vendor, double amount) {
//            this.date = date;
//            this.time = time;
//            this.description = description;
//            this.vendor = vendor;
//            this.amount = amount;
//        }
//
//        public String getDate() {
//            return date;
//        }
//
//        public void setDate(String date) {
//            this.date = date;
//        }
//
//        public String getTime() {
//            return time;
//        }
//
//        public void setTime(String time) {
//            this.time = time;
//        }
//
//        public String getDescription() {
//            return description;
//        }
//
//        public void setDescription(String description) {
//            this.description = description;
//        }
//
//        public String getVendor() {
//            return vendor;
//        }
//
//        public void setVendor(String vendor) {
//            this.vendor = vendor;
//        }
//
//        public double getAmount() {
//            return amount;
//        }
//
//        public void setAmount(double amount) {
//            this.amount = amount;
//        }
//
//        public String toString() {
//            return String.format("\033[1;33m%-12s\033[0m| \033[1;33m%-8s\033[0m| %-30s | %-25s | \033[1;32m%.2f\033[0m",
//                    date, time, description, vendor, amount);
//        }
//    }
}
