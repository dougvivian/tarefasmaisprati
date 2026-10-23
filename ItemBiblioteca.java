// classe mae de todos os itens da biblioteca (livro, revista...)
public abstract class ItemBiblioteca {
    private int codigo;
    private String titulo;
    private boolean disponivel;

    public ItemBiblioteca(int codigo, String titulo) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.disponivel = true; // todo item novo comeca disponivel
    }

    // aqui é abstrato pq cada tipo tem um prazo diferente
    public abstract int getPrazoDias();

    // mesma coisa da multa, cada um cobra um valor
    public abstract double getMultaPorDia();

    public double calcularMulta(int diasAtraso) {
        if (diasAtraso <= 0) {
            return 0;
        }
        return diasAtraso * getMultaPorDia();
    }

    // nao fiz setDisponivel publico pq o professor falou pra nao fazer kkk
    // so a Biblioteca chama esses dois (sem public = so quem ta na mesma pasta)
    void emprestar() {
        this.disponivel = false;
    }

    void devolver() {
        this.disponivel = true;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    // pega o nome da classe pra mostrar o tipo, assim nao precisa de if
    public String getTipo() {
        return getClass().getSimpleName();
    }

    @Override
    public String toString() {
        return "[" + codigo + "] " + titulo + " (" + getTipo() + ") - prazo: " + getPrazoDias()
                + " dias, multa: R$ " + String.format("%.2f", getMultaPorDia()) + "/dia - "
                + (disponivel ? "disponivel" : "emprestado");
    }
}
