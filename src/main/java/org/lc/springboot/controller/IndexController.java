package org.lc.springboot.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.lc.springboot.entity.pojo.VO.SpringBootBaseResultVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 主界面
 * @author lc
 * @date 2018-12-17 16:08:25
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController
public class IndexController {

    /**
     * 欢迎界面
     * @return 欢迎信息
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public SpringBootBaseResultVO toIndex() {
        return SpringBootBaseResultVO.ok("welcome to my demo");
    }

    @RequestMapping("test")
    @RequiresPermissions("test")
    public SpringBootBaseResultVO testPermission() {
        return SpringBootBaseResultVO.ok("permission test success");
    }

}
