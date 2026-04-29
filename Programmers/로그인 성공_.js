class Solution {
    public String solution(String[] id_pw, String[][] db) {
        for(String[] dbInfos : db) {
            if(id_pw[0].equals(dbInfos[0])) {
                if(id_pw[1].equals(dbInfos[1])) {
                    return "login";
                } else {
                    return "wrong pw";
                }
            }
        }

        return "fail";
    }
}