package com.example.demo

import com.baomidou.mybatisplus.generator.AutoGenerator
import com.baomidou.mybatisplus.generator.config.*

class MyBatisPlusGenerator {

}

fun main(args: Array<String>) {
    val dataSourceConfig =
        DataSourceConfig.Builder("jdbc:mysql://localhost:3306/test", "root", "123456").build()
    val projectPath = System.getProperty("user.dir")
    val globalConfig = GlobalConfig.Builder().outputDir("$projectPath/src/main/kotlin").openDir(true).enableKotlin().build()
    val packageConfig = PackageConfig.Builder().moduleName("test").parent("com.example.demo").build()
    val autoGenerator = AutoGenerator(dataSourceConfig).global(globalConfig).packageInfo(packageConfig)
    autoGenerator.execute()
}