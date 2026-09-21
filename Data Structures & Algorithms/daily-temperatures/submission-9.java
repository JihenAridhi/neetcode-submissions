class Solution {
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];

        int start = 0, end = start + 1;
        for(int i=0; i<temperatures.length; i++){
            int j=i+1;
            while (j<temperatures.length) {
                if(temperatures[j]>temperatures[i]){
                    res[i]=j-i;
                    break;
                }
                j++;
            }
        }
        return res;
    }
}
