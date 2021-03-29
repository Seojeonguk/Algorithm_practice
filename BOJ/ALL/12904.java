import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static String s,t;
	static boolean chk;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		s = br.readLine();
		t = br.readLine();
		
		while(t.length()!= s.length()) {
			chk = t.charAt(t.length()-1) == 'A' ? true : false;
			t = t.substring(0,t.length()-1);
			if(!chk) {
				sb = new StringBuilder(t);
				t = sb.reverse().toString();
			}
		}
		
		if(t.equals(s)) System.out.println("1");
		else System.out.println("0");
	}
}