class Solution {

    public String encode(List<String> strs) {
        String encoded = new String();
        for(String s:strs)
            encoded += s + Character.toString((char)200);
        return encoded;
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();
        int i = str.indexOf(Character.toString((char)200));
        int start = 0;
        while(i>=0){
            decoded.add(str.substring(start,i));
            start = i+1;
            i = str.indexOf(Character.toString((char)200), start);
        }
        return decoded;
    }
}
