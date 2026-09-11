class Solution {
    public boolean isPalindrome(String s) {
        List<Character> an = new ArrayList<>();

        for(char ch:s.toCharArray()){
            if(Character.isLetter(ch) || Character.isDigit(ch))
                an.add(Character.toLowerCase(ch));
        }
        
        for(int i=0; i<an.size()/2; i++){
            if (!an.get(i).equals(an.get(an.size()-1-i))) {
                return false;
            }
        }

        return true;
    }
}
