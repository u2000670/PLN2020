package com.company.PLNPastYears;

import java.math.BigInteger;
import java.util.Scanner;

public class C_Cubes {
    public static void solution(int k) {
        System.out.println(BigInteger.valueOf((long) (3 * k * Math.pow(k + 1, 2))) + " " + BigInteger.valueOf((long) Math.pow(k + 1, 3)));

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            solution(k);

        }
    }
}
