import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			
			String[] ch = new String[n];
			int[] in = new int[n];
			
			for(int i=0;i<n;i++) {
				ch[i] = sc.next();
				in[i] = sc.nextInt();
			}
			
			int now=0;
			
			System.out.println("#" + test_case);
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<in[i];j++) {
					System.out.print(ch[i]);
					now++;
					if(now%10==0) {
						System.out.println();
					}
				}
			}
			if(now%10!=0)
				System.out.println();
		}
	}
}