import java.util.Comparator;
import  java.util.PriorityQueue;

public class Main {
    public static int nodes = 1;
    public static void main(String[] args){
        int[] p = {20, 30, 35, 12, 3};
        int[] w = {2, 5, 7, 3, 1};

        knapsack(p, w, 13);
    }

    public static float bound(BinaryNode x, int W, int[] p, int[] w){
        int totweight, j;
        float result;

        if(x.getWeight() >= W){
            return 0;
        } else{
            result = x.getProfit();
            totweight = x.getWeight();
            j = x.getLevel() + 1;
            while(j < w.length && totweight + w[j] <= W){
                totweight = totweight + w[j];
                result = result + p[j];
                j++;
            }

            if(j < w.length){
                result = result + (W - totweight) * (p[j] / w[j]);
            }
            return result;
        }
    }

    public static void knapsack(int[] p, int[] w, int W){
        PriorityQueue<BinaryNode> Q = new PriorityQueue<>(w.length * w.length, new Comparator<BinaryNode>() {
            @Override
            public int compare(BinaryNode o1, BinaryNode o2) {
                return (int)(o2.getBound() - o1.getBound());
            }
        });
        int maxProfit;
        BinaryNode v = new BinaryNode();

        maxProfit = 0;
        v.setBound(bound(v, W, p, w));
        Q.add(v);


        while(Q.size() != 0){
            v = Q.poll();

            if(v.getBound() > maxProfit){
                BinaryNode u = new BinaryNode();
                nodes++;
                u.setLevel(v.getLevel() + 1);
                u.setWeight(v.getWeight() + w[u.getLevel()]);
                u.setProfit(v.getProfit() + p[u.getLevel()]);

                if(u.getWeight() <= W && u.getProfit() > maxProfit){
                    maxProfit = u.getProfit();
                }
                u.setBound(bound(u, W, p, w));
                if(u.getBound() > maxProfit){
                    Q.add(u);
                }

                BinaryNode t = new BinaryNode();
                nodes++;
                t.setLevel(v.getLevel() + 1);
                t.setWeight(v.getWeight());
                t.setProfit(v.getProfit());
                t.setBound(bound(t, W, p, w));

                if(t.getBound() > maxProfit){
                    Q.add(t);
                }
            }
        }

        System.out.println("The max profit is $" + maxProfit);
        System.out.println("The number of nodes is " + nodes);
    }
}
