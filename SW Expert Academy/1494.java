import java.io.*;
import java.util.*;

class Solution {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int t;
	static int n;
	static int[][] xy;
	static boolean[] visit;
	static long ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		t = Integer.valueOf(br.readLine());
		for(int test_case=1 ;test_case<=t;test_case++) {
			n = Integer.valueOf(br.readLine());
			
			xy = new int[n][2];
			visit = new boolean[n];
			ans = Long.MAX_VALUE;
			
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				xy[i][0] = Integer.valueOf(st.nextToken());
				xy[i][1] = Integer.valueOf(st.nextToken());
			}
			solve(0,0);
			
			System.out.printf("#%d %d\n",test_case,ans);
		}

		bw.flush();
		bw.close();
	}
	
	public static void solve(int idx,int cnt) {
		if(cnt==n/2) {
			long x=0,y=0;
			for(int i=0;i<n;i++) {
				if(visit[i]) {
					x+=xy[i][0];
					y+=xy[i][1];
				}
				else {
					x-=xy[i][0];
					y-=xy[i][1];
				}
			}
			long tmp = x*x+y*y;
			ans = Math.min(ans, tmp);
		}
		
		for(int i=idx;i<n;i++) {
			if(!visit[i]) {
				visit[i] = true;
				solve(i,cnt+1);
				visit[i] = false;
			}
		}
	}
}