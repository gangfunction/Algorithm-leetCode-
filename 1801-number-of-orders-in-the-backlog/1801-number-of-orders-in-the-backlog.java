class Solution {
    /*
    구매와 판매주문이 분리되어있고, 구매주문은 가장 낮은 가격의 판매주문과 매칭되야한다.
    그래서 받은 주문들을 최소 힙과 최대힙을 활용한다. 
    
    */
    public int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<int[]> buyOrders = new PriorityQueue<>((a,b) -> b[0]- a[0]);
        PriorityQueue<int[]> sellOrders = new PriorityQueue<>((a,b) -> a[0]- b[0]);
        
        for(int[] order : orders){
            int price = order[0];
            int amount = order[1];
            int type = order[2];

            if(type ==0){
                while(!sellOrders.isEmpty() && sellOrders.peek()[0]<=price && amount>0){
                    int[] sellOrder = sellOrders.peek();
                    if(sellOrder[1]<=amount){
                        amount -=sellOrder[1];
                        sellOrders.poll();
                    }else{
                        sellOrder[1] -= amount;
                        amount =0;
                    }
                }
                if(amount>0){
                    buyOrders.offer(new int[]{price, amount});
                }
            }else{
                while(!buyOrders.isEmpty() && buyOrders.peek()[0] >= price && amount >0){
                    int[] buyOrder = buyOrders.peek();
                    if(buyOrder[1] <= amount){
                        amount -= buyOrder[1];
                        buyOrders.poll();
                    }else{
                        buyOrder[1] -= amount;
                        amount =0;
                    }
                }
                if(amount>0){
                    sellOrders.offer(new int[]{price, amount});
                }
            }
        }
        long count =0;
        int mod = 1_000_000_007;
        
        while(!sellOrders.isEmpty()){
            count = (count+sellOrders.poll()[1]) % mod;
        }
        while(!buyOrders.isEmpty()){
            count = (count+ buyOrders.poll()[1]) % mod;
        }
        return (int)count;
        
        
    }
}