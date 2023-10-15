package org.example;

import java.util.Scanner;

public class ScannerClass {

    public static String getString(String message){
            Scanner scanner = new Scanner(System.in);
            System.out.println(message);
            return scanner.nextLine();
    }



}
