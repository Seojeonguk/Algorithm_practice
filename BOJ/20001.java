import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static String str;
	static int n;


	public static void main(String[] args) throws Exception {
		while(true) {
			str = br.readLine();
			int length = str.length();
			if(length==10) break;
			if(length==2) n++;
			else if(length==4) {
				if(n==0) n+=2;
				else n--;
			}
		}
		if(n==0) sb.append("고무오리야 사랑해");
		else sb.append("힝구");
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}