package org.lc.springboot.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.lc.springboot.entity.pojo.VO.SpringBootBaseResultVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SystemUserController {

    @GetMapping("login")
    public SpringBootBaseResultVO login(String username, String password) {
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        token.setRememberMe(true);
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.login(token);
        return SpringBootBaseResultVO.ok("login success");
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public SpringBootBaseResultVO logout() {
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return SpringBootBaseResultVO.ok("logout success");
    }
}
