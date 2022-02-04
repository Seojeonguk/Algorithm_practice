import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int n,m,k;
	static long[] arr,tree;
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		k = Integer.valueOf(st.nextToken());
		
		arr = new long[n+1];
		tree = new long[n+1];
		
		for(int i=1;i<=n;i++) {
			arr[i] = Long.valueOf(br.readLine());
			update(i,arr[i]);
		}
		
		m+=k;
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			long c= Long.valueOf(st.nextToken());
			
			if(a==1) {
				long diff = c-arr[b];
				arr[b] = c;
				update(b,diff);
			}
			else {
				bw.write(String.valueOf(query((int)c) - query(b-1)));
				bw.newLine();
			}
		}
					
		
		bw.flush();
		bw.close();
	}
	
	public static void update(int idx,long diff) {
		while(idx<tree.length) {
			tree[idx] += diff;
			idx += (idx&-idx);
		}
	}
	
	public static long query(int idx) {
		long ret = 0;
		while(idx>0) {
			ret += tree[idx];
			idx -= (idx&-idx);
		}
		return ret;
	}
}