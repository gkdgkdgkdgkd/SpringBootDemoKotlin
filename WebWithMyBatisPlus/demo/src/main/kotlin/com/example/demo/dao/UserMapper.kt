package com.example.demo.dao

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.example.demo.entity.User
import org.springframework.stereotype.Service

@Service
// 因为有了MyBatisPlusConfig,不加这个@Service也可以正常运行
// 加这个@Service主要是防止IDEA出现No Beans警告
interface UserMapper:BaseMapper<User>