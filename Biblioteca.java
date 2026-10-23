public class Biblioteca {
    // arrays de tamanho fixo como pediu na tarefa
    private ItemBiblioteca[] acervo = new ItemBiblioteca[50];
    private Usuario[] usuarios = new Usuario[50];
    private int totalItens = 0;
    private int totalUsuarios = 0;

    public boolean cadastrarItem(ItemBiblioteca item) {
        if (totalItens >= acervo.length) {
            System.out.println("Acervo cheio, nao da pra cadastrar " + item.getTitulo());
            return false;
        }
        acervo[totalItens] = item;
        totalItens++;
        return true;
    }

    public boolean cadastrarUsuario(Usuario usuario) {
        if (totalUsuarios >= usuarios.length) {
            System.out.println("Nao cabe mais usuario: " + usuario.getNome());
            return false;
        }
        usuarios[totalUsuarios] = usuario;
        totalUsuarios++;
        return true;
    }

    public boolean emprestar(Usuario usuario, ItemBiblioteca item) {
        if (!item.isDisponivel()) {
            System.out.println("RECUSADO: " + item.getTitulo() + " ja esta emprestado");
            return false;
        }
        // aqui que entra o limite de cada usuario
        if (!usuario.podeEmprestar()) {
            System.out.println("RECUSADO: " + usuario.getNome() + " ja atingiu o limite de "
                    + usuario.getLimiteItens() + " itens");
            return false;
        }
        item.emprestar();
        usuario.adicionarEmprestimo();
        System.out.println("OK: " + usuario.getNome() + " pegou " + item.getTitulo()
                + " (devolver em " + item.getPrazoDias() + " dias)");
        return true;
    }

    // retorna o valor da multa (0 se devolveu no prazo)
    public double devolver(Usuario usuario, ItemBiblioteca item, int diasAtraso) {
        if (item.isDisponivel()) {
            System.out.println("Esse item nem estava emprestado: " + item.getTitulo());
            return 0;
        }
        item.devolver();
        usuario.removerEmprestimo();
        double multa = item.calcularMulta(diasAtraso);
        System.out.println("DEVOLVIDO: " + item.getTitulo() + " por " + usuario.getNome()
                + " - multa: R$ " + String.format("%.2f", multa));
        return multa;
    }

    // percorre tudo de uma vez, sem if, o polimorfismo resolve
    public void listarAcervo() {
        System.out.println("=== ACERVO ===");
        for (int i = 0; i < totalItens; i++) {
            System.out.println(acervo[i]);
        }
    }
}
