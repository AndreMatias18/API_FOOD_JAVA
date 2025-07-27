package dev.javamatias.aprendizado.service;

import dev.javamatias.aprendizado.model.ModelAprendizado;
import dev.javamatias.aprendizado.repository.RepositoryAprendizado;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceAprendizado {

    private final RepositoryAprendizado RepositoryAprendizado;

    public ServiceAprendizado(RepositoryAprendizado repositoryAprendizado) {
        RepositoryAprendizado = repositoryAprendizado;
    }

    // List
    public List<ModelAprendizado> getAll() {return RepositoryAprendizado.findAll();}

    // create
    public ModelAprendizado save(ModelAprendizado Food) {return RepositoryAprendizado.save(Food);}

    // delete
    public void delete(Long id) {RepositoryAprendizado.deleteById(id);}

    //update
    public ModelAprendizado update(Long id, ModelAprendizado newData) {
        ModelAprendizado exists = RepositoryAprendizado.findById(id)
                .orElseThrow(() -> new RuntimeException("Alimento com ID " + id + " não encontrado."));

        exists.setName(newData.getName());
        exists.setExpirationDate(newData.getExpirationDate());
        exists.setQuantity(newData.getQuantity());

        return RepositoryAprendizado.save(exists);
    }


}
