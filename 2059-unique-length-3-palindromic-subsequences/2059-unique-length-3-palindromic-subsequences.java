class Solution {
    public int countPalindromicSubsequence(String s) {
       int totalCount = 0;
        int n = s.length();

        int[] firstIndex = new int[26];
        int[] lastIndex = new int[26];

        for (int i = 0; i < 26; i++) {
            firstIndex[i] = -1;
            lastIndex[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            int charIdx = s.charAt(i) - 'a';

            if (firstIndex[charIdx] == -1) {
                firstIndex[charIdx] = i;
            }

            lastIndex[charIdx] = i;
        }

        for (int i = 0; i < 26; i++) {
            int start = firstIndex[i];
            int end = lastIndex[i];

            if (start != -1 && start < end) {
                
                Set<Character> uniqueInnerChars = new HashSet<>();

                for (int j = start + 1; j < end; j++) {
                    uniqueInnerChars.add(s.charAt(j));
                }

                totalCount += uniqueInnerChars.size();
            }
        }

        return totalCount;
    } 
    }
