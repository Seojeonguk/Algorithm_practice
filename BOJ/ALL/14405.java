import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static String s;
	static boolean chk = true;
	static int idx,s_size;

	public static void main(String[] args) throws Exception {
		s = br.readLine();
		s_size = s.length();
		
		while(idx<s_size) {
			if(s.charAt(idx)=='p') {
				if(idx+1 >= s_size || s.charAt(idx+1) != 'i') {
					chk = false;
					break;
				}
				idx+=2;
			} else if(s.charAt(idx)=='k') {
				if(idx+1>=s_size || s.charAt(idx+1) != 'a') {
					chk = false;
					break;
				}
				idx+=2;
			} else if(s.charAt(idx)=='c') {
				if(idx+2>=s_size || s.charAt(idx+1) != 'h' || s.charAt(idx+2) != 'u') {
					chk = false;
					break;
				}
				idx+=3;
			} else {
				chk = false;
				break;
			}
		}

		if(chk) sb.append("YES");
		else sb.append("NO");
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}