import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	
	static class soldier implements Comparable<soldier> {
		int str,dex,luk;
		
		public soldier(int str,int dex,int luk) {
			this.str = str;
			this.dex = dex;
			this.luk = luk;
		}
		
		@Override
		public int compareTo(soldier o) {
			return this.luk - o.luk;
		}
	}
	
	static int n,k,ans=Integer.MAX_VALUE;
	static soldier[] l;
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		l = new soldier[n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			l[i] = new soldier(Integer.parseInt(st.nextToken()) , Integer.parseInt(st.nextToken()) , Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(l);
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				int cnt=0;
				for(int m=0;m<n;m++) {
					if(l[m].str <= l[i].str && l[m].dex <= l[j].dex) cnt++;
					if(cnt==k) {
						ans = Math.min(ans, l[i].str + l[j].dex + l[m].luk);
						break;
					}
				}
			}
		}
		
		
		System.out.println(ans);
	}
	
}