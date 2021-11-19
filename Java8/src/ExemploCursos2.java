import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Curso2 {
	private String nome;
	private int alunos;

	public Curso2(String nome, int alunos) {
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

public class ExemploCursos2 {
	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));
		
		cursos.sort(Comparator.comparingInt(Curso::getAlunos));
		
		cursos.forEach(c -> System.out.println(c.getNome()));
		
		System.out.println("--------");
		
		// soma dos alunos em cursos que tenham mais de 100 alunos
		int soma = cursos.stream()
				   .filter(c -> c.getAlunos() > 100)
				   .mapToInt(Curso::getAlunos)
				   .sum();
		System.out.println("A soma dos alunos é: " + soma);
		
		// um curso que tenha mais de 100 alunos
//		Optional<Curso> optionalCurso = cursos.stream()
//		   .filter(c -> c.getAlunos() >= 100)
//		   .findAny();
//		
//		Curso curso = optionalCurso.orElse(null);
//		System.out.println(curso.getNome());
		
		cursos.stream()
		   .filter(c -> c.getAlunos() > 100)
		   .findAny()
		   .ifPresent(c -> System.out.println("Um curso qualquer com mais de 100 alunos: " + c.getNome()));
		
		cursos = cursos.stream()
			.filter(c -> c.getAlunos() > 100)
			.collect(Collectors.toList());
		
		cursos.stream()
			.forEach(c -> System.err.println("Cursos filtrados anteriormente: " + c.getNome()));

	}
}