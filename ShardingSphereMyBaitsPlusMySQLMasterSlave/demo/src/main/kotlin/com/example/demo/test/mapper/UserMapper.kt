package com.example.demo.test.mapper

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.example.demo.test.entity.User
import org.apache.ibatis.annotations.Mapper

@Mapper
interface UserMapper : BaseMapper<User>