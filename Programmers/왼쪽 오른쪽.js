import java.util.ArrayList;

class Solution {
    public String[] solution(String[] str_list) {
        ArrayList<String> ans = new ArrayList<>();

        for (int idx = 0; idx < str_list.length; idx++) {
            if (str_list[idx].equals("l")) {
                for (int j = 0; j < idx; j++) {
                    ans.add(str_list[j]);
                }
                break;
            } else if (str_list[idx].equals("r")) {
                for (int j = idx + 1; j < str_list.length; j++) {
                    ans.add(str_list[j]);
                }
                break;
            }
        }

        return ans.toArray(new String[ans.size()]);
    }
}