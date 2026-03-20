package com.autor.Gerenciamento_Autores.Services;

import com.autor.Gerenciamento_Autores.Models.AutorModel;
import com.autor.Gerenciamento_Autores.Repositories.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    private final AutorRepository repository;

    public AutorService(AutorRepository repository) {
        this.repository = repository;
    }

    public AutorModel salvar(AutorModel autor) {
        return repository.save(autor);
    }

    public List<AutorModel> listarTodos() {
        return repository.findAll();
    }

    public Optional<AutorModel> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}