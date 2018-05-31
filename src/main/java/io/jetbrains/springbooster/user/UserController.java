package io.jetbrains.springbooster.user;

import io.jetbrains.springbooster.department.Department;
import io.jetbrains.springbooster.language.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    private Department department;

    private PostDTO postDTO = null;

    @RequestMapping("/users")
    public List<PostDTO> getAllUsers() throws SQLException {
        return userService.getUsers();
    }

    @RequestMapping(value = "/users/{id}")
    public List<PostDTO> getUser(@PathVariable String id) {
        return userService.getUser(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users/department")
    public void addUser(@RequestBody PreDTO preDTO ) {
        userService.addUser(preDTO);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/users/{id}")
    public void updateUser(@RequestBody PreDTO preDTO, @PathVariable int id) {
        userService.updateUser(preDTO, id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/users/{userId}/department/{id}")
    public void updateDepartment(@RequestBody PreDTO preDTO, @PathVariable int userId, @PathVariable int id) {
        userService.updateDepartment(preDTO, userId, id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{user_id}")
    public void deleteUser(@PathVariable int user_id) {
        userService.deleteUser(user_id);
    }


    @RequestMapping(method = RequestMethod.POST , value = "/language")
    public void addLanguage(@RequestBody Language language) {userService.addLanguage(language);}

    @RequestMapping(value = "/users/language/add")
    public void getLanguages() throws SQLException {
        userService.getLanguages();
    }

}