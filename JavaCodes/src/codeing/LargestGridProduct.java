package codeing;

import java.util.Scanner;

public class LargestGridProduct {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] grid = new int[20][20];
        int maxProduct=0;
        int prodHori=0,prodVerti=0,prodDiaDown=0,productDiaUp=0;
        for(int grid_i=0; grid_i < 20; grid_i++){
            for(int grid_j=0; grid_j < 20; grid_j++){
                grid[grid_i][grid_j] = in.nextInt();
                if (grid_i>=3)
                {
                	prodHori=grid[grid_i-3][grid_j] * grid[grid_i-2][grid_j] *grid[grid_i-1][grid_j]*grid[grid_i][grid_j];
                	maxProduct=(prodHori>maxProduct)?prodHori:maxProduct;
                	if (grid_j<=16)
                	{
                		productDiaUp=grid[grid_i-3][grid_j+3] * grid[grid_i-2][grid_j+2] *grid[grid_i-1][grid_j+1]*grid[grid_i][grid_j];
                    	maxProduct=(productDiaUp>maxProduct)?productDiaUp:maxProduct;
                	}
                }
                if (grid_j>=3)
                {
                	prodVerti=grid[grid_i][grid_j-3] * grid[grid_i][grid_j-2] *grid[grid_i][grid_j-1]*grid[grid_i][grid_j];
                	maxProduct=(prodVerti>maxProduct)?prodVerti:maxProduct;
                	
                	if (grid_i>=3)
                    {
                		prodDiaDown=grid[grid_i-3][grid_j-3] * grid[grid_i-2][grid_j-2] *grid[grid_i-1][grid_j-1]*grid[grid_i][grid_j];
                		maxProduct=(prodDiaDown>maxProduct)?prodDiaDown:maxProduct;
                    }
                }
            }
        }
        System.out.println(maxProduct);
    }
}
