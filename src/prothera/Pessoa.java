package prothera;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pessoa {
	String nome;
	private LocalDate dataNascimento;
	
	public Pessoa(String nome, LocalDate dataNascimento) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataNascimentoFormatado() {
		DateTimeFormatter diaMesAno = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		String formatado = dataNascimento.format(diaMesAno);
		
		return formatado;
	}
	
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
