import java.io.*;
import java.util.*;

public class Solution {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int t,n,ans;
	static int[][] map,exit;
	static List<int[]> l;
	static int[] select_exit;
	
	public static void main(String[] args) throws Exception {
		t = Integer.parseInt(br.readLine());
		for(int tc=1 ; tc<=t; tc++) {
			ans = Integer.MAX_VALUE;
			n = Integer.parseInt(br.readLine());
			l = new LinkedList<int[]>();
			
			int cnt=0;
			exit = new int[2][2];
			map = new int[n][n];
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] >= 2) {
						exit[cnt][0] = i;
						exit[cnt++][1] = j;
					} else if(map[i][j] == 1) {
						l.add(new int[] {i,j});
					}
				}
			}
			select_exit = new int[l.size()];
			solve(0);
			sb.append("#" + tc + " " + ans + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	public static void solve(int idx) {
		if(idx==l.size()) {
			calc();
			return;
		}
		select_exit[idx] = 1;
		solve(idx+1);
		select_exit[idx] = 0;
		solve(idx+1);
	}
	
	public static void calc() {
		int time=0;
		PriorityQueue<Integer> pq_1 = new PriorityQueue<Integer>();
		PriorityQueue<Integer> pq_2 = new PriorityQueue<Integer>();
		
		for(int i=0;i<select_exit.length;i++) {
			if(select_exit[i] == 0) pq_1.add(Math.abs(exit[0][0] - l.get(i)[0]) + Math.abs(exit[0][1] - l.get(i)[1]));
			else pq_2.add(Math.abs(exit[1][0] - l.get(i)[0]) + Math.abs(exit[1][1] - l.get(i)[1]));
		}
		PriorityQueue<Integer> pq_1_in = new PriorityQueue<Integer>();
		PriorityQueue<Integer> pq_2_in = new PriorityQueue<Integer>();
		while(true) {
			if(++time > ans) break;
			
			
			while(!pq_1_in.isEmpty()) {
				if(pq_1_in.peek() + map[exit[0][0]][exit[0][1]] <= time) {
					pq_1_in.poll();
				} else break;
			}
			
			while(!pq_2_in.isEmpty()) {
				if(pq_2_in.peek() + map[exit[1][0]][exit[1][1]] <= time) {
					pq_2_in.poll();
				} else break;
			}
			
			while(!pq_1.isEmpty() && pq_1_in.size() < 3 && pq_1.peek() < time) {
				pq_1.poll();
				pq_1_in.add(time);
			}
			
			while(!pq_2.isEmpty() && pq_2_in.size() < 3 && pq_2.peek() < time) {
				pq_2.poll();
				pq_2_in.add(time);
			}
			if(pq_1.isEmpty() && pq_2.isEmpty() && pq_1_in.isEmpty() && pq_2_in.isEmpty()) break;
		}
		ans = Math.min(ans, time);
	}
}