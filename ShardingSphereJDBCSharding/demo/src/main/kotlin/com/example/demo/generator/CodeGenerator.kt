package com.example.demo.generator

import com.baomidou.mybatisplus.generator.FastAutoGenerator
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine

fun main(args: Array<String>) {
    val userTableName = "User"
    FastAutoGenerator.create("jdbc:mysql://localhost:3306/test0", "root", "123456")
        .globalConfig { builder ->
            builder.author("author").outputDir(System.getProperty("user.dir") + "/src/main/kotlin").enableKotlin()
                .build()
        }.packageConfig { builder ->
            builder.parent("com.example.demo").moduleName("user").build()
        }.strategyConfig { builder ->
            builder.addInclude("user0")
                .entityBuilder().convertFileName { userTableName }
                .mapperBuilder().enableMapperAnnotation().convertMapperFileName { userTableName + "Mapper" }
                .convertXmlFileName { userTableName + "Mapper" }
                .serviceBuilder().convertServiceFileName { "I" + userTableName + "Service" }
                .convertServiceImplFileName { userTableName + "Service" }
                .controllerBuilder().enableRestStyle().convertFileName { userTableName + "Controller" }
        }.templateEngine(FreemarkerTemplateEngine()).execute()
}