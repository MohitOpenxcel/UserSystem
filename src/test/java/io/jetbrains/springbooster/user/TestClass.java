package io.jetbrains.springbooster.user;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestClass {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    List<User> users = new ArrayList<>();

    private PreDTO preDTO = null;
    private PostDTO postDTO = null;

    private ModelMapper modelMapper;

    /*@RequestMapping(method = RequestMethod.POST, value = "/users/test")
    public String testAddUser(@RequestBody User user) {
        if(user.getFirstName() != null && user.getLastName() != null){
            if(user.getDateOfBirth() == null){
                return "Please enter Date Of Birth";
            } else if(user.getGender() == null) {
                return "Please enter gender";
            } else if(String.valueOf(user.getAge()).isEmpty()){
                return "Please enter Age";
            }else if(user.getRegisteredDate() == null){
                return "Please enter registration Date";
            }
        } else{
            if(user.getFirstName() == null){
                return "Please enter FirstName";
            }else if(user.getLastName() == null){
                return "Please enter LastName";
            } else {
                userRepository.save(user);
            }
        }
        return null;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/users/test/{id}")
    public void testUpdateUser(@RequestBody User user , @PathVariable int id) {
        for (User user1 : userRepository.findAll()) {
            users.add(user1);
        }

        for(int i=0; i < users.size();i++) {
            if(users.get(i).getUserId()  == id){
                users.set(i,user);
            }

        }
    }


    @RequestMapping(method = RequestMethod.DELETE, value = "/users/test/{id}")
    public void testDeleteUser(@PathVariable int id) {
        userRepository.deleteById(id);
    }*/
}
