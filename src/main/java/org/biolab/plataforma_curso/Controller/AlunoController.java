package org.biolab.plataforma_curso.Controller;

import jakarta.validation.Valid;
import org.biolab.plataforma_curso.DTO.AlunoDTO;
import org.biolab.plataforma_curso.DTO.AlunoRequest;
import org.biolab.plataforma_curso.DTO.CursoRequest;
import org.biolab.plataforma_curso.Services.AlunoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("aluno")
public class AlunoController {
    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping
    public ResponseEntity<?> criarAluno(@RequestBody AlunoDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(alunoService.criarAluno(dto));
    }

    @GetMapping
    public ResponseEntity<?> mostrarAlunos(){
        return ResponseEntity.ok(alunoService.mostrarAlunos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> mostrarAlunoPeloId(@PathVariable Long id){
        return ResponseEntity.ok(alunoService.mostrarAlunoPeloId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> alterarAluno(@PathVariable Long id, @Valid @RequestBody AlunoRequest request){
        return ResponseEntity.ok(alunoService.alterarAluno(id, request));
    }


    @DeleteMapping ("/{id}")
    public ResponseEntity<?> deletarAluno(@PathVariable long id){
        alunoService.deletarAluno(id);
        return ResponseEntity.noContent().build();
    }
}
