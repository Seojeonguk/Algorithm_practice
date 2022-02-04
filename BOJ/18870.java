import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int n,idx;
	static Set<Integer> s = new HashSet<Integer>();
	static int[] arr,brr;

	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		arr = new int[n];
		brr = new int[n];
		
		for(int i=0;i<n;i++) {
			brr[i] = Integer.parseInt(st.nextToken());
			if(!s.contains(brr[i])) {
				s.add(brr[i]);
				arr[idx++]=brr[i];
			}
		}
		Arrays.sort(arr, 0, idx);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) 
			sb.append(Arrays.binarySearch(arr, 0, idx, brr[i])).append(' ');
		System.out.println(sb.toString());
	}
}