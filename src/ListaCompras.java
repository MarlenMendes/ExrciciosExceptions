import org.jetbrains.annotations.NotNull;

import java.util.*;

public class ListaCompras {

    public static void main(String[] args) {
        List<Alimento> listaCompras = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Digite o tipo de alimento (VERDURA, LEGUME, GRÃOS, OUTROS) ou 'sair' para encerrar:");
            String tipo = scanner.nextLine();

            if (tipo.equalsIgnoreCase("sair")) {
                break;
            }

            try {
                Alimento alimento = criarAlimento(tipo);
                listaCompras.add(alimento);
            } catch (IllegalArgumentException | UnsupportedOperationException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Lista de compras:");
        for (Alimento alimento : listaCompras) {
            System.out.println(alimento.getNome() + " - " + alimento.getQuantidade());
        }

        int totalVerduras = contactAliments(listaCompras, "VERDURA");
        int totalLegumes = contactAliments(listaCompras, "LEGUME");
        int totalGraos = contactAliments(listaCompras, "GRÃOS");
        int totalOutros = contactAliments(listaCompras, "OUTROS");

        System.out.println("Quantidade de alimentos a serem comprados:");
        System.out.println("VERDURA: " + totalVerduras);
        System.out.println("LEGUME: " + totalLegumes);
        System.out.println("GRÃOS: " + totalGraos);
        System.out.println("OUTROS: " + totalOutros);
    }

    @org.jetbrains.annotations.NotNull
    @org.jetbrains.annotations.Contract("_ -> new")
    public static Alimento criarAlimento(String tipo) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a quantidade do alimento:");
        String quantidadeStr = scanner.nextLine();

        if (quantidadeStr.isEmpty()) {
            throw new UnsupportedOperationException("Não é permitido inserir valor vazio");
        }

        double quantidade;
        try {
            quantidade = Double.parseDouble(quantidadeStr);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("A quantidade deve ser um número válido");
        }

        if (tipo.equalsIgnoreCase("VERDURA") || tipo.equalsIgnoreCase("GRÃOS")) {
            if (quantidade % 1 == 0) {
                throw new NumberFormatException("Para " + tipo + ", a quantidade deve ser informada com ponto");
            }
        } else {
            if (quantidade % 1 != 0) {
                throw new NumberFormatException("Para " + tipo + ", a quantidade deve ser informada em unidades inteiras");
            }
        }

        System.out.println("Digite o nome do alimento:");
        String nome = scanner.nextLine();

        if (nome.isEmpty()) {
            throw new UnsupportedOperationException("Não é permitido inserir nome vazio");
        }

        return new Alimento(nome, quantidade);
    }

    public static int contactAliments(@NotNull List<Alimento> lista, String tipo) {
        int total = 0;
        for (Alimento alimento : lista) {
            if (alimento.getTipo().equalsIgnoreCase(tipo)) {
                total++;
            }
        }
        return total;
    }
}

class Alimento {
    private String nome;
    private double quantidade;
    private String tipo;

    public Alimento(String nome, double quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
        if (quantidade % 1 == 0) {
            this.tipo = quantidade == (int) quantidade ? "LEGUME" : "OUTROS";
        } else {
            this.tipo = quantidade == (int) quantidade ? "VERDURA" : "GRÃOS";
        }
    }

    public String getNome() {
        return nome;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public String getTipo() {
        return tipo;
    }
}