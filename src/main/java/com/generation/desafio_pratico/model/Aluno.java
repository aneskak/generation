package com.generation.desafio_pratico.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ALUNO")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;

    @NotNull
    private String nome;

    @NotNull
    private Integer idade;

    @NotNull
    private Integer notaPrimeiroSemestre;

    @NotNull
    private Integer notaSegundoSemestre;

    @NotNull
    private String nomeProfessor;

    @NotNull
    private Integer numeroSala;
}
