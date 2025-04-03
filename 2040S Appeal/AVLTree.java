
public class AVLTree {

    private AVLNode root;

    public AVLTree() {
        root = null;
    }

    public AVLNode getRoot() {
        return root;
    }

    private AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;

        x.right = y;
        y.left = T2;

        y.updateHeight();
        x.updateHeight();

        return x;
    }

    private AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;

        y.left = x;
        x.right = T2;

        x.updateHeight();
        y.updateHeight();

        return y;
    }

    public void insert(int time, Student student) {
        root = insert(root, time, student);
    }

    private AVLNode insert(AVLNode node, int time, Student student) {
        if (node == null) {
            AVLNode newNode = new AVLNode(time);
            newNode.student = student;
            return newNode;
        }

        if (time < node.time) {
            node.left = insert(node.left, time, student);
        } else if (time > node.time) {
            node.right = insert(node.right, time, student);
        } else {
            // Same time, update student if new student arrives earlier
            if (student.getDistanceAtTime(time) < node.student.getDistanceAtTime(time)) {
                node.student = student;
            }
            return node;
        }

        node.updateHeight();
        int balance = node.getBalance();

        // Left Left Case
        if (balance > 1 && time < node.left.time) {
            return rightRotate(node);
        }

        // Right Right Case
        if (balance < -1 && time > node.right.time) {
            return leftRotate(node);
        }

        // Left Right Case
        if (balance > 1 && time > node.left.time) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && time < node.right.time) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    public Student findNextStudent(int time) {
        return findNextStudent(root, time);
    }

    private Student findNextStudent(AVLNode node, int time) {
        if (node == null) {
            return null;
        }

        if (node.time >= time) {
            Student leftStudent = findNextStudent(node.left, time);
            if (leftStudent != null) {
                return leftStudent;
            }
            return node.student;
        }

        return findNextStudent(node.right, time);
    }
}
