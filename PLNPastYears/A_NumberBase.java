package com.company.PLNPastYears;

import java.math.BigInteger;
import java.util.Scanner;

public class A_NumberBase {

    public static String solution(String str, int fromBase, int toBase) {
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) - '0' >= fromBase)
                return "INVALID";
        }

        if (fromBase == 10)
            return fromBase10(new BigInteger(str), toBase);
         else if (toBase == 10)
             return toBase10(str, fromBase).toString();
         else
             return fromBase10(toBase10(str, fromBase), toBase);

    }

    public static String fromBase10(BigInteger bigInt, int base){
        StringBuilder sb = new StringBuilder();

        while (!(bigInt.equals(new BigInteger("0")))) {
            sb.append(bigInt.remainder(BigInteger.valueOf(base)));
            bigInt = bigInt.divide(BigInteger.valueOf(base));
        }
        sb.reverse();
        return sb.toString();

    }
    public static BigInteger toBase10(String str,int base){
        BigInteger sum = new BigInteger("0");
        for (int i = 0; i < str.length(); i++) {
            sum = sum.add(new BigInteger(String.valueOf((int)((str.charAt(i)-'0') * Math.pow(base, str.length() - (1 + i))))));
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            String str = String.valueOf(sc.nextInt());
            int fromBase = sc.nextInt();
            int toBase = sc.nextInt();
            System.out.println(solution(str, fromBase, toBase));
        }

    }
}




