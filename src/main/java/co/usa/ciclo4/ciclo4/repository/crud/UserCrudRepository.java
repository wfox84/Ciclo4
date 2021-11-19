package co.usa.ciclo4.ciclo4.repository.crud;

import org.springframework.data.repository.CrudRepository;

import co.usa.ciclo4.ciclo4.model.User;

public interface UserCrudRepository extends CrudRepository<User,Integer> {
    
}
