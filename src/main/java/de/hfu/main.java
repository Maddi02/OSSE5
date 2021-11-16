package de.hfu;

import java.util.Scanner;

public class main {

    /**
     * @param args
     *
     *
     * Hallo ich hab ein Java Doc erstellt. Ich hoffe das passt so
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Geben Sie einen Satz ein");
        String input =  scan.nextLine();
        String upperCase = input.toUpperCase();
        System.out.println(upperCase);

        util util = new util();




    }
}
