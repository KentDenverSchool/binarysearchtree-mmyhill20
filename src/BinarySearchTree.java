
public class BinarySearchTree<Key extends Comparable<Key>, Value> {

    public Node<Key, Value> root;

    public BinarySearchTree() {
        root = null;
    }


    public int size() {
        return size(root);
    }

    private int size(Node x) {//size is distance of node in question from top node???
        if(x == null)return 0;
        return 1 + size(x.getLeft()) + size(x.getRight());
    }

    public boolean isEmpty() {
        return (root == null);
    }

    //recursive put wrapper
    public void put(Key key, Value value) {
        put(root, key, value);
    }

    //recursive put
    //sets left/right or creates a new node appropriately, returns the
    //modified node n
    private void put(Node<Key, Value> n, Key key, Value val) {
        if (root == null) {
            root = new Node(key, val);
        } else if (n.getKey().compareTo(key) < 0) {//assume none of the keys are repeating
            //neg means node to place is greater than node trying to place on, left pointer
            //left branch
            if (n.getLeft() == null) n.setLeft(new Node(key, val));//base case
            else put(n.getLeft(), key, val);//keep recursing
        } else {//n.getKey().compareTo(key) > 0
            if (n.getRight() == null) n.setRight(new Node(key, val));//base case
            else put(n.getRight(), key, val);//keep recursing
        }
    }

    //recursive get wrapper
    public Value get(Key key) {
        return get(root, key);
    }

    //recursive get
    //returns null if the key does not exist
    private Value get(Node<Key, Value> n, Key key) {
        if (n != null) {
            if (n.getKey().equals(key)) return n.getValue();
            else if (n.getKey().compareTo(key) > 0) return get(n.getRight(), key);
            else if (n.getKey().compareTo(key) < 0) return get(n.getLeft(), key);

        }return null;
    }

    public boolean contains(Key key) {
        return !(get(root, key) == null);
    }

    public Value remove(Key key) {
        Value v = get(key);
        root = remove(root, key);
        return v;
    }

    private Node remove(Node<Key, Value> n, Key key) {
        if (!contains(n.getKey())){
            return null;
        }//node to be removed DNE
        int i = key.compareTo(n.getKey());
        if (i < 0) {
            n.setLeft(remove(n.getLeft(), key));
        } else if (i > 0) {
            n.setRight(remove(n.getRight(), key));
        } else {//compareTo returns 0 bc value to remove has been found
            if (n.getRight() == null) return n.getLeft();
            if (n.getLeft() == null) return n.getRight();
            Node min = min(n.getRight());
            min.setLeft(n.getLeft());
            n = n.getRight();
        }
        //   n.setSize(size(n.getRight()) + size(n.getLeft()) + 1);
        return n;
    }

    public Key min() {
        return min(root).getKey();
    }

    //returns the node at the right most right branch of n
    private Node<Key, Value> min(Node<Key, Value> n) {
        if(n == null){
            return null;
        }
        if (n.getRight()== null) return n;
            else return min(n.getRight());
    }

    public Key max() {
        return max(root).getKey();
    }

    //returns the node at the left most left branch of n
    private Node<Key, Value> max(Node<Key, Value> n) {
           if(n == null){
               return null;
           }
            if (n.getLeft() ==null) return n;
           else return  max(n.getLeft());
       }



    public String toString() {
        String temp = toString(root);
        temp = temp.substring(0, temp.length() - 2);
        return "{" + temp + "}";
    }

    private String toString(Node<Key, Value> n) {
        if (n == null) return "";
        return toString(n.getLeft()) +
                n.getKey() + "=" + n.getValue() + ", " +
                toString(n.getRight());
    }

    public static boolean isBST(BinarySearchTree t){
        return isBST(t.root);
    }

    private static boolean isBST(Node n){
        if(n == null)return true;//is empty, is BST
        else if(n.getLeft() == null && n.getRight() == null)return true;//is only node, is BST
        else{
            if(n.getRight() == null)return (n.getKey().compareTo(n.getLeft().getKey()) < 0) && isBST(n.getLeft());//left is > current && is right is null, but not both
            else if(n.getLeft() == null)return (n.getKey().compareTo(n.getRight().getKey()) > 0) && isBST(n.getRight());
            else return (n.getKey().compareTo(n.getRight().getKey()) > 0) && isBST(n.getRight()) &&
                        (n.getKey().compareTo(n.getLeft().getKey()) < 0) && isBST(n.getLeft());
        }

    }
}