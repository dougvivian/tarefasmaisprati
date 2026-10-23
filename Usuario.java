// classe mae do aluno e do professor
public abstract class Usuario {
    private String nome;
    private int quantidadeEmprestada;

    public Usuario(String nome) {
        this.nome = nome;
        this.quantidadeEmprestada = 0;
    }

    // cada tipo de usuario pode pegar uma quantidade diferente
    public abstract int getLimiteItens();

    public boolean podeEmprestar() {
        return quantidadeEmprestada < getLimiteItens();
    }

    // igual no item, so a Biblioteca mexe nisso
    void adicionarEmprestimo() {
        quantidadeEmprestada++;
    }

    void removerEmprestimo() {
        if (quantidadeEmprestada > 0) {
            quantidadeEmprestada--;
        }
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidadeEmprestada() {
        return quantidadeEmprestada;
    }
}
