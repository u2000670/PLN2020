package QN;

import java.util.Random;
import java.util.Scanner;

public class B {

    static int randomBinaryDigit() {

        int num = ((int) (Math.random() * 100) + 1) % 2;
        return num;
    }

    static String randomBinaryNum(int N) {

        String str = "";
        for (int i = 0; i < N; i++) {

            int x = randomBinaryDigit();
            str += String.valueOf(x);
        }
        return str;
    }

    static void randomIps() {
        Random r = new Random();

        int[] ipDec = new int[4];
        for (int i = 0; i < ipDec.length; i++) {
            ipDec[i] = r.nextInt(256);
            if (i == 3) {
                System.out.println(ipDec[i]);
                break;
            }
            System.out.print(ipDec[i] + ".");
        }

        String[] ipBin = new String[4];
        for (int i = 0; i < ipBin.length; i++) {
            ipBin[i] = randomBinaryNum(8);
            if (i == 3) {
                System.out.println(ipBin[i]);
                break;
            }
            System.out.print(ipBin[i] + ".");
        }

        int same = 0;
        for (int i = 0; i < ipBin.length; i++) {
            String convertedBin = Integer.toBinaryString(ipDec[i]);
            if (convertedBin.equals(ipBin[i])) {
                same++;
            }
        }

        if (same == 4) {
            System.out.println(">>>>>> Yes");
        } else {
            System.out.println("****** No");
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        int testCase = s.nextInt();
        s.nextLine();
        
        for (int i = 0; i < testCase; i++) {
        
        String ipDecString = s.nextLine();
        String[] ipDecStringArray = ipDecString.split("\\.");
        int[] ipDecNumArray = new int[4];
        
        for (int j = 0; j < ipDecNumArray.length; j++) {
            ipDecNumArray[j] = Integer.parseInt(ipDecStringArray[j]);
        }
        
        String ipBinString = s.nextLine();
        String[] ipBinStringArray = ipBinString.split("\\.");
        
        int same = 0;
        for (int k = 0; k < ipBinStringArray.length; k++) {
            
            int convertedBin = Integer.parseInt(ipBinStringArray[k],2);
            System.out.println("****"+convertedBin);
            if (convertedBin == ipDecNumArray[k]){
                same++;
                System.out.println(same);
            }
            
        }
            System.out.print("Case "+(i+1)+": ");
        if (same==4){
            System.out.println("Yes");
        }else
            System.out.println("No");
        }
    }

}
