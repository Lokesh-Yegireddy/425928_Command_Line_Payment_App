create database Tech_M;
use tech_m;

  
create table User_Details(User_Id int primary key , User_Name varchar(30) Not Null ,
                          Password varchar(15),First_Name varchar(15),Last_Name varchar(15),
                          Phone_Number varchar(10) unique,Email varchar(50) unique ,Address text );
desc User_Details;



create table User_Account_Details(User_Account_Id int  primary key,Account_open_Date date not null,
                                  Current_Wallet_Balance bigint default 0,Linked_Bank_Accounts_Count int default 0,
                                  Wallet_Pin varchar(10) not null,
                                  foreign key (User_Account_Id) references User_Details(User_Id));
                                  
ALTER TABLE User_Account_Details 
MODIFY COLUMN Current_Wallet_Balance DECIMAL(15,2) DEFAULT 0.00;

desc User_Account_Details;

CREATE TABLE Bank_Accounts (
    Bank_Account_Id INT PRIMARY KEY ,
    User_Id INT NOT NULL,
    Account_Number VARCHAR(20) UNIQUE NOT NULL,
    IFSC_Code VARCHAR(20) NOT NULL,
    Is_Active VARCHAR(3),
    Bank_Name VARCHAR(50) NOT NULL,
    Bank_Account_Branch_Location VARCHAR(15) NOT NULL,
    FOREIGN KEY (User_Id) REFERENCES User_Details(User_Id) 
);

desc  Bank_Accounts;

create table Source_Types(Source_Id int primary key,Source_Type_Code varchar(3),Source_Type_Desc varchar(30));

desc Source_Types;

create table Txn_details(Txn_Id int primary key, Txn_Date_Time datetime  , 
                         Source_Id int,foreign key(Source_Id) references User_Details(User_Id), 
                         Target_Id int ,foreign key(Target_Id) references User_Details(User_Id),
                         Source_Type_Id int , Dest_Type_Id int ,
                         foreign key ( Source_Type_Id ) references Source_Types( Source_Id),
                         foreign key (Dest_Type_Id) references Source_Types( Source_Id ),Txn_Amount bigint);

ALTER TABLE Txn_details MODIFY COLUMN Txn_Amount DECIMAL(15,2);

desc Txn_details;

CREATE TABLE User_Reward_Details (
    Reward_Id INT PRIMARY KEY ,
    User_Id INT,
    Reward_Value DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (User_Id) REFERENCES User_Details(User_Id) 
);

INSERT INTO User_Details (User_Id, User_Name, Password, First_Name, Last_Name, Phone_Number, Email, Address) VALUES
(1, 'rahul123', 'pass@123', 'Rahul', 'Sharma', '9876543210', 'rahul.sharma@gmail.com', 'Delhi, India'),
(2, 'priya_92', 'secure@456', 'Priya', 'Verma', '9823456789', 'priya.verma@gmail.com', 'Mumbai, India'),
(3, 'arjun_07', 'arjun@789', 'Arjun', 'Mehta', '9812345678', 'arjun.mehta@gmail.com', 'Pune, India'),
(4, 'deepak_raj', 'deep@pass', 'Deepak', 'Rajput', '9786543210', 'deepak.rajput@gmail.com', 'Bangalore, India'),
(5, 'neha_k', 'neha@123', 'Neha', 'Kapoor', '9898989898', 'neha.kapoor@gmail.com', 'Chennai, India'),
(6, 'ananya_s', 'ananya@007', 'Ananya', 'Singh', '9765432109', 'ananya.singh@gmail.com', 'Kolkata, India'),
(7, 'vikram_01', 'vikram@111', 'Vikram', 'Gupta', '9900112233', 'vikram.gupta@gmail.com', 'Hyderabad, India'),
(8, 'rakesh_k', 'rakesh@xyz', 'Rakesh', 'Kumar', '9876123456', 'rakesh.kumar@gmail.com', 'Ahmedabad, India'),
(9, 'divya_p', 'divya@999', 'Divya', 'Patel', '9123456789', 'divya.patel@gmail.com', 'Lucknow, India'),
(10, 'suresh_r', 'suresh@pass', 'Suresh', 'Reddy', '9012345678', 'suresh.reddy@gmail.com', 'Vizag, India');

