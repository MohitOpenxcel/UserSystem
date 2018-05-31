package io.jetbrains.springbooster.subdepartment;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubDepartmentRepository extends CrudRepository<SubDepartment,Integer> {

    @Query(value = "SELECT s.dept_id,s.sub_department_name,s.lang_id FROM sub_department s WHERE dept_id = :dept_id and lang_id = :lang_id",nativeQuery = true)
    List<SubDepartment> getSubDepartmentByDept(@Param("dept_id") int dept_id, @Param("lang_id") int lang_id);

    @Query(value = "SELECT s.dept_id,s.sub_department_name,s.lang_id FROM sub_department s WHERE lang_id = :lang_id",nativeQuery = true)
    List<SubDepartment> getAllSubDepartments(@Param("lang_id") int lang_id);

}
