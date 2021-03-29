import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int n,x,ans,tmp1,tmp2;
	static PriorityQueue<Integer> l,r;
	
	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());
		l = new PriorityQueue<Integer>();
		r = new PriorityQueue<Integer>();
		for(int i=0;i<n;i++) {
			x = Integer.parseInt(br.readLine());
			if(x==1) ans++;
			else if(x<=0) l.add(x);
			else r.add(-x);
		}
		
	
		while(!l.isEmpty()) {
			tmp1 = l.poll();
			tmp2 = l.isEmpty() ? 1 : l.poll();
			ans += tmp1 * tmp2;
		}
		
		while(!r.isEmpty()) {
			tmp1 = -r.poll();
			tmp2 = r.isEmpty() ? 1 : -r.poll();
			ans += tmp1 * tmp2;
		}
		System.out.println(ans);
	}
}