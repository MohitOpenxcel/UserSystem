package io.jetbrains.springbooster.subdepartment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SubDepartmentService {

    @Autowired
    private SubDepartmentRepository subDepartmentRepository;

    List<SubDepartment> subDepartments = new ArrayList<>();

    public List<SubDepartment> getSubDepartmentByDept(int dept_id , int lang_id) throws SQLException {
        subDepartments = subDepartmentRepository.getSubDepartmentByDept(dept_id , lang_id);
        return subDepartments;
    }

    public List<SubDepartment> getAllSubDepartments(int lang_id) throws SQLException {
        subDepartments = subDepartmentRepository.getAllSubDepartments( lang_id);
        return subDepartments;
    }

}
