package org.biolab.plataforma_curso.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlunoRequest {
    private String nome;
    private String email;

    private List<Long> curso_id;
}
