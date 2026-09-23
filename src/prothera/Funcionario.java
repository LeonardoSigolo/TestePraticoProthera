package prothera;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.util.Locale;

public class Funcionario extends Pessoa {

    private static final BigDecimal SALARIO_MINIMO = BigDecimal.valueOf(1212);
    private static final DecimalFormat FORMATO_BR = new DecimalFormat("#,##0.00", new DecimalFormatSymbols(Locale.of("pt", "BR")));

    private BigDecimal salario;
    private String funcao;

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public void aumentaSalario(double porcentagem) {
        BigDecimal fator = BigDecimal.ONE.add(BigDecimal.valueOf(porcentagem).divide(BigDecimal.valueOf(100)));
        this.salario = salario.multiply(fator).setScale(2, RoundingMode.HALF_UP);
    }

    public void exibeFunc() {
        System.out.println(getNome() + " " + getDataNascimentoFormatado() + " " + formataNumeros(getSalario()) + " " + getFuncao());
    }

    public String formataNumeros(BigDecimal valor) {
        return FORMATO_BR.format(valor);
    }

    public BigDecimal calculaSalariosMinimos(BigDecimal salario) {
        return salario.divide(SALARIO_MINIMO, MathContext.DECIMAL64);
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
}
