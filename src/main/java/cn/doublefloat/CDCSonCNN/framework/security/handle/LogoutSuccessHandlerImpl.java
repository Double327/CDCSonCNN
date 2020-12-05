package cn.doublefloat.CDCSonCNN.framework.security.handle;

import cn.doublefloat.CDCSonCNN.common.utils.ServletUtils;
import cn.doublefloat.CDCSonCNN.common.utils.StringUtils;
import cn.doublefloat.CDCSonCNN.framework.security.LoginUser;
import cn.doublefloat.CDCSonCNN.framework.security.service.TokenService;
import cn.doublefloat.CDCSonCNN.framework.web.domain.AjaxResult;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 李广帅
 * @date 2020/12/5 2:57 下午
 */
@Configuration
public class LogoutSuccessHandlerImpl implements LogoutSuccessHandler {

    @Autowired
    private TokenService tokenService;

    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        LoginUser loginUser = tokenService.getLoginUser(httpServletRequest);
        if (StringUtils.isNotNull(loginUser)) {
            String userName = loginUser.getUsername();
            // 删除用户缓存记录
            tokenService.delLoginUser(loginUser.getToken());
        }
        ServletUtils.renderString(httpServletResponse, JSON.toJSONString(AjaxResult.error(HttpStatus.OK, "退出成功")));
    }
}
