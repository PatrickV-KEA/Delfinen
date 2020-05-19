package demo;

import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    Scanner scan = new Scanner(System.in);

    public void printString(String string) {
        System.out.println(string);
    }

    public void print(String string) {
        System.out.print(string);
    }

    //Loops through the arraylist one index at a time. and prints the objects one line at a time
    public void printArraylist(ArrayList arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            printString(arrayList.get(i).toString());
        }
    }

    public void printArraylistFive(ArrayList arrayList) {
        for (int i = 0;  i < arrayList.size(); i++) {
           if(i<5)
            printString(arrayList.get(i).toString());
        }
    }

    public int scannerInt() {
        int number;
        while (!scan.hasNextInt()) {
            System.out.println("Vælg et heltal");
            System.out.print(">> ");
            scan.nextLine();
        }
        number = scan.nextInt();
        return number;
    }

    public float scannerFloat() {
        float number;
        while (!scan.hasNextFloat()) {
            scan.nextLine();
            System.out.println("Vælg et tal");
            System.out.print(">> ");
            scan.nextLine();
        }
        number = scan.nextFloat();
        return number;
    }

    public void scannerLine() {
        scan.nextLine();
        scan.nextLine();
    }

    public String scannerString() {
        String str;
        while (!scan.hasNext()) {
            System.out.println("Skriv tekst");
            System.out.print(">> ");
            scan.nextLine();
        }
        str = scan.next();
        return str;
    }

    public String scannerStringLine() {
        String str;
        scan.nextLine();
        str = scan.nextLine();
        return str;
    }

    public void clear() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }
}
