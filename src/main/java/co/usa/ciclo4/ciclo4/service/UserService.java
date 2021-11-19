package co.usa.ciclo4.ciclo4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.ciclo4.ciclo4.model.User;
import co.usa.ciclo4.ciclo4.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAll(){
        return userRepository.getAll();
    }

    public Optional<User> getUser(int user1){
        return userRepository.getUser(user1);
    }

    public User save(User user1){
        if(user1.getId()==null){
            return userRepository.save(user1);
        }else{
            Optional<User> consulta = userRepository.getUser(user1.getId());
            if(consulta.isEmpty()){
                return userRepository.save(user1);
            }else{
                return user1;
            }
        }
    }

    public User update(User user1){
        if(user1.getId() !=null){
            Optional<User> consulta = userRepository.getUser(user1.getId());
            if(!consulta.isEmpty()){
                
                if(user1.getEmail() != null){
                    consulta.get().setEmail(user1.getEmail());
                }
                if(user1.getName() !=null){
                    consulta.get().setName(user1.getName());
                }
                if(user1.getPassword() !=null){
                    consulta.get().setPassword(user1.getPassword());
                }
                return userRepository.save(consulta.get());
            }
        }

        return user1;
    }

    public boolean deleteUser(int id){
        Optional<User> consulta = userRepository.getUser(id);
        if(!consulta.isEmpty()){
            userRepository.delete(consulta.get());
            return true;
        }
        return false;
    }

}
