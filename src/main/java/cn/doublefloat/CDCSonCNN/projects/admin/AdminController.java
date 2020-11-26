package cn.doublefloat.CDCSonCNN.projects.admin;

import cn.doublefloat.CDCSonCNN.framework.web.controller.BaseController;
import cn.doublefloat.CDCSonCNN.framework.web.page.TableDataResult;
import cn.doublefloat.CDCSonCNN.projects.system.domain.User;
import cn.doublefloat.CDCSonCNN.projects.system.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 李广帅
 * @date 2020/11/26 上午10:42
 */
@Api(tags = "管理员列表接口")
@RestController
@RequestMapping("/admin")
public class AdminController extends BaseController {

    @Autowired
    private UserService userService;

    /**
     * 获取管理员列表
     */
    @GetMapping("/list")
    public TableDataResult list(User user) {
        startPage();
        user.setType("2");
        List<User> list = userService.selectUserList(user);
        return getTableData(list);
    }
}
