package dev.javamatias.aprendizado.repository;

import dev.javamatias.aprendizado.AprendizadoApplication;
import dev.javamatias.aprendizado.model.ModelAprendizado;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RepositoryAprendizado extends JpaRepository<ModelAprendizado, Long> {



    @Modifying
    @Transactional
    @Query("UPDATE ModelAprendizado m SET m.name = :name WHERE m.id = :id")
    int updateName(@Param("id") Long id, @Param("name") String name);


}
