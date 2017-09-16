boolean checkBST(Node root) 
{
  return BST(root, -1, -1);
}

boolean BST(Node root, int valLow, int valHigh) 
{
  if(root == null) 
  {
    return true;
  } 
  else if (valLow >= 0 && root.data <= valLow) 
  {
    return false;
  } 
  else if (valHigh >= 0 && root.data >= valHigh) 
  {
    return false;
  } 

  return (BST(root.left,valLow,root.data) && isBST(root.right,root.data,valHigh));
}
