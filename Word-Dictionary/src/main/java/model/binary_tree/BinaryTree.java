package model.binary_tree;

import java.util.*;

public class BinaryTree<T> {
    private Comparator<T> comparator;
    private int aux;
    private TreeNode<T> root;
    private ArrayList<T> list;
    private ArrayList<TreeNode<T>> listAux;

    public BinaryTree(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public void addNode(T info){
        if ( isEmpty() ){
            root = new TreeNode<>(info);
            return;
        }
        TreeNode<T> node = new TreeNode<>( info );
        TreeNode<T> aux = root;
        TreeNode<T> prev = null;

        while ( aux != null ){
            prev = aux;
            aux = comparator.compare(info, aux.getInfo()) < 0 ? aux.getLeft() : aux.getRight();
        }
        if (comparator.compare(info, prev.getInfo()) < 0){
            prev.setLeft(node);
        }else {
            prev.setRight(node);
        }

    }
    public TreeNode<T> findNode(T info){
        TreeNode<T> aux = root;

        while ( aux != null && comparator.compare(info, aux.getInfo()) != 0 ){
            aux = comparator.compare(info, aux.getInfo()) < 0 ? aux.getLeft() : aux.getRight();
        }
        return aux;
    }

    public int heightTree(){
        return height(root);
    }

    public int height(TreeNode<T> node){
        if (node == null)return -1;

        int leftHeight = height(node.getLeft());
        int rightHeight = height(node.getRight());

        return 2 + Math.max(leftHeight, rightHeight);
    }
    public int heightNode(TreeNode<T> node){
        if (node == null)return -1;

        int leftHeight = heightNode(node.getLeft());
        int rightHeight = heightNode(node.getRight());

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public int weigthTree(){
        return weight( root );
    }
    private int weight( TreeNode<T> node) {
        if (node == null)return 0;

        int leftHeight = weight(node.getLeft());
        int rightHeight = weight(node.getRight());

        return 1 + leftHeight + rightHeight;
    }
    public int levelNode( TreeNode<T> node) {
        return node == root ? 0 : levelNode(findFather(node)) + 1;
    }
    public boolean isLeaf(TreeNode<T> node){
        return node != null && node.getLeft() == null && node.getRight() == null;
    }
    public byte gradeNode(TreeNode<T> node){
        int count = 0;
        if(node == null) return -1;

        if( node.getLeft() != null ) count++;
        if( node.getRight() != null ) count++;

        return (byte) count;
    }
    public ArrayList<T> listPresort(){
        list = new ArrayList<>();
        presort(root);
        return list;
    }
    private void presort(TreeNode<T> node){
        if ( node == null) return;
        list.add(node.getInfo());
        presort(node.getLeft());
        presort(node.getRight());
    }
    public ArrayList<T> listInsort(){
        list = new ArrayList<>();
        insort( root );
        return list;
    }
    private void insort(TreeNode<T> node){
        if ( node == null ) return;
        insort( node.getLeft() );
        list.add(node.getInfo());
        insort(node.getRight());
    }
    private void insortNode(TreeNode<T> node){
        if ( node == null ) return;
        insortNode( node.getLeft() );
        listAux.add(node);
        insortNode(node.getRight());
    }
    public ArrayList<T> listPosort(){
        list = new ArrayList<>();
        posort( root );
        return list;
    }
    public void posort(TreeNode<T> node){
        if ( node == null ) return;
        posort( node.getLeft() );
        posort(node.getRight());
        list.add(node.getInfo());
    }
    public ArrayList<T> listAmplitudeDown(){
        if( root == null ) {
            return null;
        }
        list = new ArrayList<>();
        ArrayDeque<TreeNode<T>> tail = new ArrayDeque<>();
        System.out.println("This is root: "+ root.getInfo());

        tail.add( root );

        while ( !tail.isEmpty() ) {
            TreeNode<T> aux = tail.poll();
            if ( aux.getLeft() != null ) {
                tail.add( aux.getLeft() );
            }

            if ( aux.getRight() != null ) {
                tail.add( aux.getRight() );
            }

            list.add( aux.getInfo() );
        }
        return list;
    }
    public ArrayList<T> listAmplitudeTop(){
        Stack<T> out = new Stack<>();
        list = new ArrayList<>();
        ArrayDeque<TreeNode<T>> tail = new ArrayDeque<>();
        tail.add( root );
        TreeNode<T> aux = null;
        while ( !tail.isEmpty() ) {
            aux = tail.poll();
            if( aux.getLeft() != null ) {
                tail.add(aux.getLeft());
            }
            if( aux.getRight() != null ) {
                tail.add( aux.getRight() );
            }
            out.push(aux.getInfo());
        }
        while( !out.isEmpty() ){
            list.add(out.pop());
        }
        return list;
    }
    public TreeNode<T> findFather(TreeNode<T> node){
        if ( node == root ) return null;
        TreeNode<T> aux = root;
        while (aux.getLeft() != node && aux.getRight() != node ){
            aux = comparator.compare(node.getInfo(), aux.getInfo()) < 0 ? aux.getLeft() : aux.getRight();
        }
        return aux;
    }
    public T deleteNode(TreeNode<T> node){
        switch (gradeNode(node)){
            case 0: return deleteLeaf(node);
            case 1: return deleteWithSon(node);
            default: return deleteWithSons(node);
        }
    }
    private T deleteLeaf(TreeNode<T> node){
        TreeNode<T> aux = node;
        TreeNode<T> position = findFather(node);

        if( position == null ){
            root = null;
        }else if( position.getRight() == node){
            position.setRight(null);
        }else if( position.getLeft() == node ){
            position.setLeft(null);
        }
        return aux.getInfo();
    }
    private T deleteWithSon(TreeNode<T> node){
        TreeNode<T> position = findFather(node);

        TreeNode<T> left = node.getLeft();
        TreeNode<T> right = node.getRight();

        if ( position != null ){
            if( position.getRight() == node ){
                position.setRight(left != null? left:right);
            }else if( position.getLeft() == node ){
                position.setLeft(left != null? left: right);
            }
        }

        return node.getInfo();
    }
    private T deleteWithSons(TreeNode<T> node){
        TreeNode<T> fatherAux = findFather(node);
        TreeNode<T> substitute = null;
        listAux= new ArrayList<>();
        insortNode( root );

        for (int i = 0; i < listAux.size(); i++){
            if( listAux.get(i) == node){
                substitute = listAux.get(i+1);
                break;
            }
        }

        if (substitute != null) {
            if (fatherAux == null) {
                root = substitute;
            } else if (fatherAux.getLeft() == node) {
                fatherAux.setLeft(substitute);
            } else {
                fatherAux.setRight(substitute);
            }

            substitute.setLeft(node.getLeft());

            if (substitute != node.getRight()) {
                substitute.setRight(node.getRight());
            }

            TreeNode<T> substituteParent = findFather(substitute);
            if (substituteParent != null) {
                if (substituteParent.getLeft() == substitute) {
                    substituteParent.setLeft(null);
                } else {
                    substituteParent.setRight(null);
                }
            }
        }

        return node.getInfo();
    }
}