INSERT INTO User_Account_Details (User_Account_Id, Account_open_Date, Current_Wallet_Balance, Linked_Bank_Accounts_Count, Wallet_Pin) VALUES
(1, '2024-01-10', 5000.00, 2, '1234'),
(2, '2023-11-15', 12000.50, 1, '5678'),
(3, '2024-02-01', 4500.00, 3, '9876'),
(4, '2023-12-20', 8500.75, 2, '4321'),
(5, '2023-09-05', 6700.25, 1, '2468'),
(6, '2024-03-18', 3000.00, 1, '1357'),
(7, '2023-10-28', 9500.60, 2, '8642'),
(8, '2024-01-25', 11200.00, 2, '7531'),
(9, '2023-08-14', 7800.99, 1, '3698'),
(10, '2023-07-30', 4300.80, 1, '2584');


INSERT INTO Bank_Accounts (Bank_Account_Id, User_Id, Account_Number, IFSC_Code, Is_Active, Bank_Name, Bank_Account_Branch_Location) VALUES
(1, 1, '123456789012', 'HDFC0001234', 'YES', 'HDFC Bank', 'Delhi'),
(2, 2, '987654321098', 'ICIC0004321', 'YES', 'ICICI Bank', 'Mumbai'),
(3, 3, '567890123456', 'SBI0005678', 'YES', 'SBI', 'Pune'),
(4, 4, '345678901234', 'AXIS0007890', 'YES', 'Axis Bank', 'Bangalore'),
(5, 5, '234567890123', 'KOTK0001111', 'YES', 'Kotak Mahindra', 'Chennai'),
(6, 6, '456789012345', 'PNB0002222', 'YES', 'Punjab National Bank', 'Kolkata'),
(7, 7, '789012345678', 'BOB0003333', 'YES', 'Bank of Baroda', 'Hyderabad'),
(8, 8, '890123456789', 'YESB0004444', 'YES', 'Yes Bank', 'Ahmedabad'),
(9, 9, '901234567890', 'IDFC0005555', 'YES', 'IDFC First Bank', 'Lucknow'),
(10, 10, '678901234567', 'SBIN0006666', 'YES', 'SBI', 'Vizag');


INSERT INTO Source_Types (Source_Id, Source_Type_Code, Source_Type_Desc) VALUES
(1, 'BA', 'Bank Account'),
(2, 'WA', 'Wallet'),
(3, 'TPT', 'Third-Party Transaction');


INSERT INTO Txn_Details (Txn_Id, Txn_Date_Time, Source_Id, Target_Id, Source_Type_Id, Dest_Type_Id, Txn_Amount) VALUES
(1, '2024-03-10 10:15:00', 1, 2, 2, 2, 1500.00),
(2, '2024-03-11 14:30:00', 3, 4, 2, 1, 3200.75),
(3, '2024-03-12 09:45:00', 5, 6, 1, 1, 5400.50),
(4, '2024-03-13 18:00:00', 7, 8, 1, 2, 2000.00),
(5, '2024-03-14 20:20:00', 9, 10, 3, 3, 2750.25),
(6, '2024-03-15 11:10:00', 2, 5, 2, 1, 1250.75),
(7, '2024-03-16 15:40:00', 6, 1, 1, 2, 3000.60),
(8, '2024-03-17 08:25:00', 8, 3, 2, 2, 4500.80),
(9, '2024-03-18 13:55:00', 4, 7, 3, 1, 6300.00),
(10, '2024-03-19 17:10:00', 10, 9, 1, 3, 2900.90);


INSERT INTO User_Reward_Details (Reward_Id, User_Id, Reward_Value) VALUES
(1, 1, 100.00),
(2, 2, 250.50),
(3, 3, 150.00),
(4, 4, 300.25),
(5, 5, 50.75),
(6, 6, 200.00),
(7, 7, 175.60),
(8, 8, 275.80),
(9, 9, 125.99),
(10, 10, 220.80);


-- Select all data from User_Details table
SELECT * FROM User_Details;

-- Select all data from User_Account_Details table
SELECT * FROM User_Account_Details;

-- Select all data from Bank_Accounts table
SELECT * FROM Bank_Accounts;

-- Select all data from Source_Types table
SELECT * FROM Source_Types;

-- Select all data from Txn_details table
SELECT * FROM Txn_details;

-- Select all data from User_Reward_Details table
SELECT * FROM User_Reward_Details;


-- queries
 
-- 1. Display number of users present in the application  
SELECT COUNT(User_Id) AS No_of_users FROM User_Details;

-- 2. Total number of transactions done in the system  
SELECT COUNT(Txn_Id) AS Total_transactions FROM Txn_Details;

-- 3. Fetch the total transactions per each user  
SELECT User_Id, COUNT(*) AS Total_Transactions FROM (
    SELECT Source_Id AS User_Id FROM Txn_Details
    UNION ALL
    SELECT Target_Id FROM Txn_Details
) AS All_Transactions
GROUP BY User_Id
ORDER BY Total_Transactions DESC;

