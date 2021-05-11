package com.trainCGI;

import java.util.Scanner;

public class Email {
    private String firstname;
    private String lastname;
    private String password;
    private String email;
    private int mailboxCapacity = 500;
    private String alternateEmail;

    //Constructor to receive the first name and last name
    public Email(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;

        //Call a method asking for the department - return department
        String department = setDepartment();

        //Cal method to generate random password
        this.password = randPassword(8);
        System.out.println("Your password is: " + this.password);

        //Combine elements to generate email
        String companySuffix = "cgi.com";
        email = firstname.toLowerCase() + "." + lastname.toLowerCase() + "@" + department + "." + companySuffix;
    }

    //Ask for department
    private String setDepartment(){
        System.out.print("Enter the department\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code: ");
        Scanner in = new Scanner(System.in);
        //Get department code from user
        int depChoice = in.nextInt();
        //Determine which department based on code entered
        switch (depChoice){
            case 1:
                return "sales";
            case 2:
                return "dev";
            case 3:
                return "acct";
            default:
                return "";
        }
    }

    //Generate a random password
    private String randPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%987654321";
        char [] password = new char[length];
        for (int i = 0; i < length; i++) {
            //Create random number from 0 to passwordSet length and cast as int
            int rand = (int) (Math.random() * passwordSet.length());
            //Add to password array the random character
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    //Set the mailbox capacity
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }

    //Set the alternate email
    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }

    //Change the password
    public void changePassword(String password){
        this.password = password;
        System.out.println("Your new password is: " + password);
    }

    //Implement get methods
    public int getMailboxCapacity(){ return mailboxCapacity; }
    public String getAlternateEmail(){ return alternateEmail; }
    public String getPassword(){ return password; }

    public String showInfo(){
        return "\nDisplay Name: " + firstname + " " + lastname +
                "\nCompany Email: " + email +
                "\nMailbox Capacity: " + mailboxCapacity + "mb";
    }
}
