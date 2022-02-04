import java.io.*;
import java.util.*;
 
public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static class Shark {
		int x, y, no;
		public Shark(int x, int y, int no) {
			this.x = x;
			this.y = y;
			this.no = no;
		}
	}

	static int X[] = { -1, 1, 0, 0 };
	static int Y[] = { 0, 0, -1, 1 };
	static int N, M, K;
	static int map[][];
	static int smell[][];
	static int now_shark_dir[];  
	static int shark_dir_info[][][];
	
	static PriorityQueue<Shark> shark_list = new PriorityQueue<>((o1, o2) -> (o2.no - o1.no)); 
	static HashMap<Integer, Integer> smell_list = new HashMap<>(); 
    
 
    public static void main(String[] args) throws Exception {
    	st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		smell = new int[N][N];
		now_shark_dir = new int[M + 1]; 
		shark_dir_info = new int[M + 1][4][4];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0) {
					shark_list.add(new Shark(i, j, map[i][j])); 
					smell[i][j] = K;
					smell_list.put(i*400+j, map[i][j]);
				}
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= M; i++)
			now_shark_dir[i] = Integer.parseInt(st.nextToken()) - 1;

		for (int i = 1; i <= M; i++) {
			for (int j = 0; j < 4; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < 4; k++)
					shark_dir_info[i][j][k] = Integer.parseInt(st.nextToken()) - 1;
			}
		}

		System.out.println(solve());
    	
        bw.flush();
        bw.close();
    }
    
    public static int solve() {
		boolean flag=false;

		for(int time=0;time<=1000;time++) {
			int size = shark_list.size();
			if(size==1) return time;
			for (int i = 0; i < size; i++) {
				Shark shark = shark_list.poll();
				int x = shark.x;
				int y = shark.y;
				flag=false; 
				for (int d = 0; d < 4; d++) {
					int nx = x + X[shark_dir_info[shark.no][now_shark_dir[shark.no]][d]];
					int ny = y + Y[shark_dir_info[shark.no][now_shark_dir[shark.no]][d]];

					if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue; 
					if (smell[nx][ny] != 0) continue; 

					map[x][y] = 0;
					map[nx][ny] = shark.no;
					now_shark_dir[shark.no]=shark_dir_info[shark.no][now_shark_dir[shark.no]][d]; 
					flag=true;
					break;
				}

				if(!flag) {
					for (int d = 0; d < 4; d++) {
						int nx = x + X[shark_dir_info[shark.no][now_shark_dir[shark.no]][d]];
						int ny = y + Y[shark_dir_info[shark.no][now_shark_dir[shark.no]][d]];
						
						if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue; 
						if (smell_list.get(nx*400+ny) != shark.no) continue;
						
						map[x][y] = 0;
						map[nx][ny] = shark.no;
						now_shark_dir[shark.no]=shark_dir_info[shark.no][now_shark_dir[shark.no]][d];
						break;
					}
				}
				
			}
			smell();
		}
		return -1;
	}


	public static void smell() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(smell[i][j]!=0) 
					if(--smell[i][j]==0) 
						smell_list.remove(i*400+j); 
				
				if(map[i][j]!=0) { 
					shark_list.add(new Shark(i,j,map[i][j]));
					smell_list.put(i*400+j, map[i][j]);
					smell[i][j]=K;
				}
			}
		}
		
	}
}