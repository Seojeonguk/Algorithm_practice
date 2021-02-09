import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static String quit = "I quacked the code!";
	static String s;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(true) {
			s = br.readLine();
			if(s.charAt(s.length()-1)=='!') break;
			else if(s.charAt(s.length()-1)=='?') bw.write("Quack!");
			else bw.write("*Nod*");
			bw.newLine();
			
			bw.flush();
		}

		
		bw.close();
	}
}