import java.io.*;
import java.util.*;

class Solution {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int t;
	static int n,ans;
	static int[] arr;
	static boolean[] visit;
	static List<Point> l;
	static Point cor,home;
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		t = Integer.valueOf(br.readLine());
		//t = 10;

		for(int test_case = 1;test_case<=t;test_case++) {
			n = Integer.valueOf(br.readLine());
			
			ans=Integer.MAX_VALUE;
			l = new LinkedList<Point>();
			visit = new boolean[n];
			
			
			st = new StringTokenizer(br.readLine());
			cor = new Point(Integer.valueOf(st.nextToken()), Integer.valueOf(st.nextToken()));
			home = new Point(Integer.valueOf(st.nextToken()), Integer.valueOf(st.nextToken()));
			
			for(int i=0;i<n;i++) {
				int x = Integer.valueOf(st.nextToken());
				int y = Integer.valueOf(st.nextToken());
				l.add(new Point(x,y));
			}
			
			solve(cor,0,0);
			
			bw.write("#" + String.valueOf(test_case) + " " + String.valueOf(ans) + "\n");
		}

		bw.flush();
		bw.close();
	}
	
	public static void solve(Point prev,int cnt,int sum) {
		if(cnt==n) {
			sum += Math.abs(prev.x - home.x) + Math.abs(prev.y - home.y);
			ans = Math.min(sum, ans);
			return;
		}
		
		for(int i=0;i<n;i++) {
			if(!visit[i]) {
				visit[i] = true;
				solve(l.get(i),cnt+1,sum + Math.abs(prev.x-l.get(i).x) + Math.abs(prev.y - l.get(i).y));
				visit[i] = false;
			}
		}
	}
}

class Point{
	int x,y;
	public Point(int x,int y) {
		this.x = x;
		this.y = y;
	}
}