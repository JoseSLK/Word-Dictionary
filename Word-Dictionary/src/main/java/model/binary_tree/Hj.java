package model.binary_tree;

public class Hj {
    public static void main(String[] args) {
        BinaryTree<Integer> bts = new BinaryTree<>((Integer::compare));

        bts.addNode(50);
        bts.addNode(10);
        bts.addNode(69);
        bts.addNode(5);
        bts.addNode(34);
        bts.addNode(57);
        bts.addNode(95);
        bts.addNode(18);
        bts.addNode(40);
        bts.addNode(63);
        bts.addNode(120);
        bts.addNode(100);
       // bts.addNode(96);

        //Recorre por niveles el arbol
        //bts.listAmplitudeTop().forEach(System.out::println);

        //Recorre los nodos en orden de isquierda a derecha
        //bts.listPresort().forEach(System.out::println);

        //Los recorre y guarda organizados
         bts.listInsort().forEach(System.out::println);

        //Ultimo de izquierda a derecha
        //bts.listPosort().forEach(System.out::println);

        //Peso de arbol (Numero de nodos)
        //System.out.println(bts.weigthTree());
        //System.out.println(bts.heightTree());
        //System.out.println(bts.heightNode(bts.findNode(95)));
        //System.out.println(bts.gradeNode(bts.findNode(69)));
        //System.out.println(bts.isLeaf(bts.findNode(18)));
    }
}
