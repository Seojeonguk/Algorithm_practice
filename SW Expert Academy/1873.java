import java.io.*;
import java.util.*;
  
class Solution {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int t,n,m,k;
    static char[][] arr;
    static String s;
    static int X[]= {-1,1,0,0,},Y[]= {0,0,-1,1};
    static char[] c = {'^','v','<','>'};
    static char[] c2 = {'U','D','L','R','S'};
    static int dx,dy,dir;
     
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // = new StringTokenizer(br.readLine());
        t = Integer.valueOf(br.readLine());
         
        for (int test_case = 1; test_case <= t; test_case++) {
        	st = new StringTokenizer(br.readLine());
        	n = Integer.valueOf(st.nextToken());
        	m = Integer.valueOf(st.nextToken());
        	
        	arr = new char[n][m];
        	
        	for(int i=0;i<n;i++) {
        		String s = br.readLine();
        		for(int j=0;j<m;j++) {
        			arr[i][j] = s.charAt(j);
        			for(int q=0;q<4;q++) {
        				if(arr[i][j] == c[q]) {
        					dx = i;
        					dy = j;
        					dir = q;
        				}
        			}
        		}
        	}

        	k = Integer.valueOf(br.readLine());
        	
        	s = br.readLine();
        	
        	for(int i=0;i<k;i++) {
        		int ndir = 0;
        		char a = s.charAt(i);
        		
        		for(int j=0;j<5;j++) {
        			if(c2[j]==a)
        				ndir = j;
        		}
        		if(ndir==4) {
        			int nx = dx;
        			int ny = dy;
        			
        			while(true) {
        				nx += X[dir];
        				ny += Y[dir];
        				if(nx<0 || ny<0 || nx>n-1 || ny>m-1) break;
        				if(arr[nx][ny] == '*') {
        					arr[nx][ny] = '.';
        					break;
        				}
        				if(arr[nx][ny] == '#') {
        					break;
        				}
        			}
        		}
        		else {
        			dir = ndir;
        			int nx = dx + X[ndir];
        			int ny = dy + Y[ndir];
        			
        			
        			if(nx<0 || ny<0 || nx>n-1 || ny>m-1 || arr[nx][ny]!='.') {
        				arr[dx][dy] = c[dir];
        			}
        			else {
        				arr[dx][dy] = '.';
        				dx = nx;
            			dy = ny;
            			arr[dx][dy] = c[dir];
        			}
        			
        			
        			
        		}
        		
        		
        	}
        	
        	bw.write("#" + String.valueOf(test_case) + " ");
    		for(int we=0;we<n;we++) {
    			bw.write(arr[we]);
    			bw.newLine();
        	}
        }
        
         
        bw.flush();
        bw.close();
    }
}