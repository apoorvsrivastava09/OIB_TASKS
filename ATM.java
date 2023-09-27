import java.util.*;

import javax.imageio.IIOException;
import javax.swing.plaf.synth.SynthSplitPaneUI;

import java.io.*;
class Account 
{
    static int acc_number=1111;
    String acc_holder_name;
    int pin;
    double balance;
    String unique_id;
    int a_no;
    void createAcc()
    {
        a_no=acc_number;
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the Acoount Holder Name");
        acc_holder_name=in.nextLine();
        System.out.println("\nEnter UserName");
        unique_id=in.nextLine();
        int length_pin=0;
        do{
            System.out.println("Enter 4 Digit Pin");
            pin=in.nextInt();
            length_pin=Integer.toString(pin).length();
        }while(length_pin!=4);
        System.out.println("Enter the initial Deposit Amount");
        balance=in.nextDouble();
        System.out.println("Congratulations Your  Account Has been Created");
        System.out.println("Account Details-\n"+"Account Number-"+a_no+"\nAccount Holder Name-"+acc_holder_name+"\nBalance-"+balance+"\nThankYou");
        String filename=acc_number+".txt";
        File file =new File(filename);
        try{
            file.createNewFile();
            FileWriter writer=new FileWriter(file);
            writer.write("Account Created\n");
            writer.write("Account Number:"+acc_number+"\n");
            writer.write("USER ID-r: "+unique_id+"\n");
            writer.write("Account Holder Name: "+acc_holder_name+"\n");
            writer.write("PIN :"+pin+"\n");
            writer.write("Balance: "+balance+"\n");
            writer.write("Date: "+new Date()+"\n\n\n");
            writer.close();


        }
        catch(IOException e)
        {
            System.out.println("An error occurred while creating the file");
            e.printStackTrace();
        }
        try{
            Thread.sleep(5000);
        }
        catch(InterruptedException e)

        {
            e.printStackTrace();
        }
        acc_number++;
        }
        
}





