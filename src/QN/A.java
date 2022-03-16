/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package QN;

import java.util.Scanner;

public class A {

    public static void numberedLetters(String ch) {
        int diff = ch.compareToIgnoreCase("a");
        if (diff >= 0 && diff <= 2) {

            for (int i = -1; i < diff; i++) {
                System.out.print("2");
            }
        } else if (diff >= 3 && diff <= 5) {

            for (int i = 2; i < diff; i++) {
                System.out.print("3");
            }
        } else if (diff >= 6 && diff <= 8) {

            for (int i = 5; i < diff; i++) {
                System.out.print("4");
            }
        } else if (diff >= 9 && diff <= 11) {

            for (int i = 8; i < diff; i++) {
                System.out.print("5");
            }
        } else if (diff >= 12 && diff <= 14) {

            for (int i = 11; i < diff; i++) {
                System.out.print("6");
            }
        } else if (diff >= 15 && diff <= 18) {

            for (int i = 14; i < diff; i++) {
                System.out.print("7");
            }
        } else if (diff >= 19 && diff <= 21) {

            for (int i = 18; i < diff; i++) {
                System.out.print("8");
            }
        } else if (diff >= 22 && diff <= 25) {

            for (int i = 21; i < diff; i++) {
                System.out.print("9");
            }
        } else if (diff == -65) {
            System.out.print("0");
        } else {
            System.out.print("X");
        }

//        System.out.println("");
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s = new Scanner(System.in);
        int count = 0;
        int countLett = 0;
        
        System.out.print("Input number of test cases: ");
        int testCase = s.nextInt();
        s.nextLine();
        
whilelable:
        while (count < testCase) {
            String line = s.nextLine();
                
            String[] letters = line.split("");

            System.out.print("translation: ");
            for (String letter : letters) {
                if (!((letter.compareToIgnoreCase("a")>=0 && letter.compareToIgnoreCase("z")<=0) || letter.compareToIgnoreCase("a")== -65)){
                    System.out.println("XX TRY AGAIN XX");
                    continue whilelable;
                }
                numberedLetters(letter);
            }
            
            System.out.println("");
            count++;
        }
    }

}
