import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static long a,b,r,l,total;

	public static void main(String[] args) throws Exception {
		while(true) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			if(a==0 && b==0) break;
			
			l=0;
			total = r = cal_total(a);
			
			while(l<r) {
				long mid = (l+r)/2;
				long ne = total-mid;
				
				long chk_sum = sum(mid);
				long chk_sum2 = sum(ne);
				
				if(Math.abs(chk_sum-chk_sum2) == b) {
					sb.append(Math.min(chk_sum, chk_sum2)).append("\n");
					break;
				}
				
				if(Math.abs(chk_sum-chk_sum2) > b) {
					r = mid;
				} else l = mid+1;
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static long cal_total(long cost) {
		if (cost > 4979900)
	        return (cost + 2020100)/7;
	    else if (cost > 29900)
	        return (cost + 20100)/5;
	    else if (cost > 200)
	        return (cost + 100)/3;
	    else
	        return cost/2;
	}
	
	public static long sum(long cost) {
		if (cost > 1000000)
			return cost*7 - 2020100;
		else if (cost > 10000)
			return cost*5 - 20100;
		else if (cost > 100)
			return cost*3 - 100;
		else
			return cost*2;
	}
}