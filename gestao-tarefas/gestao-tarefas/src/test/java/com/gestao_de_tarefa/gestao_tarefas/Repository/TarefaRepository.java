package com.gestao_de_tarefa.gestao_tarefas.Repository;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import com.gestao_de_tarefa.gestao_tarefas.Entity.Tarefa;

@DataJpaTest
class TarefaRepositoryTest {

    @Autowired
    private TarefaRepository repository;

    @Test
    void deveSalvarTarefa() {

        Tarefa tarefa = new Tarefa();
        tarefa.setNomeTarefa("Teste");

        Tarefa salva = repository.save(tarefa);

        assertNotNull(salva.getId());
    }
}