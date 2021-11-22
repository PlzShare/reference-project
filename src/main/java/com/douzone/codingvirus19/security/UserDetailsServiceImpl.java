package com.douzone.codingvirus19.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.douzone.codingvirus19.vo.UserVo;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao userDao;
    
    @Autowired
    
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserVo userVo = userDao.get(username);
        SecurityUser securityUser = new SecurityUser();
        System.out.println(username);
        if ( userVo != null ) {
            securityUser.setName(userVo.getName());         
            securityUser.setUsername(userVo.getEmail());     // principal
            securityUser.setPassword(passwordEncoder.encode(userVo.getPassword()));  // credetial
            System.out.println(securityUser.getPassword());
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(userVo.getRole()));
            securityUser.setAuthorities(authorities);
        }

        return securityUser; // 여기서 return된 UserDetails는 SecurityContext의 Authentication에 등록되어 인증 정보를 갖고 있는다.
    }
}