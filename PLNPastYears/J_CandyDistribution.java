package com.company.PLNPastYears;

import java.util.Scanner;

public class J_CandyDistribution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int numBefore= -1;
        int coinSum=0;
        int coin=0;

        for (int i = 0; i < n; i++) {
            int numAfter = sc.nextInt();
            if(numAfter <= numBefore)
                coin=1;
            else
                coin++;
            coinSum+= coin;
            numBefore = numAfter;
        }
        System.out.println("coins:"+coinSum);
    }
}
