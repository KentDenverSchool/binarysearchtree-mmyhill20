/*
* BSTDriver
* Purpose: The goal of BSTDriver is
* Author/s: Morgan Myhill
* 10/4/18
* On My Honor: MM
* Collaborators: Max Lewis
*/
public class BSTDriver {
    public static void main(String[] args) {
        BinarySearchTree bs = new BinarySearchTree();

        System.out.println(bs.isEmpty());

        bs.put("Key1",1);
        bs.put("Key2",2);
        bs.put("Key3",3);
        bs.put("Key4",4);
        bs.put("Key5",5);

        System.out.println("Here is a print of the tree: ");
        System.out.println(bs.toString());
        System.out.println("This is the value of key5: expected : 5");
        System.out.println(bs.get("Key5"));
        System.out.println("does this tree contain Key3? expected: true");
        System.out.println(bs.contains("Key3"));
        System.out.println("does this tree contain Key6? expected: false");

        System.out.println(bs.contains("Key6"));
        System.out.println("Is the tree empty? Expected: false");
        System.out.println(bs.isEmpty());
        System.out.println("How large if the tree? Expected: 5");
        System.out.println(bs.size());
        System.out.println("What is the min of the tree? expected: 1");
        System.out.println(bs.min());
        System.out.println(" what is the max of the tree? expected: 5");
        System.out.println(bs.max());

        System.out.println(BinarySearchTree.isBST(bs));
        bs.root.setKey("Key33");
        //System.out.println(bs);
        System.out.println(BinarySearchTree.isBST(bs));
    }
}
