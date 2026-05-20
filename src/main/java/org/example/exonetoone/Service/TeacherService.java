package org.example.exonetoone.Service;


import lombok.RequiredArgsConstructor;
import org.example.exonetoone.Api.ApiException;
import org.example.exonetoone.Model.Teacher;
import org.example.exonetoone.Repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public List<Teacher> getAll(){
        return teacherRepository.findAll();
    }

    public void add(Teacher teacher){
        teacherRepository.save(teacher);
    }

    public void update(Integer id,Teacher teacher){
        Teacher oldTeacher=teacherRepository.findTeacherById(id);
        if (oldTeacher==null)
            throw new ApiException("Teacher not found");

        oldTeacher.setEmail(teacher.getEmail());
        oldTeacher.setName(teacher.getName());
        oldTeacher.setAge(teacher.getAge());
        oldTeacher.setSalary(teacher.getSalary());
        teacherRepository.save(oldTeacher);
    }

    public void delete(Integer id){
        Teacher teacher=teacherRepository.findTeacherById(id);
        if(teacher==null)
            throw new ApiException("Teacher not found");
        teacherRepository.deleteById(id);
    }

    public Teacher getTeacherById(Integer id){
        Teacher teacher=teacherRepository.findTeacherById(id);
        if(teacher==null)
            throw new ApiException("Teacher not found");
        return teacher;
    }
}
