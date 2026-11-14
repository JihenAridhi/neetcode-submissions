class Solution {
    public String minWindow(String s, String t) {
        String res = "";

        Map<Character, Integer> frequency = new HashMap<>();
        for (char c : t.toCharArray()) {
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }

        int missing = frequency.size();
        int start = 0;

        for(int end=0; end<s.length(); end++){
            char left = s.charAt(end);
            if(frequency.containsKey(left)){
                frequency.put(left, frequency.get(left)-1);
                if(frequency.get(left)==0)
                    missing--;
                while(missing==0){
                    if(res.isEmpty() || res.length() > end-start+1)
                        res = s.substring(start, end+1);
                    char right = s.charAt(start++);
                    if(frequency.containsKey(right)){
                        frequency.put(right, frequency.get(right)+1);
                        if(frequency.get(right)>0)
                            missing++;
                    }
                }
            }
        }

        return res;
    }
}
