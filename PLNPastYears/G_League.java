package com.company.PLNPastYears;

import java.util.Scanner;

public class G_League {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            System.out.println(t-1);
        }
    }
}
