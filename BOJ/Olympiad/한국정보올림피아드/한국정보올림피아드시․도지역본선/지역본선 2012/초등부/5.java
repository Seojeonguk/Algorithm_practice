import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int k;
	static char[] c;
	static boolean[] use;
	static List<Long> l = new LinkedList<Long>();

	public static void main(String[] args) throws Exception {
		k = Integer.parseInt(br.readLine());
		String temp = br.readLine();
		c = new char[k];
		for(int i=0,j=0;i<temp.length();i+=2)
			c[j++] = temp.charAt(i);
			
		use = new boolean[10];

		for(int i=0;i<10;i++) {
			use[i] = true;
			solve(0,i,i);
			use[i] = false;
		}
		
		Collections.sort(l);
		
		String max = l.get(l.size()-1).toString();
		String min = l.get(0).toString();
		min = min.length() != k+1 ? "0"+min : min;
		System.out.println(max);
		System.out.println(min);
		
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void solve(int idx, int last,long sum) {
		if(idx==k) {
			l.add(sum);
			return;
		}
		if(c[idx] == '<') {
			for(int i=last+1;i<10;i++) {
				if(!use[i]) {
					use[i] = true;
					solve(idx+1,i,sum*10+i);
					use[i] = false;
				}
			}
		} else {
			for(int i=last-1;i>=0;i--) {
				if(!use[i]) {
					use[i] = true;
					solve(idx+1,i,sum*10+i);
					use[i] = false;
				}
			}
		}
	}
}