package cn.doublefloat.CDCSonCNN.project.teacher.service.impl;

import cn.doublefloat.CDCSonCNN.project.teacher.domain.Teacher;
import cn.doublefloat.CDCSonCNN.project.teacher.service.TeacherService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 李广帅
 * @date 2020/10/16 9:07 上午
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    @Override
    public Integer addTeacher(Teacher teacher) {
        return null;
    }

    @Override
    public Integer deleteTeacher(Long id) {
        return null;
    }

    @Override
    public Integer updateTeacher(Teacher teacher) {
        return null;
    }

    @Override
    public Teacher findTeacherById(Long id) {
        return null;
    }

    @Override
    public Teacher findTeacherByNo(String no) {
        return null;
    }

    @Override
    public List<Teacher> findTeacherList(Teacher teacher) {
        return null;
    }

    @Override
    public Boolean checkTeacherNo(String no) {
        return null;
    }

    @Override
    public Boolean checkTeacherCardId(String cardId) {
        return null;
    }
}
