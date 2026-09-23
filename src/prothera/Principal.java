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

    private static final DecimalFormat FORMATO_BR = new DecimalFormat("#,##0.00", new DecimalFormatSymbols(Locale.of("pt", "BR")));

    static void main() {
        List<Funcionario> listaFuncionarios = criaListaFuncionarios();

        removerFuncionario(listaFuncionarios, "Joao");

        System.out.println("=========Salario aumentado=========");

        aumentarSalarios(listaFuncionarios, 10);

        exibeFuncionario(listaFuncionarios);

        exibePorFuncao(listaFuncionarios);

        mesAniversario(listaFuncionarios);

        maisVelho(listaFuncionarios);

        ordemAlfabetica(listaFuncionarios);

        salariototal(listaFuncionarios);

        salariosminimos(listaFuncionarios);
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

    private static void aumentarSalarios(List<Funcionario> lista, double porcentagem) {
        for (Funcionario func : lista) {
            func.aumentaSalario(porcentagem);
        }
    }

    private static void exibePorFuncao(List<Funcionario> lista) {
        Map<String, ArrayList<Funcionario>> funcoes = new TreeMap<>();

        for (Funcionario func : lista) {
            funcoes.computeIfAbsent(func.getFuncao(), k -> new ArrayList<>()).add(func);
        }

        for (Map.Entry<String, ArrayList<Funcionario>> entrada : funcoes.entrySet()) {

            System.out.println("====Função: " + entrada.getKey());

            for (Funcionario func : entrada.getValue()) {
                System.out.println(func.getNome());
            }
        }
    }

    private static void mesAniversario(List<Funcionario> lista) {
        System.out.println("====Faz aniversário em outubro ou dezembro:");
        for (Funcionario func : lista) {
            int mesValor = func.getDataNascimento().getMonthValue();
            if (mesValor == 10 || mesValor == 12) {
                System.out.println(func.getNome());
            }
        }
    }

    private static void maisVelho(List<Funcionario> lista) {
        System.out.println("====Mais velho:");
        Funcionario maisVelho = null;
        for (Funcionario func : lista) {
            if (maisVelho == null || func.getIdade() > maisVelho.getIdade()) {
                maisVelho = func;
            }
        }
        System.out.println(maisVelho.getNome() + " tem " + maisVelho.getIdade() + " anos");
    }

    private static void ordemAlfabetica(List<Funcionario> lista) {
        System.out.println("====Ordem alfabética");

        List<String> nomes = new ArrayList<>();
        for (Funcionario func : lista) {
            nomes.add(func.getNome());
        }
        nomes.sort(null);
        for (String nome : nomes) {
            System.out.println(nome);
        }
    }

    private static void salariototal(List<Funcionario> lista){
        System.out.println("====Salário total");

        BigDecimal salarioTotal = BigDecimal.ZERO;
        for (Funcionario func : lista) {
            salarioTotal = salarioTotal.add(func.getSalario());
        }
        System.out.println(FORMATO_BR.format(salarioTotal));
    }

    private static void salariosminimos(List<Funcionario> lista){
        System.out.println("====Salários minimos");
        for (Funcionario func : lista) {
            System.out.println(func.formataNumeros(func.calculaSalariosMinimos(func.getSalario())));
        }
    }
}
