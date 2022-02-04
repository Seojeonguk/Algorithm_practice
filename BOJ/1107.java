import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int n,m,ans;
	static boolean[] btn;
	static Queue<data> q;
	
	public static void main(String[] args) throws Exception {
		n = Integer.valueOf(br.readLine());
		m = Integer.valueOf(br.readLine());
		
		ans = Math.abs(100-n);
		btn = new boolean[10];
		q = new LinkedList<data>();
		
		if(m!=0) {
			st = new StringTokenizer(br.readLine());
			
			for(int i=0;i<m;i++) 
				btn[Integer.valueOf(st.nextToken())] = true;
		}
		
		for(int i=0;i<10;i++)
			if(!btn[i])
				q.add(new data(i,1));
		
		while(!q.isEmpty()) {
			data outdata = q.poll();
			
			ans = Math.min(ans, outdata.cnt + Math.abs(n-outdata.now));
			
			for(int i=0;i<10;i++) {
				if(!btn[i] && outdata.now !=0 && outdata.now*10+i<n*2)
					q.add(new data(outdata.now*10+i,outdata.cnt+1));
			}
		}
		
		bw.write(String.valueOf(ans));
		bw.newLine();
		
		bw.flush();
		bw.close();
	}
}

class data {
	int now,cnt;
	public data(int now,int cnt) {
		this.now = now;
		this.cnt = cnt;
	}
}