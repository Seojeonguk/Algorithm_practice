import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int n;
	static HashSet<Integer> s = new HashSet<Integer>();
	static int[] a = {1,5,10,50};
	static boolean[][] visit;
	
	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());
		
		visit = new boolean[n+1][(n+1)*50];
		
		solve(0,0);
		
		System.out.println(s.size());
	}
	
	public static void solve(int cnt,int sum) {
		if(cnt==n) {
			s.add(sum);
			return;
		}
		
		for(int i=0;i<4;i++) {
			if(!visit[cnt+1][sum+a[i]]) {
				visit[cnt+1][sum+a[i]]= true;
				solve(cnt+1,sum+a[i]);
			}
		}
	}
}