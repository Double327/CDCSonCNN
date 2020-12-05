package cn.doublefloat.CDCSonCNN.framework.security.service;

import cn.doublefloat.CDCSonCNN.common.constant.Constants;
import cn.doublefloat.CDCSonCNN.common.exception.CustomException;
import cn.doublefloat.CDCSonCNN.common.exception.user.CaptchaErrorException;
import cn.doublefloat.CDCSonCNN.common.exception.user.CaptchaExpireException;
import cn.doublefloat.CDCSonCNN.common.exception.user.UserPasswordNotMatchException;
import cn.doublefloat.CDCSonCNN.common.utils.StringUtils;
import cn.doublefloat.CDCSonCNN.framework.redis.RedisCacheService;
import cn.doublefloat.CDCSonCNN.framework.security.LoginUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

/**
 * @author 李广帅
 * @date 2020/10/16 2:17 下午
 */
@Service
@Slf4j
public class LoginService {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCacheService redisCacheService;

    /**
     * 用户登录
     *
     * @param no       学生学号、职工编号
     * @param password 密码
     * @param code     验证码
     * @param uuid     uuid
     * @return token
     */
    public String login(String no, String password, String code, String uuid) {
        // 验证码redis键值
        String verifyKey = Constants.CAPTCHA_CODE_KEY + uuid;
        // 获取验证码
        String captcha = redisCacheService.getCacheObject(verifyKey);
        // 删除验证码
        redisCacheService.deleteObject(verifyKey);
        // 判断验证码是否非空
        if (captcha == null) {
            // 抛出验证码过期异常
            throw new CaptchaExpireException();
        }
        // 判断验证码是否正确
        if (!code.equalsIgnoreCase(captcha)) {
            // 抛出验证码错误异常
            throw new CaptchaErrorException();
        }

        Authentication authentication = null;

        try {
            authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(no, password));
        } catch (Exception e) {
            if (e instanceof BadCredentialsException) {
                throw new UserPasswordNotMatchException();
            } else {
                throw new CustomException(e.getMessage());
            }
        }

        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        // 生成token
        return tokenService.createToken(loginUser);
    }
}
