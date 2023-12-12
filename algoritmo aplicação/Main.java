import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static String gerarString(int tamanho) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = tamanho;
        Random random = new Random();
    
        String generatedString = random.ints(leftLimit, rightLimit + 1)
          .limit(targetStringLength)
          .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
          .toString();
    return(generatedString);
    }
    public static void main(String[] args) {
        Random rand = new Random();
        Aluno[] alunos = new Aluno[200];
        ArrayList<Aluno> Lista = new ArrayList<Aluno>();
        NoArvore arvore = new NoArvore();

        System.out.println("CRIANDO ALUNOS E NOTAS AUTOMATICAMENTE PARA TESTE");        
        for(int i = 0; i < 200; i++){
            Lista.add(new Aluno(gerarString(5), 1 + rand.nextDouble() * 9, i));
        }



        System.out.println("NOTAS GERADAS POR ORDEM, NÃO ORDENADAS: ");
        for(int i = 0; i < 200; i++){
            System.out.println(Lista.get(i).getNota());
            System.out.println();
        }

        MergeSort merge = new MergeSort();
        Aluno[] ordenados = Lista.toArray(new Aluno[0]); 
        merge.mergesort(ordenados);

        Lista.clear();
        for(int i = 0; i < ordenados.length; i++){
            Lista.add(i, ordenados[i]);
        }

        System.out.println("NOTAS ORDENADAS PELO MERGE SORT: ");
        for(int i = 0; i < 200; i++){
            System.out.println(Lista.get(i).getNota());
            System.out.println();
        }

        int esq = 0;
        int dir = Lista.size()-1;
        int meio = (esq+dir)/2;
        Aluno mediana = Lista.remove(meio);

        //encontrando a mediana pois será a raiz da arvore
        arvore.InsereRaiz(arvore, mediana);
        

        for(int i = 0; i < Lista.size(); i++){
            arvore.Insere(arvore, Lista.remove(i));
            System.out.println("elemento " + i + " removido");
        }
    }
}
