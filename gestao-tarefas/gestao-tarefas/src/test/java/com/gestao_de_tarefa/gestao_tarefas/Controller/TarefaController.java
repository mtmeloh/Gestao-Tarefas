package com.gestao_de_tarefa.gestao_tarefas.Controller;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.gestao_de_tarefa.gestao_tarefas.Entity.Tarefa;
import com.gestao_de_tarefa.gestao_tarefas.Service.TarefaService;

@WebMvcTest(Controller.class)
class TarefaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private TarefaService service;

    @Test
    void deveListarTarefas() throws Exception {

        when(service.listarTarefas())
                .thenReturn(List.of(new Tarefa()));

        mockMvc.perform(get("/tarefa")).andExpect(status().isOk());
    }
}