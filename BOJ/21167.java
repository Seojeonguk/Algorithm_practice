import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			double R = sc.nextDouble();
			double S = sc.nextDouble();
			double V = Math.sqrt(R * (S + 0.16) / 0.067);
			long ans = Math.round(V);
			System.out.println(ans);
		}

		bw.flush();
		bw.close();
	}
}