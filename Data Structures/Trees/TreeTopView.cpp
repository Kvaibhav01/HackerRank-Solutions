//Tree_Top_View: https://www.hackerrank.com/challenges/tree-top-view

void lsolve(node * ptr){
    if(ptr == NULL)
        return;
    
    lsolve(ptr->left);
    cout<<ptr->data<<" ";
}


void rsolve(node * ptr){
    if(ptr == NULL)
        return;
    cout<<ptr->data<<" ";
    rsolve(ptr->right);
}

void topView(node * root) {
    lsolve(root->left);
    cout<<root->data<<" ";
    rsolve(root->right);
    
}
