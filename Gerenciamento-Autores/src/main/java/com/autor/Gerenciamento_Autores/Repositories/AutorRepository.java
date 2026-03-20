package com.autor.Gerenciamento_Autores.Repositories;

import com.autor.Gerenciamento_Autores.Models.AutorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<AutorModel, Long> {

}