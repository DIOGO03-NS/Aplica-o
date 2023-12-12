public class Aluno{
    private String nome;
    private double nota;
    private int matricula;

    public Aluno(){
    }

    public Aluno(String nome, double nota, int matricula){
        this.nome = nome;
        this.nota = nota;
        this.matricula = matricula;
    }

    public Aluno(String nome, double nota){
        this.nome = nome;
        this.nota = nota;
    }


    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNota() {
        return this.nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public int getMatricula() {
        return this.matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

}