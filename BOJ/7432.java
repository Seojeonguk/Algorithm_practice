import com.sun.source.tree.Tree;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n;

    public static void  main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());

        Trie t = new Trie();

        for(int i=0;i<n;i++) {
            List<String> directorys = new ArrayList<>();
            directorys.addAll(Arrays.asList(br.readLine().split("\\\\")));
            t.insert(directorys);
        }

        t.print(0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static class Trie {
        boolean last = false;
        TreeMap<String, Trie> hm = new TreeMap<>();

        public void insert(List<String> directorys) {
            if(directorys.isEmpty()) {
                this.last = true;
                return;
            }
            String next = directorys.get(0);
            if(!hm.containsKey(next)) {
                Trie nextNode = new Trie();
                hm.put(next,nextNode);
            }

            List<String> nextDirectorys = directorys;
            nextDirectorys.remove(0);
            hm.get(next).insert(nextDirectorys);
        }

        public void print (int depth) throws Exception {
            hm.forEach((key,value)-> {
                try{
                    for(int i=0;i<depth;i++) {
                        bw.write(' ');
                    }
                    bw.write(key+'\n');
                    value.print(depth+1);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }
}