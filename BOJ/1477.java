import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int n,m,l;
	static int[] d;
	static PriorityQueue<data> q = new PriorityQueue<data>();
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		l = Integer.valueOf(st.nextToken());
		
		d = new int[n+2];
		
		
		
		st = new StringTokenizer(br.readLine());
		d[n+1]=l;
		for(int i=1;i<=n;i++) 
			d[i] = Integer.valueOf(st.nextToken());
		
		Arrays.sort(d,0,n+1);
		
		for(int i=0;i<=n;i++) {
			int f = Math.abs(d[i]-d[i+1]);
			q.add(new data(f,f,1));
		}
			
		
		while(m-- !=0) {
			data outdata = q.poll();
			
			int nf = outdata.f;
			int nsf = outdata.sf;
			int nss = outdata.ss+1;
			
			nf = (nsf+nss-1)/nss;
			
			q.add(new data(nf,nsf,nss));
		}
		
		bw.write(String.valueOf(q.poll().f));
		bw.newLine();
		
		bw.flush();
		bw.close();
	}
}

class data implements Comparable<data> {
	int f,sf,ss;
	public data(int f, int sf, int ss) {
		this.f = f;
		this.sf = sf;
		this.ss = ss;
	} 
	@Override
	public int compareTo(data o) {
		return o.f-this.f;
	}
}