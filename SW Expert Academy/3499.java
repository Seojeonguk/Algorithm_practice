import java.io.*;
import java.util.*;

class Solution {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int t,n;
	static String[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		t = Integer.valueOf(br.readLine());
		for(int test_case=1 ;test_case<=t;test_case++) {
			n = Integer.valueOf(br.readLine());
			
			arr = new String[n]; 
			st= new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) 
				arr[i] = st.nextToken();
			
			System.out.printf("#%d ",test_case);
			for(int i=0;i<n/2;i++) {
				System.out.print(arr[i] + " " +arr[i+n/2 + (n%2==0?0:1)] + " ");
			}
			if(n%2==1) {
				System.out.print(arr[n/2]);
			}
			System.out.println();
		}

		bw.flush();
		bw.close();
	}
}