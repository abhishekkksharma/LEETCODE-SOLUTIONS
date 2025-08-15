class Solution {
public:
    int buyChoco(vector<int>& prices, int money) {
        sort(prices.begin(), prices.end());
        int totalCost = prices[0] + prices[1];
        if (totalCost <= money) {
            return money - totalCost;
        }
        return money;
    }
};
