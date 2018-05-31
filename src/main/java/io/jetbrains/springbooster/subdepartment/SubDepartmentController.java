package io.jetbrains.springbooster.subdepartment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import java.sql.SQLException;
import java.util.List;

public class SubDepartmentController {

    @Autowired
    private SubDepartmentService subDepartmentService;

    @RequestMapping(value = "/sub_department/{dept_id}/{lang_id}")
    public List<SubDepartment> getSubDepartmentByDept(@PathVariable int dept_id , @PathVariable int lang_id) throws SQLException {
        return subDepartmentService.getSubDepartmentByDept(dept_id , lang_id);
    }

    @RequestMapping(value = "/sub_department/{lang_id}")
    public List<SubDepartment> getAllSubDepartments(@PathVariable int lang_id) throws SQLException {
        return subDepartmentService.getAllSubDepartments(lang_id);
    }
}
