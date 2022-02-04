import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static char[] arr;
	static Deque<Character> dq = new ArrayDeque<Character>();

	public static void main(String[] args) throws Exception {
		arr = br.readLine().toCharArray();
		
		boolean opener = false;
		for(char item : arr) {
			if(item=='<') {
				while(!dq.isEmpty()) sb.append(dq.pollLast());
				sb.append(item);
				opener = true;
			} else if(item=='>') {
				sb.append(item);
				opener = false;
			} else if(opener) {
				sb.append(item);
			} else {
				if(item==' ') {
					while(!dq.isEmpty()) {
						sb.append(dq.pollLast());
					}
					sb.append(item);
				} else {
					dq.add(item);
				}
			}
		}
		while(!dq.isEmpty()) 
			sb.append(dq.pollLast());
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}