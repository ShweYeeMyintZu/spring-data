package com.example.manytomany.service;

import com.example.manytomany.dao.StudentDao;
import com.example.manytomany.dao.SubjectDao;
import com.example.manytomany.entity.Student;
import com.example.manytomany.entity.Subject;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentDao studentDao;
    private final SubjectDao subjectDao;

    public StudentService(StudentDao studentDao, SubjectDao subjectDao) {
        this.studentDao = studentDao;
        this.subjectDao = subjectDao;
    }

    @Transactional
    public void createDb() {
        Student s1 = new Student("John", "Doe", "john@gmail.com");
        Student s2 = new Student("Jay", "Doe", "john@gmail.com");
        Student s3 = new Student("Biden", "Doe", "john@gmail.com");

        Subject su1 = new Subject("Java", 3, 80000);
        Subject su2 = new Subject("C#", 8, 100000);
        Subject su3 = new Subject("Python", 6, 20000);

//        s1.addSubject(su1);
//        s2.addSubject(su2);
//        s3.addSubject(su3);

        su1.addStudent(s1);
        su1.addStudent(s2);
        su1.addStudent(s3);

        su2.addStudent(s1);
        su2.addStudent(s2);
        su2.addStudent(s3);

        su3.addStudent(s1);
        su3.addStudent(s2);
        su3.addStudent(s3);

//        studentDao.save(s1);
//        studentDao.save(s2);
//        studentDao.save(s3);
        subjectDao.save(su1);
        subjectDao.save(su2);
        subjectDao.save(su3);


    }

}
