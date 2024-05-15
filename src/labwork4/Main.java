package labwork4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       ClientAccount acc1 = new ClientAccount(2000,"Maria", null);
        ClientAccount acc3 = new ClientAccount(3000,"Max", null);
       ClientAccount[] arr = new ClientAccount[]{acc1,acc3};
       ClientAccount acc2 = new ClientAccount(1000,"Ann", arr);

        System.out.println("What would you like to do? deposit, withdraw, transfer");
        while(true) {
            acc2.makeChangesToBalance();
        }
    }
}
