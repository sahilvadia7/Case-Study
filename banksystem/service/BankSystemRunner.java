package service;

import java.util.List;
import java.util.Scanner;

import account.Account;
import beneficiary.Beneficiary;
import customer.Customer;
import exceptions.Userinput;
import transaction.Transaction;
import java.time.LocalDateTime;


public class BankSystemRunner {

        static int opt;
        static Scanner input = new Scanner(System.in);
        static BankModel sbi = new BankModel();
        static BankSystemRunner BSR = new BankSystemRunner();


    public static void main(String[] args) {
        do{
            System.out.println("\nBanking System\n");
            System.out.println("1. Add Customers");
            System.out.println("2. Add Accounts");
            System.out.println("3. Add Beneficiary");
            System.out.println("4. Add Transaction");
            System.out.println("5. Find Customer by Id");
            System.out.println("6. List All Accounts of specific Customer");
            System.out.println("7. List All Transactions of specific Accounts");
            System.out.println("8. List All Beneficiaries of specific Customer");
            System.out.println("0. Exit");
            System.out.print("Choose the Option: ");

            try{

                if(input.hasNextInt()){
                    opt = input.nextInt();
                    if (opt>8 ) {
                        throw new Userinput("Select Proper Option");
                    }
                }
                else{
                    throw new Userinput("Strings Not Allowed");
                }
                
                
            }
            catch(Userinput e){
                System.out.println(e);
            }
        

            switch (opt) {
                case 1:
                    BSR.addCustomer();
                    break;

                case 2:
                    BSR.addAccount();
                    break;

                case 3:
                    BSR.addBeneficiary();
                    break;

                case 4:
                    BSR.addTransaction();
                    break;
                
                case 5: 
                    BSR.findCustomerById();
                    break;
                
                case 6:
                    BSR.ListAll_AccountOfSpecific_Customer();
                    break;

                case 7:
                    BSR.ListAll_Transactionsofspecific_Accounts();
                    break;

                case 8:
                    BSR.ListAll_Beneficiariesofspecific_Customer();
                    break;
                case 0: 
                    System.exit(0);
                    System.out.println("Thank You ;)");
                    break;

                // default:
                    
                //     break;
            }

        }while(opt!=0);


        input.close();
    }


    private void addBeneficiary() {
       
     int beneficiaryID, customerID ;
     String name, accountNumber, bankDetails;

     System.out.print("BeneficiaryId: ");
     beneficiaryID = input.nextInt();

     System.out.print("CustomerId: ");
     customerID = input.nextInt();

     System.out.print("Beneficiary Name: ");
     name = input.next();

     System.out.print("AccountNo: ");
     accountNumber = input.next();

     System.out.print("BankDetails: ");
     bankDetails = input.next();

     Beneficiary beneficiary = new Beneficiary(beneficiaryID, customerID, name, accountNumber, bankDetails);
     sbi.addBeneficiary(beneficiary);
    }


    private void ListAll_Beneficiariesofspecific_Customer() {
       int id;
       System.out.print("CustomerNo: ");
       id = input.nextInt();

       List<Beneficiary> beneficiaries = sbi.getBeneficiariesByCustomerId(id);
       for(Beneficiary beneficiary: beneficiaries){
        System.out.println(beneficiary);
       }
    }


    private void addTransaction() {
       int transactionId, accountID;
       String type;
       double amount;
       LocalDateTime timestamp;


       System.out.print("TransactionId: ");
       transactionId = input.nextInt();

       System.out.print("AccountId: ");
       accountID = input.nextInt();

       System.out.print("Account Type: ");
       type = input.next();

       System.out.print("Trasaction amount: ");
       amount = input.nextInt();

       

       timestamp = LocalDateTime.now();
       Transaction t = new Transaction(transactionId, accountID, type, amount, timestamp);
       sbi.addTransaction(t);
    }


    private void ListAll_Transactionsofspecific_Accounts() {
        int id;
        System.out.print("Account NO :");
        id = input.nextInt();

        List<Transaction> transactions = sbi.getTransactionsByAccountId(id);
        for(Transaction transaction: transactions){
            System.out.println(transaction);
        }
    }


    private void ListAll_AccountOfSpecific_Customer() {
        int id;

        System.out.print("CustomerId: ");
        id=input.nextInt();
        
        List<Account> account = sbi.getAccountsByCustomerId(id);
        for(Account a: account){
            System.out.println(a);
        }
    }


    private void addAccount() {

        int accountID , customerID;
        String type;
        double balance; 

        System.out.print("AccountId: ");
        accountID = input.nextInt();

        System.out.print("CustomerId: ");
        customerID = input.nextInt();

        System.out.print("Account Type: ");
        type = input.next();

        System.out.print("Account Balance: ");
        balance = input.nextDouble();

        Account account = new Account(accountID, customerID, type, balance);
        sbi.addAccount(account);
    }


    private void findCustomerById() {
        int id;
        
        System.out.print("Enter CustomerID: ");
        id = input.nextInt();

        Customer customer = sbi.findCustomerById(id);
        System.out.println(customer);
    }


    private void addCustomer() {
        
        int id;
        String name,address,phoneNo;

        System.out.print("\nEnter CustomerId: ");
        id = input.nextInt();

        System.out.print("Customer Name: ");
        name = input.next();

        System.out.print("Customer Address: ");
        address = input.next();

        System.out.print("Customer PhoneNo: ");
        phoneNo = input.next();

        Customer customer = new Customer(id, name, address, phoneNo);
        sbi.addCustomer(customer);

    }

}
