package com.edu.controller;


import com.commonutils.R;
import com.edu.client.VodClient;
import com.edu.entity.vo.video.VideoInfoFormVo;
import com.edu.service.EduVideoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * 课程视频(EduVideo)表控制层
 *
 * @author mark
 * @since 2023-08-06 13:01:01
 */
@RestController
@RequestMapping("eduservice/video")
@CrossOrigin
@Tag(name = "EduVideoController", description = "课程视频(EduVideo)表控制层")
public class EduVideoController {
    /**
     * 服务对象
     */
    @Resource
    private EduVideoService eduVideoService;

    /**
     * 接收前端封装的视频对象，新增视频信息
     * @param videoInfoFormVo 前端发送的视频对象
     */
    @Operation(summary = "新增课时信息",description = "接收前端封装的视频对象，新增视频信息",
            parameters = {@Parameter(name = "videoInfoFormVo", description = "前端发送的课时信息")})
    @ApiResponse(description = "返回R对象", responseCode = "包含状态码，是否成功及返回的详细数据")
    @PostMapping
    public R saveVideoInfo(@RequestBody VideoInfoFormVo videoInfoFormVo) {
        eduVideoService.saveVideoInfo(videoInfoFormVo);
        return R.ok();
    }

    /**
     * 接收前端封装的视频对象，修改视频信息
     * @param videoInfoFormVo 前端发送的视频对象
     */
    @Operation(summary = "修改课时信息",description = "接收前端封装的视频对象，修改视频信息",
            parameters = {@Parameter(name = "videoInfoFormVo", description = "前端发送的课时信息")})
    @ApiResponse(description = "返回R对象", responseCode = "包含状态码，是否成功及返回的详细数据")
    @PutMapping
    public R updateVideoById(@RequestBody VideoInfoFormVo videoInfoFormVo) {
        eduVideoService.updateVideoById(videoInfoFormVo);
        return R.ok();
    }

    /**
     * 根据课时id查询相应的课时信息，并封装到videoInfoFormVo对象，返回给前端
     * @param id 课时id
     */
    @Operation(summary = "查询课时信息",description = "根据id查询课时信息",
            parameters = {@Parameter(name = "id", description = "课时id")})
    @ApiResponse(description = "返回R对象", responseCode = "包含状态码，是否成功及返回的详细数据")
    @GetMapping("/{id}")
    public R getVideoById(@PathVariable("id") String id) {
        VideoInfoFormVo infoFormVo = eduVideoService.getVideoById(id);
        return R.ok().data("infoFormVo", infoFormVo);
    }

    /**
     * 根据课时id删除相应的课时信息
     * @param id 课时id
     */
    @Operation(summary = "删除课时信息",description = "根据id删除课时信息",
            parameters = {@Parameter(name = "id", description = "课时id")})
    @ApiResponse(description = "返回R对象", responseCode = "包含状态码，是否成功及返回的详细数据")
    @DeleteMapping("/{id}")
    @Transactional
    public R deleteVideoByid(@PathVariable("id") String id) {
        boolean flag = eduVideoService.deleteVideoById(id);
        if (flag) {
            return R.ok();
        } else {
            return R.error().message("删除失败");
        }
    }

}

