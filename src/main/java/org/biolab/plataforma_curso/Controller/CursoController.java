package org.biolab.plataforma_curso.Controller;

import jakarta.validation.Valid;
import org.biolab.plataforma_curso.DTO.CursoDTO;
import org.biolab.plataforma_curso.DTO.CursoRequest;
import org.biolab.plataforma_curso.Repositories.AlunoRepository;
import org.biolab.plataforma_curso.Repositories.CursoRepository;
import org.biolab.plataforma_curso.Services.AlunoService;
import org.biolab.plataforma_curso.Services.CursoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("curso")
public class CursoController {
    private final AlunoService alunoService;
    private final CursoService cursoService;

    public CursoController(AlunoService alunoService, CursoService cursoService) {
        this.alunoService = alunoService;
        this.cursoService = cursoService;
    }

    @PostMapping
    public ResponseEntity<?> criarCurso(@RequestBody CursoDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(cursoService.criarCurso(dto));
    }

    @GetMapping
    public ResponseEntity<?> mostrarCursos(){
        return ResponseEntity.ok(cursoService.mostrarCursos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> mostrarCursoPeloId(@PathVariable Long id){
        return ResponseEntity.ok(cursoService.mostrarCursoPeloId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> alterarCurso(@PathVariable Long id,
                                          @Valid @RequestBody CursoRequest request){
        return ResponseEntity.ok(cursoService.alterarCurso(id, request));
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<?> deletarCurso(@PathVariable long id){
        cursoService.deletarCurso(id);
        return ResponseEntity.noContent().build();
    }
}
