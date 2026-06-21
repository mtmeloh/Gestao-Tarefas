package com.gestao_de_tarefa.gestao_tarefas.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gestao_de_tarefa.gestao_tarefas.Entity.Tarefa;
import com.gestao_de_tarefa.gestao_tarefas.Repository.TarefaRepository;

@Service
public class TarefaService {

    private final TarefaRepository BD;

    public TarefaService(TarefaRepository BD){
        this.BD = BD;
    }

    public List<Tarefa> listarTarefas(){
        return BD.findAll();
    }

    public Tarefa salvarTarefa(Tarefa tarefa){
        return BD.save(tarefa);
    }

    public Tarefa buscarPorId(Long id){
        return BD.findById(id).orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
    }

    public Tarefa atualizar(Long id, Tarefa tarefaAtualizada){
        Tarefa tarefa = buscarPorId(id);

        tarefa.setNomeTarefa(tarefaAtualizada.getNomeTarefa());
        tarefa.setStatusTarefa(tarefaAtualizada.getStatusTarefa());

        return BD.save(tarefa);
    }
    public void deletar(Long id) {
        Tarefa tarefa = buscarPorId(id);
        BD.delete(tarefa);
    }
}