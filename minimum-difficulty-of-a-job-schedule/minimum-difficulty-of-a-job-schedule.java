class Solution {
    
    private int[] jobDifs;
    private int[][] mem;
    
    public int minDifficulty(int[] jobDifficulty, int d) {
        Set<Integer> set = Arrays.stream(jobDifficulty).boxed().collect(Collectors.toSet());
        if (set.size() == 1 && jobDifficulty.length >= d) {
            return set.stream().findFirst().get() * d;
        }
        jobDifs = jobDifficulty;
        mem = new int[jobDifs.length][d];
        return dp(0, d-1);
    }
    
    public int dp(int index, int d) {
        if (d<0) return -1;
        if (jobDifs.length - index <= d) return -1;
        if (d==0) {
            return findDif(index, jobDifs.length);        
        }
        if (mem[index][d] == 0) {
            int min = Integer.MAX_VALUE;
            for (int i=index+1; i<jobDifs.length; i++) {
                int nextResult = dp(i, d-1);
                if (nextResult != -1) {
                    int currentDif = findDif(index, i);
                    min = Math.min(min, nextResult+currentDif);
                    
                }
            }
            if (min == Integer.MAX_VALUE) {
                mem[index][d] = -1;
            } else {
                mem[index][d] = min;
            }

        }
        return mem[index][d];
    }
    
    private int findDif(int start, int end) {
        int max = 0;
        for (int i=start; i<end; i++) {
            max = Math.max(max, jobDifs[i]);
        }
        return max;
    }
}