package com.example.clinicaapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.clinicaapi.models.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

}
