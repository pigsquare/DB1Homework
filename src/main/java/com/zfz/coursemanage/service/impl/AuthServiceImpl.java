package com.zfz.coursemanage.service.impl;

import com.zfz.coursemanage.dto.AuthTokenResponseDto;
import com.zfz.coursemanage.entity.User;
import com.zfz.coursemanage.exception.AuthException;
import com.zfz.coursemanage.mapper.UserMapper;
import com.zfz.coursemanage.service.AuthService;
import com.zfz.coursemanage.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Slf4j
@Service("authService")
public class AuthServiceImpl implements AuthService {
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private UserMapper userMapper;

    @Autowired
    public AuthServiceImpl(AuthenticationManager authenticationManager, JwtUtil jwtUtil, UserMapper userMapper) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userMapper = userMapper;
    }

    //private final
    @Override
    public AuthTokenResponseDto login(@NotNull @NotBlank String username, @NotNull @NotBlank String password) throws AuthException {
        UsernamePasswordAuthenticationToken upToken=new UsernamePasswordAuthenticationToken(username,password);

        try{
            //log.info("logging in......"+upToken);
            Authentication authentication=authenticationManager.authenticate(upToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            User user=(User)authentication.getPrincipal();
            String jwtToken=jwtUtil.generateToken(user);
            return new AuthTokenResponseDto(jwtToken, jwtUtil.getExpirationDateFromToken(jwtToken).getTime(), user.getName(),user.getUsername(),user.getRole());
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

        return null;
    }

}
