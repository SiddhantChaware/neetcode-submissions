class Solution {
    public int getSum(int a, int b) {
        while( b != 0){     //b mtlb carry
            int carry = (a & b) << 1;       //carry
            a = a ^ b;          //addition
            b = carry; 
        }
        return a;
    }
}
