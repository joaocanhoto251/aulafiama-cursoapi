package org.biolab.plataforma_curso.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Curso {
        @Id
        @GeneratedValue (strategy = GenerationType.IDENTITY)
        private long id;
        private String nome;
        private String cargaHoraria;

        @ManyToMany(mappedBy = "cursos")
        private Set<Aluno> alunos = new HashSet<>();

}

