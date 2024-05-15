package labwork4;

import java.util.Arrays;
import java.io.*;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class ClientAccount {
    private int balance;
    private String clientName;
    private ClientAccount[] payees;

    public ClientAccount(int balance, String clientName, ClientAccount[] payees) {
        this.balance = balance;
        this.clientName = clientName;
        this.payees = payees;
    }
    public ClientAccount(){
        this.balance = 0;
        this.clientName = "defaultName";
        this.payees = new ClientAccount[0];
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
    public void addPayees(ClientAccount account){

    }
    public ClientAccount[] getPayees() {
        return payees;
    }

    public void setPayees(ClientAccount[] payees) {
        this.payees = payees;
    }

    public void makeChangesToBalance()
    {
        String amount;
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        switch (input) {
            case ("deposit"):
                System.out.println("How much money would you like to deposit?");
                amount = scanner.nextLine();
                try{
                    balance += Integer.parseInt(amount);
                    System.out.println("New balance: " + balance);
                    break;
                }catch(Exception ex){
                    System.out.println("Wrong input!");
                   }


            case ("withdraw"):
                System.out.println("How much money would you like to withdraw?");
                 amount = scanner.nextLine();
                try{
                    balance -= Integer.parseInt(amount);
                    System.out.println("New balance: " + balance);
                    break;
                }catch(Exception ex){
                    System.out.println("Input must be a number!");
                    }

            case ("transfer"):
                int in;
                int payeeBalance;
                System.out.println("Choose payees");
                System.out.println("Available payees: ");
                for(ClientAccount acc : payees){
                    System.out.println(acc.getClientName());
                }
                try {
                    String payee = scanner.nextLine();
                    for (var i = 0; i < payees.length; i++) {

                        if (payees[i].getClientName().equals(payee)) {
                            System.out.println("Choose an amount: ");

                            try {
                                in = Integer.parseInt(scanner.nextLine());
                                if (in <= balance) {
                                    balance -= in;
                                    payeeBalance = payees[i].getBalance() + in;
                                    payees[i].setBalance(payeeBalance);
                                    System.out.println("New balance: " + balance);
                                    System.out.println(payee + " balance: " + payees[i].getBalance());
                                    break;
                                }
                            } catch (Exception ex) {
                                System.out.println("Input must be a number!");
                            }

                        }else {throw  new Exception();}
                    }
                }catch(Exception ex){};
            default:{
                System.out.println("What would you like to do? deposit, withdraw, transfer");
            }
        }

    }
}
