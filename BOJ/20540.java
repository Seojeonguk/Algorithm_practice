import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static char[] c;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		c = br.readLine().toCharArray();
		
		for(int i=0;i<c.length;i++) {
			if(c[i] == 'E') bw.write('I');
			else if(c[i] == 'I') bw.write('E');
			
			else if(c[i] == 'S') bw.write('N');
			else if(c[i] == 'N') bw.write('S');
			
			else if(c[i] == 'T') bw.write('F');
			else if(c[i] == 'F') bw.write('T');
			
			else if(c[i] == 'J') bw.write('P');
			else if(c[i] == 'P') bw.write('J');
		}

		bw.flush();
		bw.close();
	}
}