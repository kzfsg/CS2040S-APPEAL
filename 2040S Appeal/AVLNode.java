
public class AVLNode {

    int time;
    Student student;
    int height;
    AVLNode left;
    AVLNode right;

    public AVLNode(int time) {
        this.time = time;
        this.student = null;
        this.height = 1;
        this.left = null;
        this.right = null;
    }

    public void updateHeight() {
        int leftHeight = (left != null) ? left.height : 0;
        int rightHeight = (right != null) ? right.height : 0;
        height = Math.max(leftHeight, rightHeight) + 1;
    }

    public int getBalance() {
        int leftHeight = (left != null) ? left.height : 0;
        int rightHeight = (right != null) ? right.height : 0;
        return leftHeight - rightHeight;
    }
}
