package org.biolab.plataforma_curso.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursoRequest {
    private String nome;
    private String cargaHoraria;

    private List<Long> aluno_id;
}
