import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int industryCnt = Integer.parseInt(br.readLine());
        int[] ramyeonCounts = new int[industryCnt + 2];
        StringTokenizer industryInfo = new StringTokenizer(br.readLine());
        for(int i = 0; i < industryCnt; i++) {
        	ramyeonCounts[i] = Integer.parseInt(industryInfo.nextToken());
        }
        
        int minCost = 0;
        for(int i = 0; i < industryCnt; i++) {
        	if(ramyeonCounts[i + 1] > ramyeonCounts[i + 2]) {
        		int nextTwoRamyeonCountDiff = ramyeonCounts[i + 1] - ramyeonCounts[i + 2];
        		
        		int purchaseRamyeonCount = Math.min(nextTwoRamyeonCountDiff, ramyeonCounts[i]);
        		
        		ramyeonCounts[i] -= purchaseRamyeonCount;
        		ramyeonCounts[i + 1] -= purchaseRamyeonCount;
        		
        		minCost += purchaseRamyeonCount * 5;
        	} 
        	
        	int minRamyeon = Math.min(ramyeonCounts[i], Math.min(ramyeonCounts[i + 1], ramyeonCounts[i + 2]));
        		
        	for(int j = 0; j < 3; j++) {
        		ramyeonCounts[i + j] -= minRamyeon;
        	}
        	minCost += minRamyeon * 7;
        	
        	minCost += ramyeonCounts[i] * 3;
        }
        
        sb.append(minCost);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
