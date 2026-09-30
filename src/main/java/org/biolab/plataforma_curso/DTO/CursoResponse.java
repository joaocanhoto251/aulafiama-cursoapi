package org.biolab.plataforma_curso.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursoResponse {
    private Long id;
    private String nome;
    private String cargaHoraria;

    private List<Long> aluno_id;
}
