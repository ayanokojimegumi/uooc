package com.commonutils;

import io.swagger.v3.oas.annotations.media.Schema;

public class ResultCode {
    @Schema(title = "1表示成功")
    public static Integer SUCCESS = 0;
    @Schema(title = "0表示成功")
    public static Integer ERROR = 1;
}
