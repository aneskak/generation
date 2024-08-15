package com.generation.desafio_pratico.controller;

import com.generation.desafio_pratico.model.Aluno;
import com.generation.desafio_pratico.repository.AlunoRepository;
import com.generation.desafio_pratico.service.AlunoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/aluno")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private AlunoService alunoService;

    @Operation(description = "Busca todos os alunos cadastrados.")
    @GetMapping("/listartodos")
    public ResponseEntity<Iterable<Aluno>> getAll(){
        return ResponseEntity.ok(alunoRepository.findAll());
    }

    @Operation(description = "Busca alunos por id.")
    @GetMapping("listar/{id}")
    public ResponseEntity<Aluno> getClienteById(@PathVariable Long id) {
        return alunoRepository.findById(id)
                .map(resposta -> ResponseEntity.ok(resposta))
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(description = "Cadastra alunos")
    @PostMapping("/cadastrar")
    public ResponseEntity<Aluno> PostCliente(@Valid @RequestBody Aluno aluno)
    {
        return alunoService.CadastrarAluno(aluno)
                .map(resposta -> ResponseEntity.status(HttpStatus.CREATED).body(resposta))
                .orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }

    @Operation(description = "Atualiza dados do aluno por id.")
    @Parameter(description = "id do aluno")
    @PutMapping("atualizar/{id}")
    public ResponseEntity<Aluno> putCliente(@Valid @RequestBody Aluno aluno) {
        return alunoService.atualizarAluno(aluno)
                .map(resposta -> ResponseEntity.status(HttpStatus.OK).body(resposta))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @Operation(description = "Deleta aluno por id.")
    @DeleteMapping("deletar/{id}")
    public void delete(@PathVariable long id) {
        alunoRepository.deleteById(id);
    }

}
