package com.example.demo.group.controller

import com.example.demo.group.entity.User
import com.example.demo.group.groups.group.SignInCheckSequenceGroup
import com.example.demo.group.groups.group.SignUpCheckSequenceGroup
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/group/")
class GroupController {
    @PostMapping("sign/in")
    fun signIn(@RequestBody @Validated(SignInCheckSequenceGroup::class) user: User, result: BindingResult) =
        if (!result.hasErrors()) "valid" else StringBuilder().apply {
            result.allErrors.forEach { e ->
                append(e.defaultMessage).append('\n')
            }
        }.toString()

    @PostMapping("sign/up")
    fun signUp(@RequestBody @Validated(SignUpCheckSequenceGroup::class) user: User, result: BindingResult) =
        if (!result.hasErrors()) "valid" else StringBuilder().apply {
            result.allErrors.forEach { e ->
                append(e.defaultMessage).append('\n')
            }
        }.toString()
}