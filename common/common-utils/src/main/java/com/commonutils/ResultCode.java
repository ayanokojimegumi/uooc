package com.commonutils;

import io.swagger.v3.oas.annotations.media.Schema;

public class ResultCode {
    @Schema(title = "20000表示成功")
    public static Integer SUCCESS = 20000;
    @Schema(title = "20001表示失败")
    public static Integer ERROR = 20001;
}
