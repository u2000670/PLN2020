package com.company.PLNPastYears;

import java.util.Scanner;

//solution from GeeksForGeeks : https://www.geeksforgeeks.org/maximum-sum-path-in-a-matrix/
public class H_PacMan {

    public static int maxSum(int[][] nums, int i, int j){
        int[][] visited = new int[nums.length][nums[0].length];
        int[][] dp = new int[nums.length][nums[0].length];
        int rows = nums.length;
        int cols = nums[0].length;

        if(i == rows -1 && j == cols -1)
            return nums[i][j];
        if(visited[i][j] != 0)
            return dp[i][j];

        visited[i][j]= 1;
        int totalSum = 0;

        if( i< rows -1 && j < cols -1){
            int currSum = Math.max(maxSum(nums, i, j+1), maxSum(nums, i+1, j) );
            totalSum = nums[i][j] + currSum;
        } else if( i==rows-1)
            totalSum = nums[i][j] + maxSum(nums, i,j+1);
        else
            totalSum = nums[i][j] + maxSum(nums, i+1,j);

        dp[i][j] = totalSum;
        return totalSum;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] nums = new int[n][m];
            for (int j = 0; j < nums.length; j++) {
                for (int k = 0; k < nums[j].length; k++) {
                    nums[j][k] = sc.nextInt();
                }
            }


            System.out.println(maxSum(nums,0,0));
        }
    }


}
