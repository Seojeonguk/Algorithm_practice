import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int n,ans,oper,a,t;
	static List<int[]> l = new LinkedList<int[]>();

	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			oper = Integer.parseInt(st.nextToken());
			if(oper==0) {
				if(!l.isEmpty()) {
					l.get(l.size()-1)[1]--;
					if(l.get(l.size()-1)[1]==0) {
						ans += l.get(l.size()-1)[0];
						l.remove(l.size()-1);
					}
				}
			} else if(oper==1) {
				a = Integer.parseInt(st.nextToken());
				t = Integer.parseInt(st.nextToken());
				if(t==1) ans+=a;
				else 
					l.add(new int[] {a,t-1});
			}
		}
		
		sb.append(ans);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}