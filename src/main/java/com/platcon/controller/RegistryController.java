package com.platcon.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.platcon.model.Registry;
import com.platcon.model.dto.DataDTO;
import com.platcon.repository.RegistryRepository;
import com.platcon.service.impl.RegistryServiceImpl;

@RestController
@RequestMapping("/api/registries")
public class RegistryController {

    @Autowired
    private RegistryRepository registryRepository;
    
    @Autowired
    private RegistryServiceImpl registryService;

    @PostMapping
    public Registry criarRegistro(@RequestBody Registry registro) {
        return registryRepository.save(registro);
    }

    @GetMapping
    public List<Registry> listarRegistros() {
        return registryRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Registry> buscarRegistro(@PathVariable UUID id) {
        return registryRepository.findById(id)
                .map(registro -> ResponseEntity.ok().body(registro))
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/listAll")
    public DataDTO buscarTodosRegistro() {
        return registryService.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Registry> atualizarRegistro(@PathVariable UUID id, @RequestBody Registry registroAtualizado) {
        return registryRepository.findById(id)
                .map(registro -> {
                    registro.setNavegador(registroAtualizado.getNavegador());
                    registro.setHorarioAcesso(registroAtualizado.getHorarioAcesso());
                    registro.setTipoAparelho(registroAtualizado.getTipoAparelho());
                    registro.setOrigemAcesso(registroAtualizado.getOrigemAcesso());
                    Registry registroSalvo = registryRepository.save(registro);
                    return ResponseEntity.ok().body(registroSalvo);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarRegistro(@PathVariable UUID id) {
        return registryRepository.findById(id)
                .map(registro -> {
                    registryRepository.delete(registro);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}