package com.example.demo.user.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableId
import java.io.Serializable

/**
 * <p>
 * 
 * </p>
 *
 * @author author
 * @since 2022-06-01
 */

class User : Serializable {

    @TableId(type = IdType.ASSIGN_ID)
    var id: Long? = null

    var name: String? = null

    var age: Int? = null

    override fun toString(): String {
        return "User{" +
        "id=" + id +
        ", name=" + name +
        ", age=" + age +
        "}"
    }
}
