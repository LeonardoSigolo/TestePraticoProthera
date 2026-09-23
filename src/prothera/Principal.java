package prothera;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

public class Principal {

    private static final DecimalFormat FORMATO_BR =
            new DecimalFormat("#,##0.00", new DecimalFormatSymbols(Locale.of("pt", "BR")));

    static void main() {
        List<Funcionario> listaFuncionarios = criaListaFuncionarios();

        removerFuncionario(listaFuncionarios, "Joao");

        System.out.println("=========Salario aumentado========="); //Sei que não pediram pra imprimir mas por via das duvidas

        aumentarSalarios(listaFuncionarios);

        exibeFuncionario(listaFuncionarios);

        Map<String, ArrayList<Funcionario>> funcoes = new TreeMap<>();

        for (Funcionario func : listaFuncionarios) {
            funcoes.computeIfAbsent(func.getFuncao(), k -> new ArrayList<>()).add(func);
        }

        for (Map.Entry<String, ArrayList<Funcionario>> entrada : funcoes.entrySet()) {
            String funcao = entrada.getKey();

            List<Funcionario> lista = entrada.getValue();

            System.out.println("====Função: " + funcao);

            for (Funcionario func : lista) {
                System.out.println(func.getNome());
            }
        }

        System.out.println("====Faz aniversário em outubro ou dezembro:");

        int idadeAnterior = 0;
        Funcionario maisVelho = null;
        for (Funcionario func : listaFuncionarios) {
            int mesValor = func.getDataNascimento().getMonthValue();
            if (mesValor == 10 || mesValor == 12) {
                System.out.println(func.getNome());
            }


            if (func.getIdade() > idadeAnterior) {
                idadeAnterior = func.getIdade();
                maisVelho = func;
            }
        }
        System.out.println("====Mais velho:");
        System.out.println(maisVelho.getNome() + " tem " + maisVelho.getIdade() + " anos");

        System.out.println("====Ordem alfabética");

        List<String> nomes = new ArrayList<>();
        for (Funcionario func : listaFuncionarios) {
            nomes.add(func.getNome());
        }
        nomes.sort(null);
        for (String nome : nomes) {
            System.out.println(nome);
        }

        System.out.println("====Salário total");

        BigDecimal salarioTotal = BigDecimal.ZERO;
        for (Funcionario func : listaFuncionarios) {
            salarioTotal = salarioTotal.add(func.getSalario());
        }
        DecimalFormat df = new DecimalFormat("#,##0.00", new DecimalFormatSymbols(Locale.of("pt", "BR")));
        System.out.println(df.format(salarioTotal));

        System.out.println("====Salários minimos");
        for (Funcionario func : listaFuncionarios) {
            System.out.println(func.formataNumeros(func.calculaSalariosMinimos(func.getSalario())));
        }
    }

    private static List<Funcionario> criaListaFuncionarios() {

        List<Funcionario> lista = new ArrayList<>();

        lista.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        lista.add(new Funcionario("Joao", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        lista.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
        lista.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        lista.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
        lista.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        lista.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
        lista.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
        lista.add(new Funcionario("Heloisa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
        lista.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));

        return lista;
    }

    private static void removerFuncionario(List<Funcionario> lista, String nome) {
        lista.removeIf(func -> func.getNome().equals(nome));
    }

    private static void exibeFuncionario(List<Funcionario> lista) {
        for (Funcionario func : lista) {
            System.out.println(func.getNome());
        }
    }

    private  static void aumentarSalarios(List<Funcionario> lista){
        for (Funcionario func : lista) {
            func.aumentaSalario(10);
        }
    }
}
