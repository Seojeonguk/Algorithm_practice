import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;
 
class Solution {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int tc,n,m,a,ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer st;
		tc = 10;
		
        for (int test_case = 1; test_case <= tc; test_case++) {
        	bw.write("#" + String.valueOf(test_case) + " ");
        	
        	st = new StringTokenizer(br.readLine());
        	a = Integer.valueOf(st.nextToken());
        	ans=1;
        	
        	st = new StringTokenizer(br.readLine());
        	n = Integer.valueOf(st.nextToken());
        	m = Integer.valueOf(st.nextToken());
        	
        	for(int i=0;i<m;i++) {
        		ans*=n;
        	}
        	bw.write(String.valueOf(ans)+"\n");
        }
        
        bw.flush();
        bw.close();
    }
}