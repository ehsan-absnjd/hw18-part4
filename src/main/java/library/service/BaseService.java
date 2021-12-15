package library.service;

import library.entity.BaseEntity;
import library.repository.BaseRepository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseService<T extends BaseEntity<ID>, ID extends Serializable>{
    protected BaseRepository repository;

    public BaseService() {
        setRepository();
    }
    protected abstract void setRepository();

    public Optional<T> fincById(ID id){
        return repository.findById(id);
    }

    public List<T> findAll(){
        return repository.findAll();
    }

    public void delete(T entity){
        repository.getTransaction().begin();
        repository.delete(entity);
        repository.getTransaction().commit();
    }

    public void saveOrUpdate (T entity){
        repository.getTransaction().begin();
        repository.saveOrUpdate(entity);
        repository.getTransaction().commit();
    }
}
