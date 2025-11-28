
public boolean search(E e) {
    TreeNode current = root;
    while (current != null) {
        int cmp = c.compare(e, current.element);
        if (cmp < 0) {
            current = current.left;
        } else if (cmp > 0) {
            current = current.right;
        } else {
            return true;
        }
    }
    return false;
}

private void inorder(TreeNode n) {
    if (n == null) return;
    inorder(n.left);
    System.out.print(n.element + " ");
    inorder(n.right);
}

private void preorder(TreeNode n) {
    if (n == null) return;
    System.out.print(n.element + " ");
    preorder(n.left);
    preorder(n.right);
}

private void postorder(TreeNode n) {
    if (n == null) return;
    postorder(n.left);
    postorder(n.right);
    System.out.print(n.element + " ");
}