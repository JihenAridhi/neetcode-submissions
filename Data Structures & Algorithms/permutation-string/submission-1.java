class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;

        char[] chars = s1.toCharArray();
        Arrays.sort(chars);
        int i = 0;
        while (i < s2.length() - s1.length() + 1) {
            String sub = s2.substring(i, i + s1.length());
            char[] SubChars = sub.toCharArray();
            Arrays.sort(SubChars);
            if (Arrays.equals(SubChars, chars))
                return true;
            i++;
        }
        return false;
    }
}
