package com.example.demo.user.entity

import java.io.Serializable

/**
 * <p>
 *
 * </p>
 *
 * @author author
 * @since 2022-05-23
 */
class User : Serializable {

    var id: Long? = null

    var name: String? = null

    override fun toString() = "User{id:$id,name:$name}"
}
