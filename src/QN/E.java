package QN;

import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class E {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        int[] coins = {1, 5, 10, 25, 50};
        int amount = 0;
        int testCase = 0;
        
        do {
            System.out.print("enter test cases: ");
            testCase = s.nextInt();
        } while (testCase < 1 || testCase > 225);
        
        do {
            System.out.print("enter amount: ");
            amount = s.nextInt();
        } while (amount < 0 || amount > 7489);

        int[][] ways = new int[5][amount+1];
            
        for (int i = 0; i < coins.length; i++) {
            ways[i][0]= 1;
            
            for (int j = 1; j <= amount; j++) {
                
                if(i==0){
                    ways[i][j] = 1;     //first row = 1-cent
                }else if (coins[i] > j) {
                    ways[i][j] = ways[i-1][j];
                }else{
                    ways[i][j] = ways[i-1][j] + ways[i][j-coins[i]];
                }

            }
        }
        int[] lastRow = ways[ways.length -1];
        int lastItem = lastRow[lastRow.length-1];
        
        System.out.println("Number of ways: "+lastItem);
        
    }

}
