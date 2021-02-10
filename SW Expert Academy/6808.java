import java.io.*;
import java.util.*;

class Solution {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int t;
	static boolean[] choice;
	static int[] arr,brr;
	static int win,lose;
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		t = Integer.valueOf(br.readLine());
		//t = 10;

		for(int test_case = 1;test_case<=t;test_case++) {
			win = lose = 0;
			st = new StringTokenizer(br.readLine());
			
			choice = new boolean[19];
			arr = new int[9];
			brr = new int[9];
			
			for(int i=0;i<9;i++) {
				int x = Integer.valueOf(st.nextToken());
				choice[x] = true;
				arr[i] = x;
			}
			
			solve(0);
			
			bw.write("#" + String.valueOf(test_case) + " " + String.valueOf(lose) + " " + String.valueOf(win) + "\n");
		}

		bw.flush();
		bw.close();
	}
	
	public static void solve(int cnt) {
		if(cnt==9) {
			int sum_k=0, sum_i=0;
			for(int i=0;i<9;i++) {
				if(arr[i] > brr[i]) sum_k += arr[i]+brr[i];
				else if(arr[i] < brr[i]) sum_i += arr[i]+brr[i];
			}
			if(sum_k > sum_i) lose++;
			else if(sum_k < sum_i) win++;
			return;
		}
		for(int i=1;i<=18;i++) {
			if(!choice[i]) {
				choice[i] = true;
				brr[cnt] = i;
				solve(cnt+1);
				choice[i] = false;
			}
		}
	}
}