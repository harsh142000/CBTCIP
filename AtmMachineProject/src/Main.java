
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        AtmOperationInterf op=new AtmOperationImpl();
        int atmnumber=12345;
        int atmpin=123;
        Scanner in=new Scanner(System.in);
        System.out.println("Welcome to ATM Machine !!!");
        System.out.print("Enter Atm Card Number : ");
        int atmNumber=in.nextInt();
        System.out.print("Enter Pin: ");
        int pin=in.nextInt();
        if((atmnumber==atmNumber)&&(atmpin==pin)){
            while(true){
                System.out.println("1.View Available Balance\n2.Withdraw Amount\n3.Deposit Amount\n4.Transfer Money\n5.Transaction History\n6.Exit");
                System.out.println("Enter Choice : ");
                int ch=in.nextInt();
                if(ch==1){
                    op.viewBalance();

                }
                else if(ch==2){
                    System.out.println("Enter amount to withdraw ");
                    double withdrawAmount=in.nextDouble();
                    op.withdrawAmount(withdrawAmount);

                }
                else if(ch==3){
                    System.out.println("Enter Amount to Deposit :");
                    double depositAmount=in.nextDouble();//5000
                    op.depositAmount(depositAmount);


                }
                else if(ch==5){
                    op.viewMiniStatement();

                }
                else if(ch==4)
                {
                    System.out.print("Enter the recipient's account number: ");
                     String recipientAccountNumber = in.next();
                    if (recipientAccountNumber == null) {
                        System.out.println("Recipient's account not found.");
                    }
                    else {
                        System.out.print("Enter the Amount to be transferred: ");
                        double transfer = in.nextDouble();
                        op.transferAmount(recipientAccountNumber, transfer);
                    }
                }
                else if(ch==6){
                    System.out.println("Collect your ATM Card\n Thank you for using ATM Machine!!");
                    System.exit(0);
                }

                else
                {
                    System.out.println("Please enter correct choice");
                }
            }
        }
        else{
            System.out.println("Incorrect Atm Number or pin");
            System.exit(0);
        }


    }
}