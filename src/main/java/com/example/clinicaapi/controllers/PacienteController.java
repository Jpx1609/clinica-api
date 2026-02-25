package com.example.clinicaapi.controllers;

import com.example.clinicaapi.models.Paciente;
import com.example.clinicaapi.repositories.PacienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;
    // LISTAR TODOS OS PACIENTES
    @GetMapping
    public List<Paciente> listarTodos() {
        return repository.findAll();
    }
    // ADICIONAR UM PACIENTE
    @PostMapping
    public Paciente salvar(@Valid @RequestBody Paciente paciente) {
        return repository.save(paciente);
    }
    // DELETAR UM PACIENTE
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
    // ATUALIZAR UM PACIENTE
    @PutMapping("/{id}")
    public Paciente atualizar(@PathVariable Long id, @RequestBody Paciente pacienteAtualizado) {
        return repository.findById(id).map(paciente  -> {
            paciente.setNome(pacienteAtualizado.getNome());
            paciente.setCpf(pacienteAtualizado.getCpf());
            paciente.setEmail(pacienteAtualizado.getEmail());

            return repository.save(paciente);
        }).orElse(null);
        }
    }