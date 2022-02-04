import java.io.*;
import java.util.*;
 
public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n,m,t,sum;
    static int idx;
    static int[] x,y;
    static int[][] a,temp;
    static int[] X= {1,0,-1,0}, Y= {0,1,0,-1};
 
    public static void main(String[] args) throws Exception {
    	st = new StringTokenizer(br.readLine());
    	n = Integer.valueOf(st.nextToken());
    	m = Integer.valueOf(st.nextToken());
    	t = Integer.valueOf(st.nextToken());
    	
    	x = new int[2];
    	y = new int[2];
    	a = new int[n][m];
    	
    	for(int i=0;i<n;i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j=0;j<m;j++) {
    			a[i][j] = Integer.valueOf(st.nextToken());
    			if(a[i][j]==-1) {
    				x[idx] = i;
    				y[idx++]= j;
    			} else if(a[i][j]!=0) {
    				sum += a[i][j];
    			}
    		}
    	}
    	
    	for(int tc=0;tc<t;tc++) {
    		if(sum==0) break;
    		diffusion();
    		clean_air();
    	}
    	
    	System.out.println(sum);
         
        bw.flush();
        bw.close();
    }
    
    public static void diffusion() {
    	temp = new int[n][m];
    	
    	for(int i=0;i<2;i++)
    		a[x[i]][y[i]] = -1;
    	
    	for(int i=0;i<n;i++) {
    		for(int j=0;j<m;j++) {
    			if(a[i][j]>0) {
    				int cnt=0;
    				for(int k=0;k<4;k++) {
    					int nx = i + X[k];
    					int ny = j + Y[k];
    					if(range(nx,ny) || a[nx][ny]==-1) continue;
    					temp[nx][ny] += a[i][j]/5;
    					cnt++;
    				}
    				temp[i][j] += a[i][j] - (a[i][j]/5) * cnt;
    			}
    		}
    	}
    	
    	for(int i=0;i<n;i++)
    		for(int j=0;j<m;j++)
    			a[i][j] = temp[i][j];
    	
    	
    }
    
    public static void clean_air() {
    	for(int i=0;i<2;i++) {
    		int nx = x[i] + (i==0?-1:1);
    		int ny = y[i];
    		sum -= a[nx][ny];
    		a[nx][ny] = 0;
    	}
    	
    	for(int ii=0;ii<=1;ii++) {
    		int nx = x[ii];
    		int ny = y[ii];
    		
    		for(int dir=0;dir<4;dir++) {
    			while(true) {
    				int temp_nx = nx + X[dir]*(ii==0?-1:1);
    				int temp_ny = ny + Y[dir];
    				if(range(temp_nx,temp_ny)) break;
    				
    				a[nx][ny] = a[temp_nx][temp_ny];
    				nx = temp_nx;
    				ny = temp_ny;
    				if(dir==2 && nx==x[ii]) break;
    			}
    		}
    	}
    }
    
    public static boolean range(int xx,int yy) {
    	return (xx<0 || yy<0 || xx>n-1 || yy>m-1);
    }
}

class data {
	int x, y;
	public data(int x,int y) {
		this.x = x;
		this.y = y;
	}
}