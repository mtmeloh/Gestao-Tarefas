package com.gestao_de_tarefa.gestao_tarefas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestao_de_tarefa.gestao_tarefas.Entity.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long>{

}
