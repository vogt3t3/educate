package com.education.teacher.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import com.education.model.User;
import com.education.service.IUserService;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * 用户的控制层
 * 
 * @author Administrator
 *
 */
@RestController
@RequestMapping(value="/users")     // 通过这里配置使下面的映射都在/users下，可去除
public class UserController {

    /**
     * 注入用户的业务层
     */
    @Reference
    private IUserService iuserService;

    /**
     * @return String
     * @throws Exception
     */
    @RequestMapping("/list")
    public String listUserByName() throws Exception {
        System.out.println("44545");
        System.out.println(iuserService);
        PageInfo<User> pro = iuserService.queryByPage("lisi", 1, 5);
        List<User> users = pro.getList();
        for (User user : users) {
            /*System.out.println(user.getUsername());*/
        }
        return "";
    }

    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());
    @ApiOperation(value="获取用户列表", notes="直接获取")
    @RequestMapping(value={"/getlist"}, method=RequestMethod.GET)
    public List<User> getUserList() {
        List<User> r = new ArrayList<User>(users.values());
        return r;
    }
    
    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @RequestMapping(value="/create", method=RequestMethod.POST)
    public String postUser(@RequestBody User user) {
        return "success";
    }

}
