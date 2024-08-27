package com.generation.desafio_pratico.service;

import com.generation.desafio_pratico.model.Aluno;
import com.generation.desafio_pratico.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;

    public Optional<Aluno> cadastrarAluno(Aluno aluno){
        if(alunoRepository.findById(aluno.getId()).isPresent())
            return Optional.empty();

        aluno.setId(aluno.getId());
        aluno.setIdade(aluno.getIdade());
        aluno.setNome(aluno.getNome());
        aluno.setNomeProfessor(aluno.getNomeProfessor());
        aluno.setNumeroSala(aluno.getNumeroSala());
        aluno.setNotaPrimeiroSemestre(aluno.getNotaPrimeiroSemestre());
        aluno.setNotaSegundoSemestre(aluno.getNotaSegundoSemestre());

        return Optional.of(alunoRepository.save(aluno));
    }

    public Optional<Aluno> atualizarAluno(Aluno aluno){
        if(alunoRepository.findById(aluno.getId()).isPresent()) {

            Optional<Aluno> buscaAluno = alunoRepository.findById(aluno.getId());
            if((buscaAluno.isPresent()) && (buscaAluno.get().getId() != aluno.getId())){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Aluno já existe.", null);
            }

            aluno.setId(aluno.getId());
            aluno.setIdade(aluno.getIdade());
            aluno.setNome(aluno.getNome());
            aluno.setNomeProfessor(aluno.getNomeProfessor());
            aluno.setNumeroSala(aluno.getNumeroSala());
            aluno.setNotaPrimeiroSemestre(aluno.getNotaPrimeiroSemestre());
            aluno.setNotaSegundoSemestre(aluno.getNotaSegundoSemestre());

            return Optional.ofNullable(alunoRepository.save(aluno));
        }
        return Optional.empty();
    }

}
