package io.jetbrains.springbooster.department;

import io.jetbrains.springbooster.subdepartment.SubDepartment;
import io.jetbrains.springbooster.user.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    private PostDTO postDTO;

    List<User> users = new ArrayList<>();
    List<PostDTO> postDTOS = new ArrayList<>();
    List<Department> departments = new ArrayList<>();
    public ModelMapper modelMapper = new ModelMapper();

    public Department getDepartmentById(int dept_id , int lang_id) throws SQLException {
        Department department = departmentRepository.getDepartmentById(dept_id ,lang_id);
        return department;
    }

    public List<Department> getAllDepartments(int lang_id) throws SQLException {
        departments = departmentRepository.getAllDepartments(lang_id);
        return departments;
    }

    public void addLanToDepartment(Department department) throws SQLException {
        departmentRepository.save(department);
    }

    public void deleteDepartment(int dept_id) {
        departmentRepository.deleteDepartment(dept_id);
    }
}
