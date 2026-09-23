package prothera;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Pessoa {
	private String nome;
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

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getDataNascimentoFormatado() {
		DateTimeFormatter diaMesAno = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		return dataNascimento.format(diaMesAno);
	}

	public int getIdade() {
		return Period.between(this.dataNascimento, LocalDate.now()).getYears();
	}

}
