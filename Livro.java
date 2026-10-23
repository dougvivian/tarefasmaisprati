public class Livro extends ItemBiblioteca {

    public Livro(int codigo, String titulo) {
        super(codigo, titulo);
    }

    // livro fica 14 dias
    @Override
    public int getPrazoDias() {
        return 14;
    }

    // 50 centavos por dia de atraso
    @Override
    public double getMultaPorDia() {
        return 0.50;
    }
}
