import java.io.*;
import java.util.*;

public class Solution {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int t,n,m,k,ans;
	static int[][] map,copymap;
	
	public static void main(String[] args) throws Exception {
		t = Integer.parseInt(br.readLine());
		for(int tc=1 ; tc<=t; tc++) {
			ans = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			map = new int[n][m];
			copymap = new int[n][m];
			
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<m;j++)
					map[i][j] = copymap[i][j] = Integer.parseInt(st.nextToken());
			}
			
			if(chk()) ans=0;
			else solve(0,0);
			
			sb.append("#" + tc + " " + ans + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	public static void solve(int idx,int cnt) {
		if(cnt>=ans) return;
		if(idx == n) {
			if(chk())
				ans = Math.min(ans,cnt);
			return;
		}
		
		solve(idx+1,cnt);
		
		Arrays.fill(copymap[idx], 0);
		solve(idx+1,cnt+1);
		
		Arrays.fill(copymap[idx], 1);
		solve(idx+1,cnt+1);
		
		for(int j=0;j<m;j++)
			copymap[idx][j] = map[idx][j];
	}
	
	public static boolean chk() {
		boolean flag = true;

        loop:for(int j=0; j<m; j++) {
            int cnt = 1;
            for(int i=1; i<n; i++) {
                if(cnt==k) continue loop;
                if(copymap[i][j]==copymap[i-1][j]) cnt++;
                else cnt=1;
            }
            if(cnt<k) {
            	flag=false;
            	break;
            }
        }
        return flag;
	}
}