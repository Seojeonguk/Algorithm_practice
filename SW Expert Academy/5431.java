import java.io.*;
import java.util.*;

class Solution {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int t;
	static int n,k;
	static boolean[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// = new StringTokenizer(br.readLine());
		t = Integer.valueOf(br.readLine());

		for (int test_case = 1; test_case <= t; test_case++) {
			st = new StringTokenizer(br.readLine());
			
			n = Integer.valueOf(st.nextToken());
			k = Integer.valueOf(st.nextToken());
			
			arr = new boolean[n+1];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<k;i++) {
				arr[Integer.valueOf(st.nextToken())] = true;
			}
			
			System.out.printf("#%d ",test_case);
			
			for(int i=1;i<=n;i++) {
				if(!arr[i])
					System.out.printf("%d ",i);
			}
			System.out.println();
		}

		bw.flush();
		bw.close();
	}
}