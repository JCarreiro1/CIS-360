public class BinaryNode implements Comparable<BinaryNode>{
    int w;
    int p;
    int lev;
    float b;
    BinaryNode l = null;
    BinaryNode r = null;

    public BinaryNode(int weight, int profit, int level, float bound, BinaryNode left, BinaryNode right){
        w = weight;
        p = profit;
        lev = level;
        b = bound;
        l = left;
        r = right;
    }

    public BinaryNode(){
        w = 0;
        p = 0;
        b = 0;
        lev = -1;
    }

    public void setWeight(int input){
        this.w = input;
    }

    public int getWeight(){
        return this.w;
    }

    public void setProfit(int input){
        this.p = input;
    }

    public int getProfit(){
        return this.p;
    }

    public void setBound(float input){
        this.b = input;
    }

    public float getBound(){
        return this.b;
    }

    public void setLevel(int input){
        this.lev = input;
    }

    public int getLevel(){
        return this.lev;
    }

    public void setLeft(BinaryNode input){
        this.l = input;
    }

    public BinaryNode getLeft(){
        return this.l;
    }

    public void setRight(BinaryNode input){
        this.r = input;
    }

    public BinaryNode getRight(){
        return this.r;
    }

    public int compareTo(BinaryNode otherNode){
        return Float.compare(this.getBound(), otherNode.getBound());
    }
}