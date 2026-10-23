public class Professor extends Usuario {

    public Professor(String nome) {
        super(nome);
    }

    // professor tem mais moral, pode pegar 5
    @Override
    public int getLimiteItens() {
        return 5;
    }
}
