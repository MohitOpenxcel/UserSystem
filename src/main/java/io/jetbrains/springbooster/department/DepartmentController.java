package io.jetbrains.springbooster.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import java.sql.SQLException;
import java.util.List;


@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "/department/{dept_id}/{lang_id}")
    public Department getDepartmentById(@PathVariable int dept_id , @PathVariable int lang_id) throws SQLException {
        return departmentService.getDepartmentById(dept_id,lang_id);
    }

    @RequestMapping(value = "/department/{lang_id}")
    public List<Department> getAllDepartments(@PathVariable int lang_id) throws SQLException {
        return departmentService.getAllDepartments(lang_id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/users/department/{dept_id}")
    public void deleteDepartment(@PathVariable int dept_id) {
        departmentService.deleteDepartment(dept_id);
    }

    @RequestMapping(method = RequestMethod.POST , value = "/department/language")
    public void addLanToDepartment(@RequestBody Department department) throws SQLException {departmentService.addLanToDepartment(department);}
}
