package QN;

import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
class LCM {

    public BigInteger findLCM(String a, String b) {
        BigInteger lcm;
        
        BigInteger num1 = new BigInteger(a);
        BigInteger num2 = new BigInteger(b);
  
        BigInteger prod = num1.multiply(num2);
        BigInteger gcd = num1.gcd(num2);
  
        lcm = prod.divide(gcd);
        return lcm;
/*
        int largerNum = Math.max(a, b);
        int smallerNum = Math.min(a, b);

        if (a == 0 || b == 0) {
            return 0;
        }

        lcm = largerNum;
        while (lcm % smallerNum != 0) {
            lcm += largerNum;
        }
        return lcm;
*/
    }

}

public class D {

    public static void main(String[] args) {
        Random r = new Random();

        /*
        int[] nums = new int[3];
        
        for (int i = 0; i < nums.length; i++) {
//            nums[i] = r.nextInt(999) + 2;
            nums[i] = r.nextInt(101);
            System.out.print(nums[i] + " ");
        }
        System.out.println("");

        LCM l = new LCM();
        int lcm = 0;
        for (int i = 1; i < nums.length; i++) {

            if (i - 1 == 0) {

                lcm = l.findLCM(nums[i], nums[i - 1]);
                System.out.print(nums[i] + " " + nums[i - 1]);
                System.out.println("\tLCM : " + lcm);
            } else {
                System.out.println(lcm + " " + nums[i]);
                lcm = l.findLCM(lcm, i);
                System.out.println("\tLCM : " + lcm);
            }
        }
         */
        Scanner s = new Scanner(System.in);
        int testCase, n;

        do {
            System.out.print("Input test case: ");
            testCase = s.nextInt();
        } while (!(testCase >= 1 && testCase <= 225));
        do {
            System.out.print("Num of races:");
            n = s.nextInt();
        } while (!(n >= 2 && n <= 1000));

        String[] eatPeriods = new String[n];
        int[] xArray = new int[n];
        int checkX = 0;
//        while (checkX != n) {
//            checkX = 0;
            for (int i = 0; i < eatPeriods.length; i++) {
                eatPeriods[i] = s.next();

//                if (xArray[i] >= 1 && xArray[i] <= 10000) {
//                    checkX++;
//                }
            }
//        }

        for (String eatPeriod : eatPeriods) {
            System.out.print(eatPeriod+" ");
        }
        System.out.println("");
        
        LCM l = new LCM();
        BigInteger lcmBigInt;
        String lcmStr = "";
        for (int i = 1; i < eatPeriods.length; i++) {

            if (i - 1 == 0) {
                
                lcmBigInt = l.findLCM(eatPeriods[i], eatPeriods[i - 1]);
                System.out.print(eatPeriods[i] + " " + eatPeriods[i - 1]);
                System.out.println("\tLCM : " + lcmBigInt);
                
                lcmStr = lcmBigInt.toString();
                
            } else {
                System.out.println(lcmStr + " " + eatPeriods[i]);
                lcmBigInt = l.findLCM(lcmStr, eatPeriods[i]);
                System.out.println("\tLCM : " + lcmBigInt);
            } //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
        }

    }

}
