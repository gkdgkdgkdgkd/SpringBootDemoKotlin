package com.example.demo.user.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
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

    var name: String? = ""

    var age: Int? = 20

    override fun toString(): String {
        return "User{" +
        "id=" + id +
        ", name=" + name +
        ", age=" + age +
        "}"
    }
}
