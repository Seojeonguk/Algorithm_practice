import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int j_money,j_cnt,s_money,s_cnt;
	static int[] stock;

	public static void main(String[] args) throws Exception {
		stock = new int[14];
		j_money = s_money = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<14;i++) {
			stock[i] = Integer.parseInt(st.nextToken());

			j_cnt += j_money / stock[i];
			j_money %= stock[i];

			if(i<3) continue;
			if(stock[i-3] < stock[i-2] && stock[i-2] < stock[i-1] && stock[i-1] < stock[i]) {
				s_money += s_cnt * stock[i];
				s_cnt=0;
			} else if(stock[i-3] > stock[i-2] && stock[i-2] > stock[i-1] && stock[i-1] > stock[i]) {
				s_cnt += s_money/stock[i];
				s_money %= stock[i];
			}
		}

		int j_value = j_money + stock[13] * j_cnt;
		int s_value = s_money + stock[13] * s_cnt;
		if(j_value < s_value) sb.append("TIMING");
		else if(j_value > s_value) sb.append("BNP");
		else sb.append("SAMESAME");
		bw.write(sb.toString());
		bw.flush();
	}
} 