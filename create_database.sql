DROP DATABASE IF EXISTS TransactionDB;

-- Create the database
CREATE DATABASE TransactionDB;

-- Use the database
USE TransactionDB;

-- Create the transactions table
CREATE TABLE transactions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    date DATE NOT NULL,
    time TIME NOT NULL,
    description VARCHAR(255),
    vendor VARCHAR(255),
    amount DECIMAL(10, 2)
);

-- Insert data into the transactions table
INSERT INTO transactions (date, time, description, vendor, amount) VALUES
('2023-02-15', '12:30:45', 'Lunch with coworkers', 'Cafeteria', -20.50),
('2023-03-03', '17:45:20', 'Grocery shopping', 'Supermart', -75.25),
('2023-04-21', '09:10:35', 'Medical appointment', 'City Hospital', -150.00),
('2023-05-09', '08:20:00', 'Fuel refill', 'Gas Station', -40.75),
('2023-06-27', '14:55:10', 'Dinner date', 'Fine Dining Restaurant', -100.00),
('2023-07-14', '11:40:30', 'Haircut', 'Salon Deluxe', -35.50),
('2023-08-02', '16:25:15', 'Movie tickets', 'Cinema World', -25.00),
('2023-09-18', '10:15:00', 'Brunch with friends', 'Café Terrace', -45.75),
('2023-10-05', '13:00:20', 'Online shopping', 'E-commerce Store', -90.25),
('2023-11-23', '19:30:45', 'Dinner party', 'Friend''s House', -80.00),
('2023-12-10', '08:50:10', 'Gift shopping', 'Department Store', -120.50),
('2024-01-28', '15:15:30', 'Gym membership renewal', 'Fitness Center', -60.00),
('2024-02-15', '12:00:00', 'Valentine''s Day dinner', 'Romantic Bistro', -150.75),
('2024-03-09', '10:45:20', 'Coffee and pastry', 'Café Mocha', -15.25),
('2024-04-27', '11:20:35', 'Home repairs', 'Handyman Services', -200.50),
('2023-02-20', '14:10:25', 'Freelance work payment', 'Client A', 150.00),
('2023-05-03', '09:45:30', 'Sold old furniture', 'Online Marketplace', 200.50),
('2023-07-18', '12:20:15', 'Consultation fee', 'Legal Services', 300.75),
('2023-10-10', '16:30:00', 'Stock dividends', 'Investment Firm', 75.25),
('2024-01-15', '11:55:45', 'Artwork sale', 'Gallery', 500.00),
('2022-03-10', '15:30:45', 'Freelance project payment', 'Client A', 300.00),
('2022-05-05', '12:45:30', 'Sold old textbooks', 'Online Marketplace', 50.25),
('2022-07-20', '09:20:15', 'Consultation fee', 'Legal Services', 150.75),
('2022-09-14', '14:00:00', 'Car repair expenses', 'Auto Service Center', -200.50),
('2022-11-28', '11:55:45', 'Grocery shopping', 'Supermarket', -75.00),
('2024-04-29', '13:22:13', 'Getting starbucks', 'Starbucks', -8.50),
('2024-04-29', '13:22:43', 'Biweekly paycheck', 'YearUp', 100.00),
('2024-03-20', '10:45:00', 'Annual membership renewal', 'Gym', -199.00),
('2023-11-11', '14:15:00', 'Advertisement expense', 'Google Ads', -500.00),
('2022-09-05', '12:00:00', 'Consultation fee', 'XYZ Consulting', -350.00),
('2024-04-15', '14:30:00', 'Employee training expense', 'Training Center', -200.00),
('2024-04-05', '15:30:00', 'Travel reimbursement', 'Company', 300.00),
('2023-01-22', '08:10:05', 'Printer ink cartridges', 'Office Depot', -45.50),
('2022-12-03', '14:00:00', 'Freelance project payment', 'Client A', 750.00),
('2022-08-20', '15:45:20', 'Office chair purchase', 'Staples', -199.99),
('2024-04-10', '12:00:00', 'Website maintenance fee', 'Web Developer', -150.00),
('2024-07-05', '16:00:00', 'Marketing campaign expense', 'Marketing Agency', -1000.00),
('2024-11-25', '10:00:00', 'Product launch event expense', 'Event Planner', -700.00),
('2024-12-05', '12:45:00', 'Office furniture purchase', 'Furniture Store', -600.00),
('2023-04-28', '16:55:40', 'Business dinner expense', 'Restaurant XYZ', -85.75),
('2023-03-05', '11:30:15', 'Utilities bill payment', 'Utility Company', -150.00),
('2022-11-12', '10:20:30', 'Website hosting renewal', 'GoDaddy', -120.00),
('2024-06-10', '11:45:00', 'Consulting fee payment', 'Consultant C', -450.00),
('2023-09-30', '09:45:30', 'Software subscription renewal', 'Adobe', -299.99),
('2024-12-25', '08:00:00', 'Holiday bonus', 'Company', 800.00),
('2024-12-31', '16:30:00', 'End-of-year party expense', 'Event Venue', -1000.00),
('2024-09-18', '09:30:00', 'Monthly subscription fee', 'Streaming Service', -14.99),
('2022-06-10', '09:30:45', 'Wire transfer received', 'Bank', 5000.00),
('2024-02-14', '08:30:00', 'Valentine''s Day gift purchase', 'Gift Shop', -50.00),
('2024-04-15', '09:00:00', 'Tax refund', 'Government', 500.00),
('2024-08-20', '14:00:00', 'Customer refund', 'Company', 150.00),
('2023-06-18', '10:00:00', 'Sales revenue', 'Customer B', 1200.00),
('2024-05-01', '10:15:00', 'New laptop purchase', 'Electronics Store', -899.99),
('2024-10-12', '13:20:00', 'Conference ticket purchase', 'Conference Organizer', -250.00),
('2024-05-02', '10:27:15', 'Netflix Subscription', 'Netflix', -18.99),
('2024-05-02', '10:28:09', 'Auto Insurance', 'ABC Insurance', -235.00),
('2024-05-02', '10:34:31', 'Walmart paycheck', 'walmart', 1454.00),
('2024-05-03', '12:01:27', 'walmart check', 'walmart', 1454.00),
('2024-05-03', '12:01:53', 'dinner', 'burger king', -45.00),
('2024-05-05', '19:48:36', 'direct deposit', 'walmart', 1000.00),
('2024-07-02', '09:30:33', 'check', 'CVS', 1500.00),
('2024-07-02', '09:31:09', 'rent', 'appartments', -1500.00);
