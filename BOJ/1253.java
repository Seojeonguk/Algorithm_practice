import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<n;i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        	int cnt = 0;
        	if(hm.containsKey(arr[i])) {
        		cnt = hm.get(arr[i]);
        	}
        	hm.put(arr[i],cnt + 1);
        }
        
        int ans = 0;
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i<n;i++) {
        	for(int j=i+1;j<n;j++) {
        		if(arr[i] == 0 || arr[j] == 0) {
        			continue;
        		}
        		int sum = arr[i] + arr[j];
        		if(hm.containsKey(sum) && !hs.contains(sum)) {
        			ans += hm.get(sum);
        			hs.add(sum);
        		}
        	}
        }
        
        if(hm.containsKey(0)) {
        	int zeroCnt = hm.get(0);
        	if(!hs.contains(0) && zeroCnt > 2) {
        		ans += zeroCnt;
        	}
        	hs.add(0);
        	for(int i=0;i<n;i++) {
        		if(!hs.contains(arr[i]) && hm.get(arr[i])>1) {
        			hs.add(arr[i]);
        			ans += hm.get(arr[i]);
        		}
        	}
        }
        
        sb.append(ans);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
