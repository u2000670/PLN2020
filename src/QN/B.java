package QN;

import java.util.Random;
import java.util.Scanner;

public class B {

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
