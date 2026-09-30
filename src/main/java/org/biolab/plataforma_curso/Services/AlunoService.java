package org.biolab.plataforma_curso.Services;

import org.biolab.plataforma_curso.DTO.*;
import org.biolab.plataforma_curso.Entities.Aluno;
import org.biolab.plataforma_curso.Entities.Curso;
import org.biolab.plataforma_curso.Repositories.AlunoRepository;
import org.biolab.plataforma_curso.Repositories.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

    @Service
    public class AlunoService {
        private final AlunoRepository alunoRepository;
        private final CursoRepository cursoRepository;

        public AlunoService(AlunoRepository alunoRepository, CursoRepository cursoRepository) {
            this.alunoRepository = alunoRepository;
            this.cursoRepository = cursoRepository;
        }

        public String criarAluno(AlunoDTO dto ){
            Aluno aluno = new Aluno();
            aluno.setNome(dto.getNome());
            aluno.setEmail(dto.getEmail());

            if (dto.getCurso_id() != null){
                for (Long cursoId : dto.getCurso_id()){
                    Curso curso = cursoRepository.findById(cursoId).orElseThrow();
                    aluno.getCursos().add(curso);
                }
            }

            alunoRepository.save(aluno);

            return "Aluno matriculado com sucesso";
        }

        public List<AlunoResponse> mostrarAlunos() {
            return alunoRepository.findAll().stream().map(aluno -> new AlunoResponse(
                    aluno.getId(),
                    aluno.getNome(),
                    aluno.getEmail(),
                    aluno.getCursos()
                            .stream()
                            .map(Curso::getId)
                            .toList()
            )).toList();
        }

        public AlunoDTO mostrarAlunoPeloId(Long id){
            Aluno aluno = alunoRepository.findById(id).orElseThrow();
            AlunoDTO dto = new AlunoDTO();

            dto.setId(aluno.getId());
            dto.setNome(aluno.getNome());
            dto.setEmail(aluno.getEmail());
            dto.setCurso_id(
                    aluno.getCursos()
                            .stream()
                            .map(Curso::getId)
                            .toList()
            );

            return dto;
        }

        public String alterarAluno(Long id, AlunoRequest req){
            Aluno a = alunoRepository.findById(id).orElseThrow();

            a.setNome(req.getNome());
            a.setEmail(req.getEmail());

            if (req.getCurso_id() != null){
                a.getCursos().clear();
                for (Long cursoId : req.getCurso_id()){
                    Curso curso = cursoRepository.findById(cursoId).orElseThrow();

                    a.getCursos().add(curso);
                }
            }

            alunoRepository.save(a);
            return "Aluno alterado com sucesso!";
        }

        public String deletarAluno( long id){
            Aluno aluno = alunoRepository.findById(id).orElseThrow();
            alunoRepository.deleteById(id);
            return "Aluno excluído com sucesso";
        }


    }


