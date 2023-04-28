package com.randradee.spring.tutorial.school.repositories;

import com.randradee.spring.tutorial.school.entities.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByFirstName(String firstName);
    List<Student> findByFirstNameContaining(String name);

    // JPQL
    @Query("select s from Student s where s.emailId = ?1")
    Student getStudentByEmailAddress(String emailId);

    // Native
    @Query(value = "select * from TB_STUDENT s where s.email_address = ?1", nativeQuery = true)
    Student getStudentByEmailAddressNative(String emailId);

    // Named params
    @Query(value = "select * from TB_STUDENT s where s.email_address = :emailId", nativeQuery = true)
    Student getStudentByEmailAddressNativeNamedParam(@Param("emailId")String emailId);

    @Modifying
    @Transactional
    @Query(value = "update TB_STUDENT s set s.first_name = :firstName where s.email_address = :emailId",
            nativeQuery = true)
    int updateStudentFirstNameByEmailId(@Param("firstName") String firstName,
                                        @Param("emailId") String emailId);

    @Modifying
    @Transactional
    @Query(value = "delete from TB_STUDENT s where s.email_address = :emailId", nativeQuery = true)
    int deleteStudentByEmailId(@Param("emailId") String emailId);
}
