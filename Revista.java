public class Revista extends ItemBiblioteca {

    public Revista(int codigo, String titulo) {
        super(codigo, titulo);
    }

    // revista é so uma semana
    @Override
    public int getPrazoDias() {
        return 7;
    }

    // revista atrasada sai mais caro, 1 real por dia
    @Override
    public double getMultaPorDia() {
        return 1.00;
    }
}
