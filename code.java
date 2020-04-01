/*package whatever //do not write package name here */
import java.io.*;
import java.lang.*;
import java.util.*;

  public class Solution {
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int  n= in.nextInt();
        for(int i=0; i<n; i++){
            int m=in.nextInt();
            int b= in.nextInt();
            int[] house=new int[m];
            for(int k=0;k<m;k++){
                house[k]=in.nextInt();
            }
            System.out.println("Case #"+(i+1)+": "+solve(house,b));
        }
        
    }
    
    public static int solve(int[] house, int b){
    Arrays.sort(house);
        int ans=0;
        for(int i: house){
            if(i<=b){
                ans++;
                b-=i;
            }
            if(b<0)
            break;
        }
        return ans;
    }
    
}