package com.nhnacademy.exam.repository;

import com.nhnacademy.exam.model.entity.Department;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface DepartmentRepository extends JpaRepository<Department, String> {

    boolean existsById(String id);

    Department findDepartmentById(String id);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE Department d SET d.name = :name WHERE d.id = :id")
    void updateDepartment(String name, String id);

    void deleteDepartmentById(@NonNull String id);
}
