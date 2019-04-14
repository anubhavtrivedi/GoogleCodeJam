import java.io.*;
import java.lang.*;
import java.util.*;

    public class Node{
        Node[] child=new Node[26];
        int[] unpaired=new int[26];
        char ch;
        
        public Node(char c){
            ch=c;
        }
        
        public void insert(Node node,char[] c,int ind){
            int index=65-(int)c[ind];
            if(child[index]==null){
                child[index]=new Node(c[ind]);
            }
            insert(child[index])a
            
        }
        
        public void assignVal(Node node){
            
        }
        
        public int solution(Node node){
            
        }
            
    }

    public class Solution {
    public static Node root=new Node();
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n=in.nextInt();
        int ans,x;
        for(int i=0;i<n;){
            x=in.nextInt();
            String[] input=new String[x];
            for(int j=0;j<x;j++){
                input[j]=in.next();
            }
          ans=0;
          ans=solve(input,x);
          
           i++;
           System.out.println("Case #"+i+": ");
           

        }
    }
    
    public static int solve(String[] str,int x){
        int ans=0;
        for(int i=0;i<x;i++){
        Char[] c=str[i].toCharArray();
        root.insert(c,0);
        }
        
        root.assignVal(root);
        
        ans=root.soluution();        
    return ans;
    }
    
    
}















