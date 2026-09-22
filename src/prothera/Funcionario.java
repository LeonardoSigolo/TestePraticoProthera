package prothera;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.util.Locale;

public class Funcionario extends Pessoa{
	BigDecimal salario;
	String funcao;
	public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {		
		super(nome, dataNascimento);
		this.salario = salario;
		this.funcao = funcao;
	}
	
	public void aumentaSalario(float porcentagem) {
		BigDecimal salarioAtualizado = BigDecimal.valueOf(salario.floatValue() * (porcentagem / 100 + 1));
		setSalario(salarioAtualizado);
	}
	public void exibeFunc() {
		System.out.println(this.getNome() + " " + this.getDataNascimentoFormatado() + " " + this.formataNumeros(this.getSalario()) + " " + this.getFuncao());
	}
	
	public String formataNumeros(BigDecimal salario) {
		DecimalFormat df = new DecimalFormat("#,##0.00", new DecimalFormatSymbols(Locale.of("pt", "BR")));
		return df.format(salario);
	}
	
	public BigDecimal calculaSalariosMinimos(BigDecimal salario) {
		int salarioMinimo = 1212;
		BigDecimal resultado = BigDecimal.valueOf(salario.floatValue() / salarioMinimo);
		return resultado;
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
