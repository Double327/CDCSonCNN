package cn.doublefloat.CDCSonCNN.common.utils;

import cn.doublefloat.CDCSonCNN.common.exception.CustomException;
import cn.doublefloat.CDCSonCNN.framework.security.LoginUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author 李广帅
 * @date 2020/11/6 2:56 下午
 */
@Slf4j
public class SecurityUtils {

    public static Long getUserId() {
        return getLoginUser().getUser().getId();
    }

    public static LoginUser getLoginUser() {
        try {
            return (LoginUser) getAuthentication().getPrincipal();
        } catch (Exception e) {
            throw new CustomException("获取用户信息异常", org.springframework.http.HttpStatus.UNAUTHORIZED);
        }
    }

    public static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public static boolean isAdmin(Long userId) {
        return userId != null && 1L == userId;
    }

    public static String encryptPassword(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }

    public static boolean matchesPassword(String password1, String password2) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(password1, password2);
    }

    public static void main(String[] args) {
        System.out.println(encryptPassword("123456"));
    }
}
