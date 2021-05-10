import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static String ipv6;
	static String[] s;
	static int s_size,idx;
	

	public static void main(String[] args) throws Exception {
		ipv6 = br.readLine();
		
		s = ipv6.split(":");
		s_size = s.length;
		
		for(int i=0;i<s_size;i++)
			if(s[i].equals(""))
				idx++;
		
		for(int i=0;i<s_size;i++) {
			int item_size = s[i].length();
			if(s[i].equals("")) {
				for(int j=0;j<8-s_size+idx;j++) {
					sb.append("0000:");
				}
				if(s[i+1].equals(""))
					i+=idx-1;
			} else {
				for(int j=0;j<4-item_size;j++)
					sb.append("0");
				sb.append(s[i]);
				if(i!=s_size-1)sb.append(":");
			}
		}
		
		if(ipv6.charAt(ipv6.length()-1)==':') {
			sb.append(":0000");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}