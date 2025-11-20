class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        java.util.Arrays.sort(intervals, (a, b) -> {
            if (a[1] != b[1]) {
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });

        int setSize = 0;
        
        int p1 = -1;
        int p2 = -1;
        
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            
            int coveredCount = 0;
            if (p1 >= start) {
                coveredCount++;
            }
            if (p2 >= start) {
                coveredCount++;
            }

            if (coveredCount == 2) {
                continue;
            } else if (coveredCount == 1) {
                int newPoint = end;
                
                p2 = p1; 
                p1 = newPoint;
                setSize++;

            } else { 
                p2 = end - 1; 
                p1 = end;     
                setSize += 2;
            }
        }
        
        return setSize;
    }
}