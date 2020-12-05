package cn.doublefloat.CDCSonCNN.framework.security.handle;

import cn.doublefloat.CDCSonCNN.common.utils.ServletUtils;
import cn.doublefloat.CDCSonCNN.common.utils.StringUtils;
import cn.doublefloat.CDCSonCNN.common.utils.ip.IpUtils;
import cn.doublefloat.CDCSonCNN.framework.web.domain.AjaxResult;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;

/**
 * @author 李广帅
 * @date 2020/12/5 3:07 下午
 */
@Component
@Slf4j
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint, Serializable {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) {
        log.error("Unauthorized access: \ncurrent IP:{}\nrequest URI :{}\n", IpUtils.getIpAddr(request), request.getRequestURI());
        String msg = StringUtils.format("Unauthorized access：{}，Authentication failed, unable to access system resources ", request.getRequestURI());
        ServletUtils.renderString(response, JSON.toJSONString(AjaxResult.error(HttpStatus.UNAUTHORIZED, msg)));
    }
}
