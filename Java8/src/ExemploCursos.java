import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Curso {
	private String nome;
	private int alunos;

	public Curso(String nome, int alunos) {
		this.nome = nome;
		this.alunos = alunos;
	}

	public String getNome() {
		return nome;
	}

	public int getAlunos() {
		return alunos;
	}
}

public class ExemploCursos {
	public static void main(String[] args) {
		List<Curso2> cursos = new ArrayList<Curso2>();
		cursos.add(new Curso2("Python", 45));
		cursos.add(new Curso2("JavaScript", 150));
		cursos.add(new Curso2("Java 8", 113));
		cursos.add(new Curso2("C", 55));
		
		cursos.sort(Comparator.comparingInt(Curso2::getAlunos));
		
		cursos.forEach(c -> System.out.println(c.getNome()));
		
		System.out.println("--------");
		
		//  Filtrando cursos com mais de 100 alunos
		cursos.stream()
		   .filter(c -> c.getAlunos() > 100)
		   .forEach(c -> System.out.println(c.getNome()));
		// O código a seguir cria um Stream<Integer> com a quantidade de alunos dos cursos e em seguida imprime todos eles
//		   .map(c -> c.getAlunos())
//		   .forEach(x -> System.out.println(x));

		
		int soma = cursos.stream()
				   .filter(c -> c.getAlunos() > 100)
				   .mapToInt(Curso2::getAlunos)
				   .sum();
		System.out.println(soma);
	}
}