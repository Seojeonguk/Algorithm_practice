import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int n,k,tmp;
	static char[] str;
	static ArrayDeque<Character> s;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		k = Integer.valueOf(st.nextToken());
		tmp = k;

		str = br.readLine().toCharArray();

		s = new ArrayDeque<Character>();
		for(int i=0;i<n;i++) {
			while(k!=0 && !s.isEmpty() && s.peekLast() < str[i]) {
				s.pollLast();
				k--;
			}
			s.addLast(str[i]);
		}
		for(int i=0;i<n-tmp;i++) {
			bw.write(s.poll());
		}

		bw.flush();
		bw.close();
	}
}