import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int t;
	static char[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		t = Integer.valueOf(br.readLine());
		
		for(int i=0;i<t;i++) {
			arr = br.readLine().toCharArray();
			int a = (arr[0]-'0') * 10 + (arr[1]-'0');
			int b = (arr[2]-'0') * 10 + (arr[3]-'0');
			bw.write((a*a+b*b)%7==1?"YES":"NO");
			bw.newLine();
		}

		bw.flush();
		bw.close();
	}
}