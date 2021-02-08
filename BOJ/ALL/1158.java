import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int n,k;
	static List<Integer> l;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		l = new LinkedList<Integer>();
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.valueOf(st.nextToken());
		k = Integer.valueOf(st.nextToken());
		
		bw.write('<');
		
		for(int i=1;i<=n;i++) l.add(i);
		
		int cnt=0;
		while(true) {
			cnt = (cnt+k-1)%l.size();
			bw.write(String.valueOf(l.remove(cnt)));
			if(l.isEmpty()) break;
			else bw.write(", ");
		}
		
		bw.write('>');

		bw.flush();
		bw.close();
	}
}