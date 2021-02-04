import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			
			int[][] arr = new int[n][n];
			for(int i=0;i<n;i++) {
				String str = sc.next();
				for(int j=0;j<n;j++)
					arr[i][j] = str.charAt(j)-'0';
			}
			
			int sum=0;
			
			for(int i=0,now=0;i<n;i++,now+=(i<=n/2?1:-1)) {
				for(int j=n/2-now;j<=n/2+now;j++) {
					sum+=arr[i][j];
				}
			}
			

			System.out.println("#" + test_case + " " + sum);
		}
	}
}