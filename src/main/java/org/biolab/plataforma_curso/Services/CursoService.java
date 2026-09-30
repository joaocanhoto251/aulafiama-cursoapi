package org.biolab.plataforma_curso.Services;

import org.biolab.plataforma_curso.DTO.CursoDTO;
import org.biolab.plataforma_curso.DTO.CursoRequest;
import org.biolab.plataforma_curso.DTO.CursoResponse;
import org.biolab.plataforma_curso.Entities.Aluno;
import org.biolab.plataforma_curso.Entities.Curso;
import org.biolab.plataforma_curso.Repositories.AlunoRepository;
import org.biolab.plataforma_curso.Repositories.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {
    private final CursoRepository cursoRepository;
    private final AlunoRepository alunoRepository;

    public CursoService(CursoRepository cursoRepository, AlunoRepository alunoRepository) {
        this.cursoRepository = cursoRepository;
        this.alunoRepository = alunoRepository;
    }

    public String criarCurso(CursoDTO dto){
        Curso curso = new Curso();

        curso.setNome(dto.getNome());
        curso.setCargaHoraria(dto.getCargaHoraria());

        cursoRepository.save(curso);
        return "Curso criado com sucesso!";
    }

    public List<CursoResponse> mostrarCursos() {
        return cursoRepository.findAll().stream().map(curso -> new CursoResponse(
                curso.getId(),
                curso.getNome(),
                curso.getCargaHoraria(),
                curso.getAlunos()
                        .stream()
                        .map(Aluno::getId)
                        .toList()
        )).toList();
    }

    public CursoDTO mostrarCursoPeloId(Long id){
        Curso curso = cursoRepository.findById(id).orElseThrow();
        CursoDTO dto = new CursoDTO();

        dto.setId(curso.getId());
        dto.setNome(curso.getNome());
        dto.setCargaHoraria(curso.getCargaHoraria());
        dto.setAluno_id(
                curso.getAlunos()
                        .stream()
                        .map(Aluno::getId)
                        .toList()
        );

        return dto;
    }

    public String alterarCurso(Long id, CursoRequest req){
        Curso c = cursoRepository.findById(id).orElseThrow();

        c.setNome(req.getNome());
        c.setCargaHoraria(req.getCargaHoraria());

        cursoRepository.save(c);
        return "Curso alterado com sucesso!";
    }

    public String deletarCurso(long id){
        Curso curso = cursoRepository.findById(id).orElseThrow();
        cursoRepository.deleteById(id);
        return "Curso excluído com sucesso";
    }
}
