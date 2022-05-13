package com.example.demo

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "用户")
class User {
    @Schema(description = "主键")
    var id: Long = 0

    @Schema(description = "用户名")
    var name: String = ""
}