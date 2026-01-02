import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        Problem problem = new Problem();
        problem.init();
        problem.solve();
        problem.printAns();
    }

    public static class Problem {

        private int optionCnt;
        private String[] options;

        public void init() throws IOException {
            optionCnt = Integer.parseInt(br.readLine());

            options = new String[optionCnt];

            for (int i = 0; i < optionCnt; i++) {
                options[i] = br.readLine();
            }
        }

        public void solve() throws IOException {
            Set<Character> shortcuts = new HashSet<>();

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < optionCnt; i++) {
                String[] splits = options[i].split(" ");
                boolean findShortcut = false;
                for (int j = 0; j < splits.length; j++) {
                    char c = Character.toUpperCase(splits[j].charAt(0));
                    if (shortcuts.contains(c)) {
                        continue;
                    }
                    shortcuts.add(c);
                    boolean isAdded = splits[j].length() > 1;
                    String oldOption = splits[j];
                    splits[j] = "[" + splits[j].charAt(0) + "]";
                    if (isAdded) {
                        splits[j] = splits[j] + oldOption.substring(1);
                    }
                    findShortcut = true;
                    break;
                }

                if (findShortcut) {
                    String join = String.join(" ", splits);
                    options[i] = join;
                    continue;
                }

                for (int optionIdx = 0; optionIdx < options[i].length(); optionIdx++) {
                    char c = Character.toUpperCase(options[i].charAt(optionIdx));

                    if (c == ' ' || shortcuts.contains(c)) {
                        continue;
                    }

                    shortcuts.add(c);
                    String option = options[i].substring(0, optionIdx) + "[" + options[i].charAt(optionIdx) + "]" + options[i].substring(optionIdx + 1);
                    options[i] = option;
                    break;
                }
            }
        }

        public void printAns() throws IOException {
            for (int i = 0; i < optionCnt; i++) {
                bw.write(options[i] + "\n");
            }
            bw.flush();
        }
    }
}
