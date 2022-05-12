package com.example.demo.group.groups.group

import com.example.demo.group.groups.sequence.*
import javax.validation.GroupSequence

@GroupSequence(SignUpFirstCheck::class,SignUpSecondCheck::class,SignUpThirdCheck::class)
interface SignUpCheckSequenceGroup