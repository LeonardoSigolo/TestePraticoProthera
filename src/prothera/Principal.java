package prothera;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Principal {

	public static void main(String[] args) {
		ArrayList<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
		
		listaFuncionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
		listaFuncionarios.add(new Funcionario("Joao", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
		listaFuncionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
		listaFuncionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
		listaFuncionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
		listaFuncionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
		listaFuncionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
		listaFuncionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
		listaFuncionarios.add(new Funcionario("Heloisa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
		listaFuncionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));
		
		listaFuncionarios.removeIf(func -> func.getNome().equals("joao"));
		
		for(Funcionario func : listaFuncionarios) {
			func.exibeFunc();
		}
		
		for(int i = 0; i < listaFuncionarios.size(); i++) {
			listaFuncionarios.get(i).aumentaSalario(10);
		}

		Map<String, ArrayList<Funcionario>> funcoes = new TreeMap<>();
		
		for(Funcionario func : listaFuncionarios) {
			funcoes.computeIfAbsent(func.getFuncao(), k -> new ArrayList<Funcionario>()).add(func);
		}
		
		for(Map.Entry<String, ArrayList<Funcionario>> entrada : funcoes.entrySet()) {
			String funcao = entrada.getKey();
			
			List<Funcionario> lista = entrada.getValue();
			
			System.out.println("====Função: " + funcao);
			
			for(Funcionario func : lista) {
				System.out.println(func.getNome());
			}
		}
		
		System.out.println("====Faz aniversário em outubro ou dezembro:");
		
		for(Funcionario func : listaFuncionarios) {
			int mesValor = func.getDataNascimento().getMonthValue();
			if(mesValor == 10 || mesValor == 12) {
				System.out.println(func.getNome());
			}
		}
		
	}

}
