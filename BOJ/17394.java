import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int t,n,a,b;
	static boolean[] chk = new boolean[1000002];
	static boolean[] sosu = new boolean[100003];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//st = new StringTokenizer(br.readLine());
		
		for(int i=2;i<100003;i++) {
			if(!sosu[i])
				for(int j=i+i;j<100003;j+=i) {
					sosu[j] = true;
				}
		}
		
		t = Integer.valueOf(br.readLine());
		
		for(int tc=0;tc<t;tc++) {
			
			st = new StringTokenizer(br.readLine());
			n = Integer.valueOf(st.nextToken());
			a = Integer.valueOf(st.nextToken());
			b = Integer.valueOf(st.nextToken());
			
			Arrays.fill(chk, false);
			
			chk[n] = true;
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(n);
			int ans=0;
			boolean r = false;
			
			while(!q.isEmpty()) {
				int size = q.size();
				for(int i=0;i<size;i++) {
					int outdata = q.poll();
					if(a<=outdata && outdata<=b) {
						if(!sosu[outdata]) {
							r = true;
							bw.write(String.valueOf(ans));
							bw.newLine();
							break;
						}
					}
					
					int indata = outdata/2;
					if(!chk[indata]) {
						chk[indata] = true;
						q.add(indata);
					}
					indata = outdata/3;
					if(!chk[indata]) {
						chk[indata] = true;
						q.add(indata);
					}
					indata = outdata+1;
					if(indata <= 1000000 && !chk[indata]) {
						chk[indata] = true;
						q.add(indata);
					}
					indata = outdata-1;
					if(indata >=1 && !chk[indata]) {
						chk[indata] = true;
						q.add(indata);
					}
				}
				
				ans++;
				if(r) break;
			}
			
			if(!r) bw.write("-1\n");
		}
		
		
		bw.flush();
		bw.close();
	}
}