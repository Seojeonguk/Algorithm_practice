import java.io.*;
import java.util.*;

public class Solution {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int t,n,x,ans;
	static int[][] map;
	static int[] tmp,tmp2;
	
	
	public static void main(String[] args) throws Exception {
		t = Integer.parseInt(br.readLine());
		for(int tc=1 ; tc<=t; tc++) {
			ans=0;
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			
			tmp = new int[n];
			tmp2 = new int[n];
			map = new int[n][n];
			
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					tmp[j] = map[i][j];
					tmp2[j] = map[j][i];
				}
				if(solve(tmp)) ans++;
				if(solve(tmp2)) ans++;
			}
			
			bw.write("#" + String.valueOf(tc) + " " + String.valueOf(ans) + "\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static boolean solve(int[] line) {
		boolean[] visit = new boolean[n];
		int equal_high_cnt=0;
		int now_high = line[0];
		
		for(int i=0;i<n;i++) {
			if(now_high == line[i]) {
				equal_high_cnt++;
				continue;
			}
			
			if(Math.abs(now_high - line[i]) >=2) return false;
			else if(now_high - line[i] == 1) {
				for(int j=0;j<x;j++) {
					if(i+j > n-1 || now_high-1 != line[i+j] || visit[i+j]) return false;
					visit[i+j] = true;
				}
				i = i+x-1;
				now_high = line[i];
			} else if(now_high - line[i] == -1) {
				
				for(int j=1;j<=x;j++) {
					if(i-j <0 || now_high != line[i-j] || visit[i-j]) return false;
					visit[i-j] = true;
				}
				now_high = line[i];
			}
		}
		
		return true;
	}
}