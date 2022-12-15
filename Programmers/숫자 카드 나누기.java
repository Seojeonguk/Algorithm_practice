public static int solution(int[] arrayA, int[] arrayB) {
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);

        int answer = 0;
        answer = Math.max(answer,findMax(findCandidate(arrayA[0]),arrayA,arrayB));
        answer = Math.max(answer,findMax(findCandidate(arrayB[0]),arrayB,arrayA));
        System.out.println(answer);
        return answer;
    }

    public static HashSet<Integer> findCandidate(int x) {
        HashSet<Integer> ret = new HashSet<>();

        for(int i=1;i<=(int)Math.sqrt(x);i++) {
            if(x%i==0) {
                ret.add(i);
                ret.add(x/i);
            }
        }

        return ret;
    }

    public static int findMax(HashSet<Integer> h, int[] arrayA,int[] arrayB) {
        int ret=0;
        for(int next : h) {
            boolean isPossible = true;
            for(int idx=0;idx<arrayA.length;idx++)
                if(!(arrayA[idx]%next==0 && arrayB[idx]%next!=0))
                    isPossible = false;

            if(isPossible)
                ret = Math.max(ret,next);
        }
        return ret;
    }