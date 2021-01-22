import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution {
	public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
 
        for(int test_case = 1; test_case <= T; test_case++) {
        	int l = sc.nextInt();
        	int u = sc.nextInt();
        	int x = sc.nextInt();
        	
        	int ans = 0;
        	if(x < l) ans = l-x;
        	else if(u<x) ans = -1;
        	
        	System.out.printf("#%d %d\n",test_case,ans);
        }
        sc.close();
    }
}