import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();

		int arr[]= {2,3,5,7,11};
		for(int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			
			System.out.print("#"+test_case+" ");
			
			for(int i=0;i<arr.length;i++) {
				int cnt=0;
				while(true) {
					if(n%arr[i]==0) {
						cnt++;
						n/=arr[i];
					}
					else break;
				}
				System.out.print(cnt + " ");
			}
			System.out.println();
		}
	}
}