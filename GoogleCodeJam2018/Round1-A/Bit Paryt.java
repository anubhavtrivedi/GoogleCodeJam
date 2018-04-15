import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
// usual problems
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		int r,c;
		long b;

		String md, result;
		for (int i = 1; i <= t; i++) {
		    
		    //changes
			r = in.nextInt();
			b = in.nextLong();
			c = in.nextInt();
			int[][] cashier =new int[3][c];
			for(int j=0;j<c;j++) {
				cashier[0][j] = in.nextInt();
				cashier[1][j] = in.nextInt();
				cashier[2][j] = in.nextInt();
			}
			result = solver(r,b,c,cashier);
			
			
			
			System.out.println("Case #" + i + ": " + result);
		}
	}

	static String solver(int r, long b, int c, int [][] cashier) {
		long t=0,max=0,temp;
		for(int i=0;i<c;i++) {
			temp=cashier[0][i]*cashier[1][i]+cashier[2][i];
			if(temp>max)
				max=temp;
		}
		t=max;
		long sum=0;
		while(true) {
			sum=0;
			int[] capacity= new int[c];
			for(int i=0;i<c;i++) {
				capacity[i]=max(0,min(cashier[0][i],(int)(t-cashier[2][i])/cashier[1][i]));
			}
			sort(capacity,0,capacity.length-1);
			for(int i=0;i<r;i++) {
				sum+=capacity[i];
			}
			if(sum<b) {
				if((2*t-t)>10)
					t=t+t+(t/2);
				else
					break;
			}
			t=(long)t/2;
			
		}
	
		int sum1,sum2;
		for(long j=t;j<=2*(t+1);j++) {
			sum=0;sum1=0;sum2=0;
			int[] capacity= new int[c];
			//this t val
			for(int i=0;i<c;i++) {
				capacity[i]=max(0,min(cashier[0][i],(int)( j-cashier[2][i])/cashier[1][i]));
			}
			sort(capacity,0,capacity.length-1);
			for(int i=0;i<r;i++) {
				sum1+=capacity[i];
			}
			//prev t val
			for(int i=0;i<c;i++) {
				capacity[i]=max(0,min(cashier[0][i],(int)( (j-1)-cashier[2][i])/cashier[1][i]));
			}
			sort(capacity,0,capacity.length-1);
			for(int i=0;i<r;i++) {
				sum+=capacity[i];
			}
			//next j val
			for(int i=0;i<c;i++) {
				capacity[i]=max(0,min(cashier[0][i],(int)( j+1-cashier[2][i])/cashier[1][i]));
			}
			sort(capacity,0,capacity.length-1);
			for(int i=0;i<r;i++) {
				sum2+=capacity[i];
			}
			
			
			if(sum1>=b&&(sum<b&&sum2>=b))
				return ""+j;
				
				
		}
		return ""+0;

	}
	public static int max(int x,int y) {
	if(x<y)
		return y;
		return x;
	}
	public static int min(int x,int y) {
		if(x<y)
			return x;
			return y;
		}
	
	
	static void merge(int arr[], int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;

		int L[] = new int[n1];
		int R[] = new int[n2];

		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];

		int i = 0, j = 0;

		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] >= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	static void sort(int arr[], int l, int r) {
		if (l < r) {
			// Find the middle point
			int m = (l + r) / 2;

			// Sort first and second halves
			sort(arr, l, m);
			sort(arr, m + 1, r);

			// Merge the sorted halves
			merge(arr, l, m, r);
		}

	}

}
















