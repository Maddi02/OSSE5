package de.hfu;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Geben Sie einen Satz ein");
        String input =  scan.nextLine();
        String upperCase = input.toUpperCase();

        System.out.println(upperCase);
    }
}
