import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int zero,one;
	static char c;
	static String s;
	
	public static void main(String[] args) throws Exception {
		s = br.readLine();
		
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)!=c) {
				c = s.charAt(i);
				if(c=='0') zero++;
				else one++;
			}
		}


		bw.write(String.valueOf(Math.min(zero, one)));
		
		bw.flush();
		bw.close();
	}
}