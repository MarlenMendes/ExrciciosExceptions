import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.*;

class ConversorMoedas {

    private static final BigDecimal COTACAO_DOLAR_AMERICANO = new BigDecimal("5.25");
    private static final BigDecimal COTACAO_DOLAR_CANADENSE = new BigDecimal("4.15");
    private static final BigDecimal COTACAO_EURO = new BigDecimal("6.15");
    private static final BigDecimal COTACAO_LIBRA_ESTERLINA = new BigDecimal("7.50");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Boas vindas ao conversor de moedas");

        while (true) {
            try {
                System.out.println("Digite o tipo de moeda que deseja converter:");
                System.out.println("Opções de moeda: Dólar americano, Dólar canadense, Euro, Libra Esterlina");
                String moeda = scanner.nextLine();

                validarMoeda(moeda);

                System.out.println("O sistema converte apenas para Real (R$).");
                System.out.println("Digite o valor a ser convertido:");

                String valorStr = scanner.nextLine();
                BigDecimal valor = validarValor(valorStr);

                BigDecimal valorConvertido = converterMoeda(moeda, valor);

                String moedaConvertida = "Real (R$)";
                String cotacaoDia = LocalDate.now().toString();

                NumberFormat formatter = new DecimalFormat("#,##0.00");
                String valorFormatado = formatter.format(valorConvertido);

                System.out.println("A " + moeda + " na cotação de hoje " + cotacaoDia +
                        " está em " + obterCotacaoMoeda(moeda) + ", o valor que pediu para converter de " +
                        valorStr + " em reais é R$" + valorFormatado);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("Deseja fazer outra conversão? (s/n)");
            String opcao = scanner.nextLine();

            if (!opcao.equalsIgnoreCase("s")) {
                break;
            }
        }
    }

    public static void validarMoeda(String moeda) {
        if (!moeda.equalsIgnoreCase("Dólar americano") &&
                !moeda.equalsIgnoreCase("Dólar canadense") &&
                !moeda.equalsIgnoreCase("Euro") &&
                !moeda.equalsIgnoreCase("Libra Esterlina")) {
            throw new IllegalArgumentException("Tipo de moeda inválido");
        }
    }

    public static BigDecimal validarValor(String valorStr) {
        if (valorStr.isEmpty()) {
            throw new NumberFormatException("Para moeda, o valor monetário deve ser um número decimal");
        }

        BigDecimal valor = new BigDecimal(valorStr);

        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new NumberFormatException("Valor inválido, por favor, tente novamente");
        }

        return valor;
    }

    public static BigDecimal converterMoeda(String moeda, BigDecimal valor) {
        BigDecimal cotacaoMoeda = obterCotacaoMoeda(moeda);
        return valor.multiply(cotacaoMoeda);
    }

    public static BigDecimal obterCotacaoMoeda(String moeda) {
        switch (moeda) {
            case "Dólar americano":
                return COTACAO_DOLAR_AMERICANO;
            case "Dólar canadense":
                return COTACAO_DOLAR_CANADENSE;
            case "Euro":
                return COTACAO_EURO;
            case "Libra Esterlina":
                return COTACAO_LIBRA_ESTERLINA;
            default:
                throw new IllegalArgumentException("Tipo de moeda inválido");
        }
    }
}