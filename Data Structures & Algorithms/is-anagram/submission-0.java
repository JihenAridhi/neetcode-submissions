class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length())
            return false;

        HashMap<Character, Integer> sLetterOccurances = new HashMap<>();
        HashMap<Character, Integer> tLetterOccurances = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            if(sLetterOccurances.containsKey(s.charAt(i)))
                sLetterOccurances.put(s.charAt(i), sLetterOccurances.get(s.charAt(i)) + 1);
            else sLetterOccurances.put(s.charAt(i), 1);
        }

        for(int i=0; i<t.length(); i++){
            if(tLetterOccurances.containsKey(t.charAt(i)))
                tLetterOccurances.put(t.charAt(i), tLetterOccurances.get(t.charAt(i)) + 1);
            else tLetterOccurances.put(t.charAt(i), 1);
        }

        return tLetterOccurances.equals(sLetterOccurances);

    }
}
