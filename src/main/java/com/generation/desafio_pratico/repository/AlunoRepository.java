package com.generation.desafio_pratico.repository;

import com.generation.desafio_pratico.model.Aluno;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlunoRepository extends CrudRepository<Aluno, Long> {}
