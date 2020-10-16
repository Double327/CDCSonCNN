package cn.doublefloat.CDCSonCNN.framework.security;

import cn.doublefloat.CDCSonCNN.framework.web.domain.BaseUser;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

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

    /**
     * 权限
     */
    private Set<String> permissions;

    public LoginUser(BaseUser baseUser, Set<String> permissions) {
        this.baseUser = baseUser;
        this.permissions = permissions;
    }

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
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
