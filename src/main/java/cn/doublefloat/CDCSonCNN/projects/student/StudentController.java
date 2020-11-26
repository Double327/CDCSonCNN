package cn.doublefloat.CDCSonCNN.projects.student;

import cn.doublefloat.CDCSonCNN.common.constant.UserConstants;
import cn.doublefloat.CDCSonCNN.common.utils.SecurityUtils;
import cn.doublefloat.CDCSonCNN.framework.web.controller.BaseController;
import cn.doublefloat.CDCSonCNN.framework.web.domain.AjaxResult;
import cn.doublefloat.CDCSonCNN.framework.web.page.TableDataResult;
import cn.doublefloat.CDCSonCNN.projects.system.domain.User;
import cn.doublefloat.CDCSonCNN.projects.system.service.RoleService;
import cn.doublefloat.CDCSonCNN.projects.system.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 李广帅
 * @date 2020/11/26 上午10:23
 */
@Api(tags = "学生列表接口")
@RestController
@RequestMapping("/student")
public class StudentController extends BaseController {
    @Autowired
    private UserService userService;


    /**
     * 获取学生列表
     */
    @GetMapping("/list")
    public TableDataResult list(User user) {
        startPage();
        user.setType("0");
        List<User> list = userService.selectUserList(user);
        return getTableData(list);
    }
}