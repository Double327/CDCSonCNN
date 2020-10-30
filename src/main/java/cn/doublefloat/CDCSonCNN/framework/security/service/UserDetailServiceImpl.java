package cn.doublefloat.CDCSonCNN.framework.security.service;

import cn.doublefloat.CDCSonCNN.common.exception.BaseException;
import cn.doublefloat.CDCSonCNN.common.utils.StringUtils;
import cn.doublefloat.CDCSonCNN.framework.security.LoginUser;
import cn.doublefloat.CDCSonCNN.framework.web.domain.BaseUser;
import cn.doublefloat.CDCSonCNN.projects.student.service.StudentService;
import cn.doublefloat.CDCSonCNN.projects.teacher.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author 李广帅
 * @date 2020/10/16 2:35 下午
 */
@Slf4j
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @Override
    public UserDetails loadUserByUsername(String no) throws UsernameNotFoundException {
        BaseUser user = studentService.findStudentByNo(no);

        if (StringUtils.isNull(user)) {
            //user = teacherService.findTeacherByNo(no);
        }

        if (StringUtils.isNull(user)) {
            log.info("登录用户：{} 不存在.", no);
            throw new UsernameNotFoundException("登录用户：" + no + " 不存在");
        } else if (user.getDeleteTime() != null) {
            log.info("登录用户：{} 已被删除.", no);
            throw new BaseException("对不起，您的账号：" + no + " 已被删除");
        }

        return createLoginUser(user);
    }

    private UserDetails createLoginUser(BaseUser user) {
        return new LoginUser(user, null);
    }
}
