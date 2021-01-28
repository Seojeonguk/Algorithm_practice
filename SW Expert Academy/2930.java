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

	static int tc,n;
	static PriorityQueue<Integer> q;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		tc = Integer.valueOf(st.nextToken());
		
        for (int test_case = 1; test_case <= tc; test_case++) {
        	bw.write("#" + String.valueOf(test_case) + " ");
        	
        	st = new StringTokenizer(br.readLine());
        	n = Integer.valueOf(st.nextToken());
        	q = new PriorityQueue<>(Collections.reverseOrder());
        	
        	for(int i=0;i<n;i++) {
        		st = new StringTokenizer(br.readLine());
        		int chk = Integer.valueOf(st.nextToken());
        		
        		if(chk == 1) {
        			int value = Integer.valueOf(st.nextToken());
        			q.add(value);
        		}
        		else {
        			if(q.size()==0) bw.write(String.valueOf("-1 "));
        			else bw.write(String.valueOf(q.poll()) + " ");
        		}
        	}
        	bw.newLine();
        }
        
        bw.flush();
        bw.close();
    }
}