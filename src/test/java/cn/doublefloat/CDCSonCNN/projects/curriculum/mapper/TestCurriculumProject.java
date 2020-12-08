package cn.doublefloat.CDCSonCNN.projects.curriculum.mapper;

import cn.doublefloat.CDCSonCNN.projects.curriculum_project.domain.CurriculumProject;
import cn.doublefloat.CDCSonCNN.projects.curriculum_project.mapper.CurriculumProjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author 李广帅
 * @date 2020/12/8 3:18 下午
 */
@SpringBootTest
public class TestCurriculumProject {

    @Autowired
    private CurriculumProjectMapper curriculumProjectMapper;

    @Test
    public void testGetCurriculumList() {
        List<CurriculumProject> curriculumProjects = curriculumProjectMapper.selectCurriculumProjectList(new CurriculumProject());
        curriculumProjects.forEach(System.out::println);
    }
}
