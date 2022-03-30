package com.company.PLNPastYears;

import java.util.Scanner;
//solution from opengenus : https://iq.opengenus.org/make-string-stable/

public class I_StableBraces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < t; i++) {
            String str = sc.nextLine();
            System.out.println(solution(str));
        }

    }

    public static int solution(String str) {
        char[] braces = str.toCharArray();
        int op = 0;
        int balance = 0;

        for (int i = 0; i < braces.length; i++) {

            if(braces[i] == '{')
                balance++;
            else
                balance--;

            if(balance < 0){
                op++;
                balance+=2;
            }
        }

        if(balance >0)
            op += balance/2;
        return op;

    }

}

