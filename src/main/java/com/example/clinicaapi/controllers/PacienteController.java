package com.example.clinicaapi.controllers;

import com.example.clinicaapi.models.Paciente;
import com.example.clinicaapi.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @GetMapping
    public List<Paciente> listarTodos() {
        return repository.findAll();
    }

    @PostMapping
    public Paciente salvar(@RequestBody Paciente paciente) {
        return repository.save(paciente);
    }
}
