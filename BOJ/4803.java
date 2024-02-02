import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        for(int tc=1;;tc++) {
        	st = new StringTokenizer(br.readLine());
        	int totalPoint = Integer.parseInt(st.nextToken());
        	int totalNode = Integer.parseInt(st.nextToken());
        	
        	if(totalPoint == 0 && totalNode == 0) {
        		break;
        	}
        	
        	ArrayList<Integer>[] nodes = new ArrayList[totalPoint + 1];
        	for(int i=1;i<=totalPoint;i++) {
        		nodes[i] = new ArrayList<>();
        	}
        	
        	for(int i=0;i<totalNode;i++) {
        		st = new StringTokenizer(br.readLine());
        		int aPoint = Integer.parseInt(st.nextToken());
        		int bPoint = Integer.parseInt(st.nextToken());
        		
        		nodes[aPoint].add(bPoint);
        		nodes[bPoint].add(aPoint);
        	}
        	
        	boolean[] isVisit = new boolean[totalPoint + 1];
        	int treeCnt = 0;
        	for(int i=1;i<=totalPoint;i++) {
        		if(isVisit[i]) {
        			continue;
        		}
        		if(isTree(nodes, isVisit,i,-1)) {
        			treeCnt++;
        		}
        	}
        	
        	sb.append("Case ").append(tc).append(": ");
        	if(treeCnt == 0) {
        		sb.append("No trees.\n");
        	} else if(treeCnt == 1) {
        		sb.append("There is one tree.\n");
        	} else {
        		sb.append("A forest of ").append(treeCnt).append(" trees.\n");
        	}
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static boolean isTree(ArrayList<Integer>[] nodes, boolean[] isVisit, int cur,int parent) {
    	isVisit[cur] = true;
        boolean canMakeTree = true;
    	for(int next : nodes[cur]) {
    		if(next == parent) {
    			continue;
    		}
    		
    		if(isVisit[next]) {
    			return false;
    		}
    		canMakeTree &= isTree(nodes,isVisit,next,cur);
    	}
    	
    	return canMakeTree;
    }
}
