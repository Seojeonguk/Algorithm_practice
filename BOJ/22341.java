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
        
        StringTokenizer paperInfo = new StringTokenizer(br.readLine());
        int verticalSize = Integer.parseInt(paperInfo.nextToken());
        int horizontalSize = verticalSize;

        int dotCnt = Integer.parseInt(paperInfo.nextToken());

        for(int dotNum = 1; dotNum <= dotCnt; dotNum++) {
            StringTokenizer dotInfo = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(dotInfo.nextToken());
            int y = Integer.parseInt(dotInfo.nextToken());

            if(verticalSize <= x || horizontalSize <= y) {
                continue;
            }

            int verticalCutArea = verticalSize * y;
            int horizontalCutArea = horizontalSize * x;

            if(verticalCutArea > horizontalCutArea) {
                horizontalSize = y;
            } else {
                verticalSize = x;
            }
        }

        sb.append(verticalSize * horizontalSize);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
