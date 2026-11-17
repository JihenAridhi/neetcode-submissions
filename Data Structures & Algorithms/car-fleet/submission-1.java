class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int fleet = 0;

        Double[][] cars = new Double[position.length][3];
        for (int i = 0; i < cars.length; i++) {
            cars[i][0] = (double) position[i];
            cars[i][1] = (double) speed[i];
            cars[i][2] = (double) (target - position[i]) / speed[i]; // arrival time
        }
        Arrays.sort(cars, (a, b) -> {
            return (int) (a[0] - b[0]);
        });
        Stack<Double[]> stack = new Stack<>();
        for(Double[] c : cars){
            stack.push(c);
        }
        
        while(!stack.isEmpty()){
            int count = stack.size();
            double time = stack.peek()[2];
            while(!stack.isEmpty() && stack.peek()[0] + stack.peek()[1]*time >= target)
                stack.pop();
            if(count > stack.size())
                fleet++;
        }

        return fleet;
    }
}
