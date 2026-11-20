class TimeMap {

    Map<String, List<List<Object>>> data;

    public TimeMap() {
        data = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        List<Object> values = List.of(timestamp, value);
        List<List<Object>> valuesList = data.getOrDefault(key, new ArrayList<>());
        valuesList.add(values);
        data.put(key, valuesList);
    }

    public String get(String key, int timestamp) {

        String value = new String();

        List<List<Object>> valuesList = data.get(key);
        if(valuesList == null)
            return value;

        int start=0, end=valuesList.size()-1;
        while(start<=end){
            int mid = (start+end)/2;
            int t = (int) valuesList.get(mid).get(0);

            if(timestamp < t)
                end = mid-1;
            else{
                value = (String) valuesList.get(mid).get(1);
                if(timestamp == t)
                    return value;
                start = mid+1;
            }
        }

        return value;
    }
}
