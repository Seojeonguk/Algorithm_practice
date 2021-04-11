import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int sum;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<6;i++)
			sum += Integer.parseInt(st.nextToken()) * 5;
		
		sb.append(sum);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}