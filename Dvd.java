// teste da dica 10: categoria nova sem mexer em nenhum metodo que ja existia
public class Dvd extends ItemBiblioteca {

    public Dvd(int codigo, String titulo) {
        super(codigo, titulo);
    }

    // inventei esses valores, dvd é so 3 dias
    @Override
    public int getPrazoDias() {
        return 3;
    }

    @Override
    public double getMultaPorDia() {
        return 2.00;
    }
}
