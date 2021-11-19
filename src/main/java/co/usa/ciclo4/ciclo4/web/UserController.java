package co.usa.ciclo4.ciclo4.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.usa.ciclo4.ciclo4.model.User;
import co.usa.ciclo4.ciclo4.service.UserService;

@RestController
@RequestMapping("/all/ss")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<User> getUsers(){
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable("id") int id){
        return userService.getUser(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user1){
        return userService.save(user1);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user1){
        return userService.update(user1);
    }   

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean deleteUser(@PathVariable("id") int id) {
        return userService.deleteUser(id);
    }

}
