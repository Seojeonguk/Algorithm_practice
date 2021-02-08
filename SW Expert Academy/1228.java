import java.io.*;
import java.util.*;

class Solution {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int t,n,k,x,y;
	static int[] arr;
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		t = 10;

		for(int test_case = 1;test_case<=t;test_case++) {
			arr = new int[10];
			n = Integer.valueOf(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) {
				int x = Integer.valueOf(st.nextToken());
				if(i<10) arr[i] = x;
			}
			k = Integer.valueOf(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<k;i++) {
				st.nextToken();
				
				x = Integer.valueOf(st.nextToken());
				y = Integer.valueOf(st.nextToken());
				
				for(int j=0;j<y;j++) {
					int s = Integer.valueOf(st.nextToken());
					if(x+j<10) {
						for(int k=9;k>x+j;k--) {
							arr[k] = arr[k-1];
						}
						arr[x+j] = s;
					}
				}
			}
			
			bw.write("#" + String.valueOf(test_case) + " ");
			for(int i=0;i<10;i++) 
				bw.write(String.valueOf(arr[i]) + " ");
			bw.newLine();
		}

		bw.flush();
		bw.close();
	}
}