public class ATM {
    void withdraw(Account acc)
    {
        Scanner in=new Scanner(System.in);
        System.out.print("\033[H\033[02J");
        System.out.flush();
        System.out.println("WITHDRAW MONEY MODE\n");
        System.out.println("Enter Amount in Multiples of 100-");
        double amount=in.nextDouble();
        if(amount%100==0)
        {
            if(acc.balance>=amount){
            acc.balance-=amount;
            System.out.println("Your Transaction is Being Processed");
            try{
                String filename=acc.a_no+".txt";
                FileWriter fileWriter=new FileWriter(filename,true);
                BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
                bufferedWriter.write("Date: "+new Date()+\"n");
                bufferedWriter.write("Withdrawal: "+amount+"\n");
                bufferedWriter.write("Account Number: "+acc.a_no+"\n");
                bufferedWriter.write("Reamaining Balance: "+acc.balance+"\n");
                bufferedWriter.close();
            }
            catch(IOException e)
            {
                System.out.println("An error Occured while writing to the file");
                e.printStackTrace();
            }
            System.out.println("Thank You banking with us");
            try
            {
                Thread.sleep(6000);
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.print("\033[H\033[02J");
            System.out.flush();


        }
        else
        {
            System.out.println("Insufficient Funds");
            System.out.println("Try Again!");
        }
    }
}
    void deposit_by_transfer(Account acc,double amount)
    {
        acc.balance+=amount;
        try{
            String filename=acc.a_no+".txt";
            FileWriter fileWriter=new FileWriter(filename, true);
            BufferedWriter bf=new BufferedWriter(fileWriter);
            bf.write("Deposit: "+amount+"\n");
            bf.write("Date: "+new Date()+"\n");
            bf.write("Account Number: "+acc.a_no+"\n");
            bf.write("Remaining Balance: "+acc.balance+"\n\n");
            bf.close();
            fileWriter.close();
        }
        catch(IOException e)
        {
            System.out.println("An error occured while writing to the file");
            e.printStackTrace();
        }

    }
    void deposit(Account acc)
    {
        Scanner in=new Scanner(System.in);
        System.out.print("\033[H\033[02J");
        System.out.flush();
        System.out.println("Money Deposit Mode On");
        System.out.println("Enter the Amount You Want to Deposit");
        double amount=in.nextDouble();
        acc.balance+=amount;
        System.out.print("\033[H\033[02J");
        System.out.flush();
        try{
            String filename=acc.a_no+".txt";
            System.out.println("THE FILE NAME- "+filename);
            FileWriter fileWriter =new FileWriter(filename,true);
            BufferedWriter bf=new BufferedWriter(fileWriter);
            bf.write("Deposit: "+amount+"\n");
            bf.write("Date: "+new Date()+"\n");
            bf.write("Account Number: "+acc.a_no+"\n");
            bf.write("Remaining Balance: "+acc.balance+"\n\n");
            bf.close();
            fileWriter.close();

        }
        catch(IOException e)
        {
            System.out.println("An error occured while writing to the file");
            e.printStackTrace();

        }
        System.out.println("Processing Your Request! Please Wait");
        try{
            Thread.sleep(5000);

        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }
    void Transfer(Account acc1,Account acc2,double amount)
    {
        if(acc1.balance>=amount)
        {
            acc1.balance-=amount;
            ATM a= new ATM();
            a.deposit_by_transfer(acc2, amount);
            try{
                String filename=acc1.a_no+".txt";
                FileWriter fileWriter=new FileWriter(filename,true);
                BufferedWriter bf=new BufferedWriter(fileWriter);
                bf.write("Transferred: "+amount+"\n");
                bf.write("Date: "+new Date()+"\n");
                bf.write("Account Number: "+acc1.a_no+"\n");
                bf.write("Remaining Balance: "+acc1.balance+"\n\n");
                bf.close();
                fileWriter.close();
            }
            catch(IOException e)
            {
                System.out.println("Error occured while writing to file");
                e.printStackTrace();
            }
            System.out.println("Processing Your Request");
            try{
                Thread.sleep(5000);
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.print("\033[H\033[02J");
            System.out.flush();
            System.out.println("\n Account Transer Completed");
            try{
                Thread.sleep(5000);
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
    void display_details(Account acc)
    {
        System.out.print("\033[H\033[02J");
        System.out.flush();
        System.out.println("Displaying account Details\n");
        try{
            Thread.sleep(2000);

        }catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        int a;
        String filename=Integer.toString(acc.a_no)+".txt";
        File file=new File(filename);
        try
        {
            FileReader fr=new FileReader(file);
            BufferedReader bf=new BufferedReader(fr);
            String line=null;
            while((line=bf.readLine())!=null)
            {
                System.out.println(line);
            }
            bf.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File Not Found: "+e.getMessage());
        }
        catch(IOException e)
        {
            System.out.println("Error Reading file:"+e.getMessage());
        }
        System.out.println("Screen will automatically timeout in 30 seconds");
        try{
            Thread.sleep(3000);

        }catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }
    void quit()
    {
        System.out.println("Thank You For Banking With US");
        return;
    }
}
class run_atm
{
    int account_search_by_unique_id(Account[] ac,int account_number)
    {
        for(int i=0;i<5;i++)
        {
            if(Objects.equals(account_number,ac[i].a_no))
            return i;

        }
        return -1;
    }
    void demo(Account [] ac)
    {
        Scanner in=new Scanner(System.in);
        System.out.println("\n\n\nWelcome to ATM\n");
        System.out.println("\nEnter Your Card/Unique ID ");
        int unique_id=in.nextInt();
        int i=account_search_by_unique_id(ac, unique_id);//check this line
        if(i==-1)
        {
            System.out.println("Account not registerd Yet");
            try{
                Thread.sleep(3000);
            }catch(InterruptedException e)
            {
                e.printStackTrace();
            }
            return;
        }
        else
        {
            System.out.println("Enter Your Pin");
            int pin=in.nextInt();
            if(pin==ac[i].pin)
            {
               System.out.println("SELECT THE OPTIONS FROM THE BELOW GIVEN CHOICES \n1--Withdraw\n2--Deposit\n3--Account Transfer\n4--Display Account Details\n5--Quit"); 
               int ch;
               ATM atm=new ATM();
               ch=in.nextInt();
               switch(ch)
               {
                case 1->
                atm.withdraw(ac[i]);
                case 2-> atm.deposit(ac[i]);
                case 3->
                {
                    System.out.print("\033[H\033[02J");
                    System.out.flush();
                    System.out.println("Enter the account number to transfer funds");
                    int account_transfer=in.nextInt();
                    int j=account_search_by_unique_id(ac, account_transfer);
                    if(j==-1){
                    System.out.println("Account Not Yet Registered");
                    return;}


                
                else
                {
                    System.out.println("Enter Amount for Transferring Funds");
                    double amount=in.nextDouble();
                    atm.Transfer(ac[i], ac[j], amount);
                }

               }
               case 4 ->
               atm.display_details(ac[i]);
               case 5-> atm.quit();
            }
        }else
            {
                System.out.println("Wrong PIN Entered\n Try Again");
                try{
                    Thread.sleep(3000);

                }catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
                return;
            }
        }
    }
   
        
    
}
 class Atmst
{
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        Account[] ac=new Account[5];
        for(int i=0;i<5;i++)
        {
           System.out.print("\033[H\033[02J");
                    System.out.flush();
                    System.out.println("Creating Account Mode-\n");
                    ac[i]=new Account();
                    ac[i].createAcc();
                    System.out.print("\033[H\033[02J");
                    System.out.flush(); 
        }
        run_atm ob= new run_atm();
        for(;;)
        {
            System.out.print("\033[H\033[02J");
                    System.out.flush();
                    ob.demo(ac);
        }
    }
}

