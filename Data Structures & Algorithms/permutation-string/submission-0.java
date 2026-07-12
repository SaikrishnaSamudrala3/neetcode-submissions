class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
        }

        int i = 0;
        int j = 0;

        while(j<s2.length()){
            s2Count[s2.charAt(j) - 'a']++;

            if(j-i+1>s1.length()){
                s2Count[s2.charAt(i) - 'a']--;
                i++;
            }

            if(Arrays.equals(s1Count, s2Count)){
                return true;
            }

            j++;
        }
        return false;

    }
}
