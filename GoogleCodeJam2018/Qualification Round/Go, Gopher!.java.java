import java.util.Scanner;

public class Solution {
	public static boolean solveSmall9(int a, Scanner input) {
		while (true) {
			System.out.println("3 3");
			int i, j;
			i = input.nextInt();
			j = input.nextInt();
			if (i == 0 && j == 0)
				return true;
			if (i == -1 && j == -1)
				return false;
		}
	}

	public static boolean solveSmall20(int a, Scanner input) {
		while (true) {
			int i, j;
			for (int k = 2; k < 5; k++) {
				for (int l = 2; l < 4; l++) {
					System.out.println(k + " " + l);
					i = input.nextInt();
					j = input.nextInt();
					if (i == 0 && j == 0)
						return true;
					if (i == -1 && j == -1)
						return false;
				}
			}

		}
	}
	public static boolean checkSquare(int[][] grid,int x,int y) {
		for(int i=x-1;i<=x+1;i++) {
			for(int j=y-1;j<=y+1;j++) {
				if(grid[i][j]==0)
					return false;
			}
			
		}
			
				
		return true;
	}
	public static boolean solveLarge(int a, Scanner input) {
		int k=3,l;
		l=(a/9)+1;
		l*=3;
		int i1,j1;
		// hit each center piece till all the around get dig
		int[][] grid = new int[1001][1001];
		for(int i=1;i<l;i+=2) {
			while(!checkSquare(grid,1,i)) {
				
			System.out.println(1 + " " + i);
			i1 = input.nextInt();
			j1 = input.nextInt();
			if (i1 == 0 && j1 == 0)
				return true;
			if (i1 == -1 && j1 == -1)
				return false;
			grid[i1][j1]=1;
			}
		}

		
		return false;
	}

	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		for (int ks = 1; ks <= T; ks++) {
			boolean done = false;
			int a = input.nextInt();
			if (a <= 9)
				done = solveSmall9(a, input);
			else if (a <= 20)
				done = solveSmall20(a, input);
			else
				done = solveLarge(a, input);
			if (!done)
				return;
		}
	}
}