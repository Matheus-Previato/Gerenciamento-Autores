package com.autor.Gerenciamento_Autores.Controllers; // Ajuste para o seu pacote base

import com.autor.Gerenciamento_Autores.Models.AutorModel;
import com.autor.Gerenciamento_Autores.Services.AutorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private final AutorService service;

    public AutorController(AutorService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<AutorModel> criar(@RequestBody AutorModel autor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(autor));
    }

    @GetMapping
    public ResponseEntity<List<AutorModel>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutorModel> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}