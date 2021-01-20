import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();

		int arr[]= {2,3,5,7,11};
		for(int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			
			int meter=0,v=0;
			for(int i=0;i<n;i++) {
				int s = sc.nextInt();
				
				if(s!=0) {
					int gs = sc.nextInt();
					v += gs * (s==1?1:-1);
					if(v<0) v=0;
				}
				
				meter += v;
			}
			
			System.out.println("#"+test_case+" " + meter);
		}
	}
}