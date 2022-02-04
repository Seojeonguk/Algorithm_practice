import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int n;
	static String s;
	

	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());
		s = br.readLine();
		
		s = s.substring(s.length()-5);
		
		sb.append(s);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}