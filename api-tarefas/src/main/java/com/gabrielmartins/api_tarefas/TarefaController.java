package com.gabrielmartins.api_tarefas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaRepository tarefaRepository;

    // Criar uma nova tarefa (POST)
    @PostMapping
    public Tarefa criarTarefa(@RequestBody Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    // Listar todas as tarefas (GET)
    @GetMapping
    public List<Tarefa> listarTodasTarefas() {
        return tarefaRepository.findAll();
    }

    // Buscar uma tarefa específica pelo ID (GET)
    @GetMapping("/{id}")
    public Optional<Tarefa> buscarTarefaPorId(@PathVariable Long id) {
        return tarefaRepository.findById(id);
    }

    // Atualizar uma tarefa existente (PUT)
    @PutMapping("/{id}")
    public Tarefa atualizarTarefa(@PathVariable Long id, @RequestBody Tarefa tarefaAtualizada) {
        // Encontra a tarefa no banco pelo ID
        return tarefaRepository.findById(id)
                .map(tarefa -> { // Se encontrou, atualiza seus dados
                    tarefa.setNome(tarefaAtualizada.getNome());
                    tarefa.setDataEntrega(tarefaAtualizada.getDataEntrega());
                    tarefa.setResponsavel(tarefaAtualizada.getResponsavel());
                    return tarefaRepository.save(tarefa);
                })
                .orElseGet(() -> { // Se não encontrou, cria uma nova tarefa com esse ID (comportamento opcional, mas comum)
                    tarefaAtualizada.setId(id);
                    return tarefaRepository.save(tarefaAtualizada);
                });
    }

    // Deletar uma tarefa (DELETE)
    @DeleteMapping("/{id}")
    public void deletarTarefa(@PathVariable Long id) {
        tarefaRepository.deleteById(id);
    }
}