-- 4. Display all the active users  
SELECT COUNT(Bank_Account_Id) AS No_Active_Accounts FROM Bank_Accounts WHERE Is_Active = 'YES';

-- 5. Display all the usernames of inactive accounts  
SELECT U.User_Name AS Inactive_Users 
FROM User_Details U 
INNER JOIN Bank_Accounts B ON U.User_Id = B.User_Id  
WHERE B.Is_Active = 'NO';

-- 6. Display personal details of a user  
SELECT * FROM User_Details WHERE User_Id = 18;

-- 7. Validate the user while login  
SELECT User_Id FROM User_Details WHERE User_Name = 'rahul123' AND Password = 'pass@123';

-- 8. Fetch the total bank accounts linked to a user  
SELECT User_Account_Id, Linked_Bank_Accounts_Count FROM User_Account_Details;

-- 9. Check my current wallet balance  
SELECT Current_Wallet_Balance FROM User_Account_Details WHERE User_Account_Id = 2;  

-- 10. On which date I've created my wallet  
SELECT Account_Open_Date AS Created_Date FROM User_Account_Details WHERE User_Account_Id = 3;  

-- 11. Show latest transaction of a user  
SELECT Txn_Id, Txn_Date_Time, Txn_Amount  
FROM Txn_Details  
WHERE Source_Id = 2 OR Target_Id = 2  
ORDER BY Txn_Date_Time DESC LIMIT 1;

-- 12. How much money I sent so far  
SELECT SUM(Txn_Amount) AS Total_Debited_Amount FROM Txn_Details WHERE Source_Id = 1;

-- 13. How much money I've received  
SELECT SUM(Txn_Amount) AS Total_Credited_Amount FROM Txn_Details WHERE Target_Id = 4;

-- 14. Highest transaction amount sent by a user  
SELECT MAX(Txn_Amount) FROM Txn_Details WHERE Source_Id = 5;

-- 15. Checking rewards for a user  
SELECT Reward_Id, Reward_Value FROM User_Reward_Details WHERE User_Id = 2; 

-- 16. Which users have the highest rewards  
SELECT User_Id, Reward_Value  
FROM User_Reward_Details  
WHERE Reward_Value = (SELECT MAX(Reward_Value) FROM User_Reward_Details); 

-- 17. Find users with multiple bank accounts linked  
SELECT User_Account_Id FROM User_Account_Details WHERE Linked_Bank_Accounts_Count > 1;

-- 18. Which source type (Bank, Wallet, UPI) is used the most?  
SELECT ST.Source_Type_Desc, COUNT(T.Txn_Id) AS Usage_Count  
FROM Source_Types ST  
JOIN Txn_Details T ON ST.Source_Id = T.Source_Type_Id  
GROUP BY ST.Source_Type_Desc  
ORDER BY Usage_Count DESC  
LIMIT 1;

-- 19. List all transactions where I received money  
SELECT Txn_Id, Txn_Amount FROM Txn_Details WHERE Target_Id = 2; 

-- 20. Show how much money is sent and received from a user  
SELECT  
    (SELECT SUM(Txn_Amount) FROM Txn_Details WHERE Source_Id = 2) AS Sent,  
    (SELECT SUM(Txn_Amount) FROM Txn_Details WHERE Target_Id = 2) AS Received;

-- 21. User's highest transaction made  
SELECT MAX(Txn_Amount) FROM Txn_Details WHERE Source_Id = 2 OR Target_Id = 2;

-- 22. Fetch user details using phone number  
SELECT * FROM User_Details WHERE Phone_Number = '9876543210';

-- 23. List the last 5 transactions of a user  
SELECT Txn_Id, Txn_Date_Time, Txn_Amount  
FROM Txn_Details  
WHERE Source_Id = 2 OR Target_Id = 2  
ORDER BY Txn_Date_Time DESC LIMIT 5;

-- 24. Count how many times a user received money  
SELECT COUNT(*) AS Total_Credits FROM Txn_Details WHERE Target_Id = 3;

-- 25. Show all linked bank accounts for a user  
SELECT Bank_Account_Id, Bank_Name FROM Bank_Accounts WHERE User_Id = 2;

-- 26. Get transaction summary for a user (Sent, Received, Total Transactions)  
SELECT  
    (SELECT SUM(Txn_Amount) FROM Txn_Details WHERE Source_Id = 2) AS Total_Sent,  
    (SELECT SUM(Txn_Amount) FROM Txn_Details WHERE Target_Id = 2) AS Total_Received,  
    COUNT(*) AS Total_Transactions  
FROM Txn_Details  
WHERE Source_Id = 2 OR Target_Id = 2;



