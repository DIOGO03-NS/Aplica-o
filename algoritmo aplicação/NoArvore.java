import java.util.LinkedList;
import java.util.Queue;

public class NoArvore {
    private Aluno info;
    private NoArvore direita;
    private NoArvore esquerda;

    public NoArvore(){
        this.direita = null;
        this.esquerda = null;
    }

    public NoArvore search(NoArvore tree, Aluno valor){
        if(tree == null){
            return null;
        }else if(tree.info.getNota() > valor.getNota()){
            return(search(tree.esquerda, valor));
        }else if(tree.info.getNota() < valor.getNota()){
            return(search(tree.direita, valor));
        }else return tree;
    }

    public NoArvore InsereRaiz(NoArvore tree, Aluno valor){
        tree.info = valor;
        tree.direita = null;
        tree.esquerda = null;

        return tree;
    }

    /* 
    public NoArvore Insere(NoArvore tree, Aluno valor){
        if(tree == null){
            tree = new NoArvore();
            tree.info.setNota(valor.getNota());
            tree.direita = null;
            tree.esquerda = null;
        }else if(valor.getNota() < tree.info.getNota()){
            tree.esquerda = Insere(tree.esquerda, valor);
        }else tree.direita = Insere(tree.direita, valor);
        return tree;
    }
    */

    public NoArvore Insere(NoArvore tree, Aluno valor) {
        if (tree == null) {
            tree = new NoArvore();
            tree.info = new Aluno();  // Inicializa tree.info se for nulo
            tree.info.setNota(valor.getNota());
            tree.direita = null;
            tree.esquerda = null;
        } else {
            if (tree.info == null) {
                tree.info = new Aluno();  // Inicializa tree.info se for nulo
            }
            
            int comparacao = Double.compare(valor.getNota(), tree.info.getNota());
    
            if (comparacao <= 0) {
                tree.esquerda = Insere(tree.esquerda, valor);
            } else {
                tree.direita = Insere(tree.direita, valor);
            }
        }
        return tree;
    }

    public void prefixa(NoArvore tree){
        if(tree == null){
            return;
        }else{
            System.out.print(tree.info.getNome() + ", ");
            tree.prefixa(tree.esquerda);
            tree.prefixa(tree.direita);
        }

    }

    public void infixa(NoArvore tree){
        if(tree == null){
            return;
        }else{
            tree.infixa(tree.esquerda);
            System.out.print(tree.info.getNome() + ", ");
            tree.infixa(tree.direita);
            //System.out.println(tree.info);
        }
    }

    public void posfixa(NoArvore tree){
        if(tree == null){
            return;
        }else{
            tree.posfixa(tree.direita);
           // System.out.println(tree.info);
            tree.posfixa(tree.esquerda);
            System.out.print(tree.info.getNota() + ", ");
        }
    }

        
    public void byLevel(NoArvore root){
        Queue<NoArvore> level  = new LinkedList<>();
        level.add(root);
        while(!level.isEmpty()){
            NoArvore no = level.poll();
            System.out.print(no.info.getNota() + ", ");
            if(no.esquerda!= null)
            level.add(no.esquerda);
            if(no.direita!= null)
            level.add(no.direita);
        }
    }


    public Aluno getInfo() {
        return this.info;
    }

    public void setInfo(Aluno info) {
        this.info = info;
    }

    public NoArvore getDireita() {
        return this.direita;
    }

    public void setDireita(NoArvore direita) {
        this.direita = direita;
    }

    public NoArvore getEsquerda() {
        return this.esquerda;
    }

    public void setEsquerda(NoArvore esquerda) {
        this.esquerda = esquerda;
    }


    
}
