public class Aluno extends Usuario {

    public Aluno(String nome) {
        super(nome);
    }

    // aluno so pode ter 3 coisas ao mesmo tempo
    @Override
    public int getLimiteItens() {
        return 3;
    }
}
