import java.io.*;
import java.util.*;

/*
 * Value가 너무 큼(Value로는 해결불가)
 * Key를 찾기위해 이분탐색 필요. 근데 키를 추가할때마다 정렬해야하는 번거로움발생
 * 자동으로 정렬해주는 맵...?
 * TreeMap : 2진트리 기반 맵으로 키값 기준으로 정렬되어 저장(레드블랙트리:트리가 한쪽으로 치우치는걸 방지 -> 탐색시간이 트리의 높이)
 * HashMap보단 성능이 떨어지지만 정렬된 데이터 사용시 효율성 증대
 */
public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int n,m,k,key,value,x;
	static TreeMap<Integer,Integer> map = new TreeMap();
	
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		map.put(Integer.MIN_VALUE+500, -1);
		map.put(Integer.MAX_VALUE-500, -1);
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			key = Integer.parseInt(st.nextToken());
			value = Integer.parseInt(st.nextToken());
			map.put(key, value);
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			key = Integer.parseInt(st.nextToken());
			if(x==1) {
				value = Integer.parseInt(st.nextToken());
				map.put(key, value);
			} else if(x==2) {
				value = Integer.parseInt(st.nextToken());
				int l = map.floorKey(key);
				int r = map.ceilingKey(key);
				
				if(map.get(l) == map.get(r)) { 
					map.put(key, value);
				} else if(r-key < key-l && k>=r-key) {
					map.put(r,value);
				} else if(r-key > key - l && k>= key-l) {
					map.put(l, value);
				}
			} else if(x==3) {
				int l = map.floorKey(key);
				int r = map.ceilingKey(key);
				
				if(map.get(l) == map.get(r)) {
					sb.append(map.get(key) + "\n");
				} else if(r-key == key-l && k>= r-key) {
					sb.append("?\n");
				} else if(r-key < key - l && k>= r-key) {
					sb.append(map.get(r)+"\n");
				} else if(r-key > key - l && k>= key-l) {
					sb.append(map.get(l) + "\n");
				} else {
					sb.append("-1\n");
				}
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}