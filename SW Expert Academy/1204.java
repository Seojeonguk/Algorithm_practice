import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
 
        for (int test_case = 1; test_case <= T; test_case++) {
        	int n = sc.nextInt();
        	
        	int[]cnt = new int[101];
        	
        	int now=0;
        	
        	for(int i=0;i<1000;i++) {
        		int x = sc.nextInt();
        		cnt[x]++;
        		
        		if(cnt[now] < cnt[x]) now = x;
        		else if(cnt[now] == cnt[x]) now = Math.max(now, x);
        		
        	}
        	
        	System.out.println("#" + test_case + " " + now);
        }
         
        sc.close();
    }
}