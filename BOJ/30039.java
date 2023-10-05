import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        Dummy hHead = new Dummy();
        Dummy hTail = new Dummy();
        Dummy vHead = new Dummy();
        Dummy vTail = new Dummy();

        hHead.setHNext(hTail);
        hTail.setHPrev(hHead);
        vHead.setVNext(vTail);
        vTail.setVPrev(vHead);
        int horizontalSize = 0;
        int verticalSize = 0;
        Dummy middle = new Dummy();
        middle.setHPrev(hHead).setHNext(hTail).setVPrev(vHead).setVNext(vTail).setCur(hHead);

        int commandCnt = Integer.parseInt(br.readLine());
        while (commandCnt-- > 0) {
            String[] commands = br.readLine().split(" ");
            if ("hpush".equals(commands[0])) {
                int x = Integer.parseInt(commands[1]);
                horizontalSize++;
                Dummy newDummy = new Dummy();
                newDummy.setX(x);
                newDummy.setHNext(hTail);
                newDummy.setHPrev(hTail.hPrev);
                hTail.hPrev.setHNext(newDummy);
                hTail.setHPrev(newDummy);
                if (horizontalSize % 2 == 1) {
                    if (horizontalSize == 1) {
                        middle.setCur(newDummy);
                        verticalSize++;
                        newDummy.setVPrev(vHead);
                        newDummy.setVNext(vTail);
                        vHead.setVNext(newDummy);
                        vTail.setVPrev(newDummy);
                    } else {
                        Dummy vPrevTemp = middle.cur.vPrev;
                        Dummy vNextTemp = middle.cur.vNext;
                        middle.cur.vPrev.setVNext(null);
                        middle.cur.vNext.setVPrev(null);
                        middle.cur.setVPrev(null).setVNext(null);
                        middle.setCur(middle.cur.hNext);
                        middle.cur.setVPrev(vPrevTemp).setVNext(vNextTemp);
                        middle.cur.vPrev.setVNext(middle.cur);
                        middle.cur.vNext.setVPrev(middle.cur);
                    }
                }
            } else if ("hpop".equals(commands[0])) {
                sb.append(hHead.hNext.x).append("\n");
                if (horizontalSize == 0) {
                    continue;
                }
                if (horizontalSize == 1) {
                    verticalSize--;
                    if (verticalSize == 0) {
                        horizontalSize = 0;
                        hHead.setHNext(hTail);
                        hTail.setHPrev(hHead);
                        vHead.setVNext(vTail);
                        vTail.setVPrev(vHead);
                        middle.setHPrev(hHead).setHNext(hTail).setVPrev(vHead).setVNext(vTail).setCur(hHead);
                    } else {
                        Dummy vPrevTemp = middle.cur.vPrev;
                        Dummy vNextTemp = middle.cur.vNext;
                        Dummy hPrevTemp = middle.cur.hPrev;
                        Dummy hNextTemp = middle.cur.hNext;
                        middle.cur.setHPrev(null).setHNext(null).setVPrev(null).setVNext(null);
                        if (verticalSize % 2 == 1) {
                            middle.setCur(vNextTemp);
                        } else {
                            middle.setCur(vPrevTemp);
                        }
                        hHead.setHNext(middle.cur);
                        hTail.setHPrev(middle.cur);
                        middle.cur.setHPrev(hPrevTemp);
                        middle.cur.setHNext(hNextTemp);
                        vPrevTemp.setVNext(vNextTemp);
                        vNextTemp.setVPrev(vPrevTemp);
                    }
                } else {
                    horizontalSize--;
                    if (horizontalSize % 2 == 1) {
                        Dummy vPrevTemp = middle.cur.vPrev;
                        Dummy vNextTemp = middle.cur.vNext;
                        Dummy hNextTemp = middle.cur.hNext;

                        middle.cur.setVPrev(null).setVNext(null);

                        middle.setCur(hNextTemp);
                        middle.cur.setVPrev(vPrevTemp).setVNext(vNextTemp);
                        vPrevTemp.setVNext(middle.cur);
                        vNextTemp.setVPrev(middle.cur);
                    }
                    Dummy first = hHead.hNext;
                    hHead.setHNext(first.hNext);
                    first.hNext.setHPrev(hHead);
                    first.setHPrev(null).setHNext(null);
                }
            } else if ("hfront".equals(commands[0])) {
                sb.append(hHead.hNext.x).append("\n");
            } else if ("hback".equals(commands[0])) {
                sb.append(hTail.hPrev.x).append("\n");
            } else if ("hsize".equals(commands[0])) {
                sb.append(horizontalSize).append("\n");
            } else if ("vpush".equals(commands[0])) {
                int x = Integer.parseInt(commands[1]);
                verticalSize++;
                Dummy newDummy = new Dummy();
                newDummy.setX(x);
                newDummy.setVNext(vTail);
                newDummy.setVPrev(vTail.vPrev);
                vTail.vPrev.setVNext(newDummy);
                vTail.setVPrev(newDummy);

                if (verticalSize % 2 == 1) {
                    if (verticalSize == 1) {
                        middle.setCur(newDummy);
                        horizontalSize++;
                        newDummy.setHPrev(hHead).setHNext(hTail);
                        hHead.setHNext(newDummy);
                        hTail.setHPrev(newDummy);
                    } else {
                        Dummy hPrevTemp = middle.cur.hPrev;
                        Dummy hNextTemp = middle.cur.hNext;
                        middle.cur.hPrev.setHNext(null);
                        middle.cur.hNext.setHPrev(null);
                        middle.cur.setHPrev(null).setHNext(null);
                        middle.setCur(middle.cur.vNext);
                        middle.cur.setHPrev(hPrevTemp).setHNext(hNextTemp);
                        middle.cur.hPrev.setHNext(middle.cur);
                        middle.cur.hNext.setHPrev(middle.cur);
                    }
                }
            } else if ("vpop".equals(commands[0])) {
                sb.append(vHead.vNext.x).append("\n");
                if (verticalSize == 0) {
                    continue;
                }
                if (verticalSize == 1) {
                    horizontalSize--;

                    if (horizontalSize == 0) {
                        verticalSize = 0;
                        hHead.setHNext(hTail);
                        hTail.setHPrev(hHead);
                        vHead.setVNext(vTail);
                        vTail.setVPrev(vHead);
                        middle.setHPrev(hHead).setHNext(hTail).setVPrev(vHead).setVNext(vTail).setCur(hHead);
                    } else {
                        Dummy hPrevTemp = middle.cur.hPrev;
                        Dummy hNextTemp = middle.cur.hNext;
                        Dummy vPrevTemp = middle.cur.vPrev;
                        Dummy vNextTemp = middle.cur.vNext;

                        middle.cur.setHPrev(null).setHNext(null).setVPrev(null).setVNext(null);

                        if (horizontalSize % 2 == 1) {
                            middle.setCur(hNextTemp);
                        } else {
                            middle.setCur(hPrevTemp);
                        }

                        vHead.setVNext(middle.cur);
                        vTail.setVPrev(middle.cur);
                        middle.cur.setVPrev(vPrevTemp);
                        middle.cur.setVNext(vNextTemp);
                        hPrevTemp.setHNext(hNextTemp);
                        hNextTemp.setHPrev(hPrevTemp);
                    }
                } else {
                    verticalSize--;
                    if (verticalSize % 2 == 1) {
                        Dummy vNextTemp = middle.cur.vNext;
                        Dummy hPrevTemp = middle.cur.hPrev;
                        Dummy hNextTemp = middle.cur.hNext;

                        middle.cur.setHPrev(null).setHNext(null);
                        middle.setCur(vNextTemp);
                        middle.cur.setHPrev(hPrevTemp).setHNext(hNextTemp);

                        hPrevTemp.setHNext(middle.cur);
                        hNextTemp.setHPrev(middle.cur);
                    }
                    Dummy first = vHead.vNext;
                    vHead.setVNext(first.vNext);
                    first.vNext.setVPrev(vHead);
                    first.setVPrev(null).setVNext(null);
                }
            } else if ("vfront".equals(commands[0])) {
                sb.append(vHead.vNext.x).append("\n");
            } else if ("vback".equals(commands[0])) {
                sb.append(vTail.vPrev.x).append("\n");
            } else if ("vsize".equals(commands[0])) {
                sb.append(verticalSize).append("\n");
            } else if ("size".equals(commands[0])) {
                sb.append(Math.max(0, horizontalSize + verticalSize - 1)).append("\n");
            } else if ("empty".equals(commands[0])) {
                sb.append(horizontalSize == 0 ? 1 : 0).append("\n");
            } else if ("middle".equals(commands[0])) {
                sb.append(middle.cur.x).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static class Dummy {
        int x;
        Dummy cur;
        Dummy hPrev;
        Dummy hNext;
        Dummy vPrev;
        Dummy vNext;

        Dummy() {
            this.x = -1;
            this.cur = null;
            this.hPrev = null;
            this.vPrev = null;
            this.vNext = null;
        }

        public void setX(int x) {
            this.x = x;
        }

        public Dummy setCur(Dummy dummy) {
            this.cur = dummy;
            return this;
        }

        public Dummy setHPrev(Dummy dummy) {
            this.hPrev = dummy;
            return this;
        }

        public Dummy setHNext(Dummy dummy) {
            this.hNext = dummy;
            return this;
        }

        public Dummy setVPrev(Dummy dummy) {
            this.vPrev = dummy;
            return this;
        }

        public Dummy setVNext(Dummy dummy) {
            this.vNext = dummy;
            return this;
        }
    }
}
