class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int empty_bottles = numBottles;
        int bottles_drunk = numBottles;
        while(empty_bottles >= numExchange){
            empty_bottles -= numExchange;
            numExchange++;
            bottles_drunk++;
            empty_bottles++;
        }
        return bottles_drunk;
    }
}