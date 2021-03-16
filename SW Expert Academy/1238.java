import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static Scanner sc = new Scanner(System.in);

	static boolean[][] arr;
	static boolean[] visit;
	static int input_length, start_idx,from,to,ans,ans_cnt,tc_idx;
	static Queue<data> q;
	
	public static void main(String[] args) {
		while(sc.hasNextInt()) {
			input_length = sc.nextInt();
			start_idx = sc.nextInt();
			
			ans_cnt=-1;
			arr = new boolean[102][102];
			q = new LinkedList<data>();
			visit = new boolean[102];
			
			for(int i=0;i<input_length/2;i++) {
				from = sc.nextInt();
				to = sc.nextInt();
				arr[from][to] = true;
			}
			
			q.add(new data(start_idx,0));
			visit[start_idx] = true;
			ans = start_idx;
			
			while(!q.isEmpty()) {
				data outdata = q.poll();
				
				if(outdata.cnt > ans_cnt) {
					ans_cnt = outdata.cnt;
					ans = outdata.idx;
				} else if(outdata.cnt == ans_cnt) {
					ans = Math.max(ans, outdata.idx);
				}
				
				for(int i=1;i<=100;i++) {
					if(arr[outdata.idx][i] && !visit[i]) {
						visit[i] = true;
						q.add(new data(i,outdata.cnt+1));
					}
				}
			}
			
			System.out.printf("#%d %d\n",++tc_idx,ans);
		}
	}
}

class data {
	int idx,cnt;
	public data(int idx,int cnt) {
		this.idx = idx;
		this.cnt = cnt;
	}
}
