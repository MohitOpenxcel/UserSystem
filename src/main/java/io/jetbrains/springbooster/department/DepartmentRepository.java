package io.jetbrains.springbooster.department;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DepartmentRepository extends CrudRepository<Department,Integer> {

    @Query(value = "SELECT d.dept_id,d.department_name,d.lang_id FROM department d WHERE dept_id = :dept_id and lang_id= :lang_id",nativeQuery = true)
    Department getDepartmentById(@Param("dept_id") int dept_id, @Param("lang_id") int lang_id);

    @Query(value = "SELECT d.dept_id,d.department_name,d.lang_id FROM department d WHERE lang_id = :lang_id",nativeQuery = true)
    List<Department> getAllDepartments(@Param("lang_id") int lang_id);

    @Modifying
    @Cascade(CascadeType.DELETE)
    @Query(value = "delete from Department where dept_id = dept_id" , nativeQuery = true)
    void deleteDepartment(int dept_id);
}
