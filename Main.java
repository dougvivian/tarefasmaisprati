public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        // cadastrando os itens
        Livro livro1 = new Livro(1, "Dom Casmurro");
        Livro livro2 = new Livro(2, "O Cortico");
        Livro livro3 = new Livro(3, "Clean Code");
        Revista revista1 = new Revista(4, "Superinteressante");
        Revista revista2 = new Revista(5, "Mundo Estranho");

        biblioteca.cadastrarItem(livro1);
        biblioteca.cadastrarItem(livro2);
        biblioteca.cadastrarItem(livro3);
        biblioteca.cadastrarItem(revista1);
        biblioteca.cadastrarItem(revista2);
        // DVD novo, funcionou sem mudar nada na Biblioteca :)
        biblioteca.cadastrarItem(new Dvd(6, "Matrix"));

        // cadastrando os usuarios
        Aluno aluno = new Aluno("Joao");
        Professor professor = new Professor("Maria");
        biblioteca.cadastrarUsuario(aluno);
        biblioteca.cadastrarUsuario(professor);

        biblioteca.listarAcervo();
        System.out.println();

        // emprestimo que tem que dar certo
        biblioteca.emprestar(professor, livro1);

        // aluno pega 3 coisas, ate aqui tudo bem
        biblioteca.emprestar(aluno, livro2);
        biblioteca.emprestar(aluno, livro3);
        biblioteca.emprestar(aluno, revista1);

        // o 4o tem que ser recusado pq aluno so pode 3
        biblioteca.emprestar(aluno, revista2);
        System.out.println();

        // devolvendo a revista com 3 dias de atraso, tem que dar 3 reais
        biblioteca.devolver(aluno, revista1, 3);

        // agora ele pode pegar de novo
        biblioteca.emprestar(aluno, revista2);
        System.out.println();

        biblioteca.listarAcervo();
    }
}
