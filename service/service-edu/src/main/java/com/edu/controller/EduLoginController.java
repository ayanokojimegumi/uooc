package com.edu.controller;

import com.commonutils.R;
import org.springframework.web.bind.annotation.*;

/**
 * 讲师(EduTeacher)登录控制层
 *
 * @author mark
 * @since 2023-08-03 00:31:44
 */
@RestController
@RequestMapping("/eduservice/user")
@CrossOrigin
public class EduLoginController {

    /**
     * 登录
     * @return
     */
    @PostMapping("/login")
    public R login() {
        return R.ok()
                .data("token", "admin");
    }


    @GetMapping("/info")
    public R info() {
        return R.ok()
                .data("name", "admin");

    }
}
