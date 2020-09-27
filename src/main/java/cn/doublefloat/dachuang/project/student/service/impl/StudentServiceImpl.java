package cn.doublefloat.dachuang.project.student.service.impl;

import cn.doublefloat.dachuang.common.exception.user.UserCardIdExistException;
import cn.doublefloat.dachuang.common.exception.user.UserNoExistException;
import cn.doublefloat.dachuang.common.exception.user.UserNotExistException;
import cn.doublefloat.dachuang.project.student.domain.Student;
import cn.doublefloat.dachuang.project.student.mapper.StudentMapper;
import cn.doublefloat.dachuang.project.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author 李广帅
 * @date 2020/9/26 6:27 下午
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Integer addStudent(Student student) {
        if (checkStudentNo(student.getNo())) {
            throw new UserNoExistException();
        }
        if (checkStudentCardId(student.getCardId())) {
            throw new UserCardIdExistException();
        }
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        student.setCreateBy(1L);
        student.setCreateTime(new Date());
        return studentMapper.addStudent(student);
    }

    @Override
    public Integer deleteStudent(Long id) {
        if (!checkStudentExist(id)) {
            throw new UserNotExistException();
        }
        Student student = new Student();
        student.setId(id);
        student.setDeleteBy(1L);
        student.setDeleteTime(new Date());
        return studentMapper.deleteStudent(student);
    }

    @Override
    public Integer updateStudent(Student student) {
        if (!checkStudentExist(student.getId())) {
            throw new UserNotExistException();
        }
        student.setUpdateBy(1L);
        student.setUpdateTime(new Date());
        return studentMapper.updateStudent(student);
    }

    @Override
    public Student findStudentById(Long id) {
        if (!checkStudentExist(id)) {
            throw new UserNotExistException();
        }
        return studentMapper.findStudentById(id);
    }

    @Override
    public List<Student> findStudentList(Student student) {
        return studentMapper.findStudentList(student);
    }

    @Override
    public Boolean checkStudentExist(Long id) {
        return studentMapper.checkStudentExist(id) >= 1;
    }

    @Override
    public Boolean checkStudentNo(String no) {
        return studentMapper.checkStudentNoUnique(no) >= 1;
    }

    @Override
    public Boolean checkStudentCardId(String cardId) {
        return studentMapper.checkStudentCardIdUnique(cardId) >= 1;
    }
}
