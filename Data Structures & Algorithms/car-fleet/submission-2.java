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
            return (int) (b[0] - a[0]);
        });
        
        int i=0;
        while(i < cars.length){
            int count = cars.length - i;
            double time = cars[i][2];
            while(i<cars.length && cars[i][0] + cars[i][1]*time >= target)
                i++;
            if(count > cars.length - i)
                fleet++;
        }

        return fleet;
    }
}
