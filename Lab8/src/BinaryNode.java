public class BinaryNode{
    char d;
    BinaryNode l = null;
    BinaryNode r = null;

    public BinaryNode(){
        char data = d;
        BinaryNode left = l;
        BinaryNode right = r;
    }

    public void setData(char input){
        this.d = input;
    }

    public char getData(){
        return this.d;
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

    public void travPrefix(BinaryNode input){
        System.out.print(input.getData());
        if(input.getLeft() != null)
            travPrefix(input.getLeft());

        if(input.getRight() != null)
            travPrefix(input.getRight());
    }

    public void travPostfix(BinaryNode input){
        if(input.getLeft() != null)
            travPostfix(input.getLeft());

        if(input.getRight() != null)
            travPostfix(input.getRight());
        System.out.print(input.getData());
    }

    public void travInfix(BinaryNode input){
        if(input.getLeft() != null)
            travInfix(input.getLeft());

        System.out.print(input.getData());

        if(input.getRight() != null)
            travInfix(input.getRight());
    }
}
