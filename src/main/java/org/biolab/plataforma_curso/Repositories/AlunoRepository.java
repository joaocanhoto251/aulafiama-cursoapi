package org.biolab.plataforma_curso.Repositories;

import org.biolab.plataforma_curso.Entities.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
