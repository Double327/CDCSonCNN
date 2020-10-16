package cn.doublefloat.CDCSonCNN.framework.security;

import cn.doublefloat.CDCSonCNN.framework.web.domain.BaseUser;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author 李广帅
 * @date 2020/7/21 6:19 下午
 */
@Data
public class LoginUser implements UserDetails {

    /**
     * token令牌
     */
    private String token;

    /**
     * 登录时间
     */
    private Long loginTime;

    /**
     * 失效时间
     */
    private Long expireTime;

    /**
     * 学生、教师、管理员信息
     */
    private BaseUser baseUser;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return baseUser.getPassword();
    }

    @Override
    public String getUsername() {
        return baseUser.getNo();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
