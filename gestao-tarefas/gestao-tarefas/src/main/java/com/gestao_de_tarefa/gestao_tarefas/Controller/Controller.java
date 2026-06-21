package com.gestao_de_tarefa.gestao_tarefas.Controller;

import com.gestao_de_tarefa.gestao_tarefas.Entity.Tarefa;
import com.gestao_de_tarefa.gestao_tarefas.Service.TarefaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Gestão de Tarefas", description = "Sistemas gerenciador de tarefas!" )
@RequestMapping("/tarefa")
public class Controller {

    private final TarefaService tarefaService;

    // Construtor para injeção de dependência
    public Controller(TarefaService tarefaService){
        this.tarefaService = tarefaService;
    }

    // 1. Rota para Listar todas as tarefas (GET)
    @GetMapping
    @Operation(summary = "Listar tarefas", description = "Listar todas tarefas que estão no banco de dados.")
    public List<Tarefa> listar(){
        return tarefaService.listarTarefas();
    }

    // 2. Rota para Salvar uma nova tarefa (POST)
    @PostMapping
    @Operation(summary = "Salvar tarefas", description = "Cadastra uma tarefa que ainda não esteja cadastrada no banco de dados ainda!")
    public Tarefa salvarTarefa(@RequestBody Tarefa tarefa){
        return tarefaService.salvarTarefa(tarefa);
    }

    // Rota para atualizar com ID (PUT)
    @PutMapping("/{id}") 
    @Operation(summary = "Atualizar tarefas", description = "Atualizar uma tarefa que já esteja cadastrada no banco de dados!")
    public Tarefa atualizarTarefa(@PathVariable Long id, @RequestBody Tarefa tarefaAtualizada) {
        return tarefaService.atualizar(id, tarefaAtualizada);
    }

    // Rota para Buscar uma tarefa específica por ID (GET)
    @GetMapping("/{id}")
    @Operation(summary = "Buscar tarefas", description = "Buscar uma tarefa que já esteja cadastrada no banco de dados!")
    public Tarefa buscarPorId(@PathVariable Long id) {
        return tarefaService.buscarPorId(id);
    }

    // Rota para deletar uma tarefa por ID (DELETE)
    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar tarefas", description = "Deletar uma tarefa que esteja cadastrada no banco de dados!")
    public void deletarTarefa(@PathVariable Long id) {
        tarefaService.deletar(id); 
    }
}