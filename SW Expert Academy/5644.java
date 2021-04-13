import java.io.*;
import java.util.*;

public class Solution {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static class AP {
		int x,y,c,p;
		public AP(int x,int y,int c,int p) {
			this.x = x;
			this.y = y;
			this.c = c;
			this.p = p;
		}
	}

	static int t,m,a,ax,ay,bx,by,ans;
	static int[] move_a,move_b;
	static int[] X= {0,-1,0,1,0},Y= {0,0,1,0,-1};
	static AP[] aplist;
	
	
	public static void main(String[] args) throws Exception {
		t = Integer.parseInt(br.readLine());
		for(int tc=1 ; tc<=t; tc++) {
			ans=ax=ay=0;
			bx=by=9;
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			move_a = new int[m];
			move_b = new int[m];
			aplist = new AP[a];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<m;i++) 
				move_a[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<m;i++)
				move_b[i] = Integer.parseInt(st.nextToken());
			
			for(int i=0;i<a;i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				
				aplist[i] = new AP(y-1,x-1,c,p);
			}
			
			for(int i=0;i<=m;i++) {
				int max=0;
				for(int ap_i = 0;ap_i<a;ap_i++) {
					for(int bp_i=0;bp_i<a;bp_i++) {
						int ap_sum=0;
						int bp_sum=0;
						if(Math.abs(ax-aplist[ap_i].x) + Math.abs(ay-aplist[ap_i].y) <= aplist[ap_i].c) {
							ap_sum = aplist[ap_i].p;
						}
						
						if(Math.abs(bx-aplist[bp_i].x) + Math.abs(by-aplist[bp_i].y) <= aplist[bp_i].c) {
							bp_sum = aplist[bp_i].p;
						}
						int sum=0;
						if(ap_i == bp_i && ap_sum==bp_sum) {
							sum = ap_sum;
						} else {
							sum = ap_sum + bp_sum;
						}
						max = Math.max(max, sum);
					}
				}
				
				ans += max;
				
				// 계산값 확인
				if(i==m) continue;
				ax += X[move_a[i]];
				ay += Y[move_a[i]];
				bx += X[move_b[i]];
				by += Y[move_b[i]];
			}
			
			bw.write("#" + String.valueOf(tc) + " " + String.valueOf(ans) + "\n");
		}
		bw.flush();
		bw.close();
	}
}