class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] products = new int[nums.length];
        int nonNullProduct = 1, zeroFrequency = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroFrequency++;
                continue;
            } else 
                nonNullProduct *= nums[i];
        }

        if (zeroFrequency > 1)
            return products;

        for (int i = 0; i < nums.length; i++) {
            if (zeroFrequency == 1) {
                if (nums[i] == 0) 
                    products[i] = nonNullProduct;
                else
                    products[i] = 0;
            } else
                products[i] = nonNullProduct / nums[i];
        }

        return products;
    }
}
