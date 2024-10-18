package ATM_01;

import java.util.Scanner;

public class Atm_Machine {
    private int Balance;
    private int Pin;

    public Atm_Machine(int Balance, int Pin) {
        this.Balance = Balance;
        this.Pin = Pin;
    }

    public void Home_Screen() {
        System.out.println("-------------------------------------");
        System.out.println("|   ******** WELCOME ********       |");
        System.out.println("|**** PRESS 1.VIEW YOUR BALANCE ****|");
        System.out.println("|**** PRESS 2.AMOUNT DEPOSIT    ****|");
        System.out.println("|**** PRESS 3.AMOUNT WITHDRAWAL ****|");
        System.out.println("|**** PRESS 4.CHANGE YOUR PIN   ****|");
        System.out.println("| ******* PRESS 5.TO EXIT *******   |");
        System.out.println("-------------------------------------");
    }

    public void Deposit(int amount) {
        Balance += amount;
        System.out.println("YOUR BALANCE AFTER DEPOSIT = " + Balance);
    }

    public void Withdrawal(int amount) {
        if (Balance < amount) {
            System.out.println("**** INSUFFICIENT BALANCE ****");
        } else {
            Balance -= amount;
            System.out.println("YOUR BALANCE AFTER WITHDRAWAL = " + Balance);
        }
    }

    public int getBalance() {
        return Balance;
    }

    public boolean ValidatePin(int Pin) {
        return this.Pin == Pin;
    }

    public void PinChange(int newPin) {
        this.Pin = newPin;
        System.out.println("PIN CHANGED SUCCESSFULLY");
    }

    public static void main(String[] args) {

        Atm_Machine[] Atm = {
            new Atm_Machine(175482, 1505),  
            new Atm_Machine(59782, 1511),    
            new Atm_Machine(45894, 1234),   
            new Atm_Machine(25687, 5678),   
            new Atm_Machine(78412, 1909)    
        };

        Scanner sc = new Scanner(System.in);
        System.out.println("**** WELCOME TO ABC BANK OF INDIA ****");
        System.out.println();

        System.out.print("ENTER YOUR PIN = ");
        int enteredPin = sc.nextInt();

        
        Atm_Machine pin_num = null;
        for (Atm_Machine atm : Atm) {
            if (atm.ValidatePin(enteredPin)) {
                pin_num = atm;
                break;
            }
        }

        if (pin_num == null) {
            System.out.println("INVALID PIN ENTRY");
            return;
            
        }

        pin_num.Home_Screen();
        int option = 0;
        while (option != 5) {
            System.out.print("ENTER YOUR OPTION = ");
            option = sc.nextInt();
            switch (option) {
                case 1: {
                    System.out.println("BALANCE = " + pin_num.getBalance());
                    break;
                }
                case 2: {
                    System.out.print("ENTER THE AMOUNT = ");
                    int amount = sc.nextInt();
                    pin_num.Deposit(amount);
                    break;
                }
                case 3: {
                    System.out.print("ENTER THE AMOUNT = ");
                    int amount = sc.nextInt();
                    pin_num.Withdrawal(amount);
                    break;
                }
                case 4: {
                    System.out.print("ENTER YOUR NEW PIN = ");
                    int newPin = sc.nextInt();
                    pin_num.PinChange(newPin);
                    break;
                }
                case 5: {
                    System.out.println("THANK YOU! VISIT AGAIN.");
                    break;
                }
                default:
                    System.out.println("INVALID OPTION! PLEASE TRY AGAIN.");
            }
        }

        sc.close();
    }
}
