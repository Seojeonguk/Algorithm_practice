import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int a,b,ans,size;
	static Set<Integer> as,bs;
	static int arr[],brr[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		a = Integer.valueOf(st.nextToken());
		b = Integer.valueOf(st.nextToken());
		as = new HashSet<Integer>();
		bs = new HashSet<Integer>();
		arr = new int[a];
		brr = new int[b];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<a;i++) {
			arr[i] = Integer.valueOf(st.nextToken());
			as.add(arr[i]);
		}
		
		size = a;
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<b;i++) {
			brr[i] = Integer.valueOf(st.nextToken());
			bs.add(brr[i]);
			as.add(brr[i]);
			if(as.size()!=size) {
				ans++;
				size = as.size();
			}
		}
		
		size = b;
		for(int i=0;i<a;i++) {
			bs.add(arr[i]);
			if(bs.size()!=size) {
				ans++;
				size = bs.size();
			}
		}
		
		bw.write(String.valueOf(ans));
		
		bw.flush();
		bw.close();
	}
}