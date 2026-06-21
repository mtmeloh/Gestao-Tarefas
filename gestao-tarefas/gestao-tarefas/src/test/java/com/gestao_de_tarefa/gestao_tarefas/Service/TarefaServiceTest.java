package com.gestao_de_tarefa.gestao_tarefas.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.gestao_de_tarefa.gestao_tarefas.Entity.Tarefa;
import com.gestao_de_tarefa.gestao_tarefas.Repository.TarefaRepository;

@ExtendWith(MockitoExtension.class)
class TarefaServiceTest {

    @Mock
    private TarefaRepository repository;

    @InjectMocks
    private TarefaService service;

    @Test
    void deveSalvarTarefa() {

        Tarefa tarefa = new Tarefa();
        tarefa.setNomeTarefa("Estudar Spring");

        when(repository.save(any(Tarefa.class)))
                .thenReturn(tarefa);

        Tarefa resultado = service.salvarTarefa(tarefa);

        assertEquals("Estudar Spring",
                resultado.getNomeTarefa());

        verify(repository).save(tarefa);
    }
}