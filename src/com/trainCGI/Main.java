package com.trainCGI;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your first name: ");
        String firstname = in.nextLine();
        System.out.println("Enter your last name ");
        String lastname = in.next();

        Email em1 = new Email(firstname, lastname);
        System.out.println(em1.showInfo());

        em1.changePassword("#Football98");
    }
}
