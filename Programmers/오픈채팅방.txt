import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        Map<String,String> map = new HashMap<String,String>();
        for(String item : record) {
            String[] items = item.split(" ");
            if(items[0].compareTo("Enter")==0 || items[0].compareTo("Change")==0) {
                map.put(items[1],items[2]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(String item : record) {
            String[] items = item.split(" ");
            if(items[0].compareTo("Enter")==0) {
                sb.append(map.get(items[1]) + "님이 들어왔습니다.!");
            } else if(items[0].compareTo("Leave")==0) {
                sb.append(map.get(items[1]) + "님이 나갔습니다.!");
            }
        }
        
        answer = sb.toString().split("!");
        return answer;
    }
}