import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int n, m, map[][], ans=Integer.MAX_VALUE;
	static int[] X = {-1, 0, 1, 0}, Y = {0, 1, 0, -1};
	static String[] type = {"", "0", "02", "01", "013", "0123"};
	static ArrayList<int[]> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]>0 && map[i][j]<6) 
					list.add(new int[] {i, j});
			}
		}
		
		int[][] tmp = map;
		dfs(0, -1, tmp);
		
		sb.append(ans);
		bw.write(sb.toString());
		bw.flush();
	}
	
	private static void dfs(int idx, int num, int[][] tmp) {
		if(idx==list.size()) {
			int cnt = 0;
			for (int i = 0; i < tmp.length; i++)
				for (int j = 0; j < tmp[0].length; j++)
					if(tmp[i][j]==0) 
						cnt++;
			
			ans = Math.min(ans, cnt);
			return;
		}
				
		int[] curr = list.get(idx);
		for (int i = 0; i < 4; i++) {
			solve(curr, tmp, i, 0, num);
			dfs(idx+1, num-1, tmp);
			solve(curr, tmp, i, num, 0);
		}
	}
	
	private static void solve(int[] curr, int[][] tmp, int dir, int findnum, int value) {
		String t = type[map[curr[0]][curr[1]]];
		for (int i = 0; i < t.length(); i++) {
			int nd = (t.charAt(i) - '0' + dir)%4;
			int nx = curr[0] + X[nd];
			int ny = curr[1] + Y[nd];
			while(isin(nx, ny)) {
				if(map[nx][ny]==6) break;
				if(map[nx][ny]==findnum) tmp[nx][ny] = value;
				nx += X[nd];
				ny += Y[nd];
			}
		}
	}

	public static boolean isin(int x, int y) {
		if(x<0 || y<0 || x>n-1 || y>m-1) return false;
		return true;
	}
} 