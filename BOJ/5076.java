import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        while (true) {
            String html = br.readLine();
            if ("#".equals(html)) {
                break;
            }

            Stack<String> tags = new Stack<>();
            boolean isLegal = true;

            Loop1:
            for (int i = 0; i < html.length(); i++) {
                char c = html.charAt(i);
                if (c == '<') {
                    for (int j = i + 1; j < html.length(); j++) {
                        char c2 = html.charAt(j);
                        if (c2 == '>') {
                            String tag = html.substring(i + 1, j);
                            if (tag.charAt(tag.length() - 1) == '/') {
                                break;
                            }
                            String[] tagSplit = tag.split(" ");
                            if (tagSplit[0].charAt(0) == '/') {
                                if (tags.isEmpty()) {
                                    isLegal = false;
                                    break Loop1;
                                }
                                String lastTag = tags.pop();
                                if (!tagSplit[0].substring(1).equals(lastTag)) {
                                    isLegal = false;
                                    break Loop1;
                                }
                            } else {
                                tags.push(tagSplit[0]);
                            }
                            break;
                        }
                    }
                }
            }

            if (!tags.isEmpty()) {
                isLegal = false;
            }

            sb.append(isLegal ? "legal" : "illegal").append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
