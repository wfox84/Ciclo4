package co.usa.ciclo4.ciclo4.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.ciclo4.ciclo4.model.User;
import co.usa.ciclo4.ciclo4.repository.crud.UserCrudRepository;



@Repository
public class UserRepository {
    @Autowired
    private UserCrudRepository userCrudRepository;

    
    /**
     * buscar todos los registros
     * @return todos los registros 
     */
    public List<User>getAll(){
        return(List<User>) userCrudRepository.findAll();
    }

    /**
     * busca registros por id
     * @param id user
     * @return registro por id
     */
    public Optional<User>getUser(int id){
        return userCrudRepository.findById(id);
    }

    /**
     * Guarda los registros
     * @param User1
     * @return regsitros guardados
     */
    public User save(User user1){
        return userCrudRepository.save(user1);
    }

    
    /**
     * Elimina registros
     * @param user1
     */
    public void delete(User user1){
        userCrudRepository.delete(user1);
    }

}
