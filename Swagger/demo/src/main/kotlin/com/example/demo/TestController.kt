package com.example.demo

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@Tag(name = "测试接口")
class TestController {
    @GetMapping("test")
    @Operation(description = "测试",tags = ["测试接口"])
    fun test() = "success"

    @GetMapping("test2")
    @Operation(description = "测试2",tags = ["测试接口", "2号测试接口"])
    @Parameter(description = "必须参数")
    fun test2(@RequestParam parm:String){}

    @GetMapping("test3")
    @Operation(description = "带有返回状态的接口",tags = ["测试接口"])
    @ApiResponses(value = [
        ApiResponse(responseCode = "111", description = "测试成功"),
        ApiResponse(responseCode = "222", description = "测试失败")
    ])
    fun test3(@RequestBody body:String){}

    @GetMapping("test4")
    @Operation(description = "User接口",tags = ["测试接口"])
    @ApiResponse(responseCode = "100",description = "操作成功")
    fun test4(@RequestBody user:User){}
}