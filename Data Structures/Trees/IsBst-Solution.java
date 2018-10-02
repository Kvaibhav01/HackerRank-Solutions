//Data Structure Trees Problem https://www.hackerrank.com/challenges/is-binary-search-tree/problem
boolean checkBST(Node root) 
{
    return checkBSTUtil(root, null, null);
}
private boolean checkBSTUtil(Node root, Node min, Node max)
{
    if(root == null){
        return true;
    }
    if(min != null && min.data >= root.data){
        return false;
    }
    if(max != null && root.data >= max.data){
        return false;
    }
    // recur for left subtree with  max = root & for right subtree with min = root
    return checkBSTUtil(root.left, min, root) && checkBSTUtil(root.right, root, max);
}