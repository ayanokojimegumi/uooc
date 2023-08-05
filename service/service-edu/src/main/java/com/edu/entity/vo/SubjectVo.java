package com.edu.entity.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: mark
 * @create: 2023-08-05 23:20
 **/
@Data
public class SubjectVo {
    private String id;
    private String title;
    private List<SubjectVo> children = new ArrayList<>();
}
