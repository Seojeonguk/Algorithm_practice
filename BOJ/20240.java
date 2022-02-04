import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int s,a,b;
	static boolean find;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		s = Integer.valueOf(br.readLine());
		
		for(int i=0;i<40;i++) {
			if(i*i > s) break;
			for(int j=0;j<40;j++) {
				if(i*i + j*j> s) break;
				if(i*i+j*j==s) {
					a= i;
					b= j;
					find = true;
					break;
				}
			}
			if(find) break;
		}
		
		int c= 0,d=0;
		if(!find) bw.write("Impossible");
		else {
			bw.write(String.valueOf(c) + " " + String.valueOf(d) + "\n");
			c += b;
			d += a;
			bw.write(String.valueOf(c) + " " + String.valueOf(d) + "\n");
			c += a;
			d += -b;
			bw.write(String.valueOf(c) + " " + String.valueOf(d) + "\n");
			c += -b;
			d += -a;
			bw.write(String.valueOf(c) + " " + String.valueOf(d) + "\n");
		}

		bw.flush();
		bw.close();
	}
}