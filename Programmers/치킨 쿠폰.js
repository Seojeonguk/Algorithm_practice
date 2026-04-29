class Solution {
    public int solution(int chicken) {
        int curCoupon = chicken;
        int serviceChicken = 0;

        while (curCoupon >= 10) {
            int addedCoupon = curCoupon / 10;
            serviceChicken += addedCoupon;
            curCoupon = curCoupon % 10 + addedCoupon;
        }

        return serviceChicken;
    }
}