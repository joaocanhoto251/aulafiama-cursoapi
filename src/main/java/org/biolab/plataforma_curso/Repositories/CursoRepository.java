package org.biolab.plataforma_curso.Repositories;

import org.biolab.plataforma_curso.Entities.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso,Long> {

}
