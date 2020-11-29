package com.unicorn.demo.controller;

import com.unicorn.demo.domain.User;
import com.unicorn.demo.exception.CommonException;
import com.unicorn.demo.domain.DateResult;
import com.unicorn.demo.domain.Result;
import com.unicorn.demo.util.ResultUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class ExceptionHandlerController {

    @PostMapping("/update")
    public Result updateUser(@RequestParam Integer id) {
        //为了测试，这个故意让程序进入异常
        int i = 1 / 0;
        return ResultUtil.genSuccessResult();
    }

    @RequestMapping("/detail")
    public DateResult<User> queryUser(@RequestParam Integer id) {
        try {
            //为了测试，这个故意让程序进入异常
            int i = 1 / 0;
        } catch (Exception e) {
            throw new CommonException("全局异常测试");
        }

        User user = new User();
        user.setId(10);
        user.setName("张三");
        user.setEmil("1234456@qq.com");
        user.setAddress("测试地址");
        return ResultUtil.genSuccessResult(user);
    }

}
