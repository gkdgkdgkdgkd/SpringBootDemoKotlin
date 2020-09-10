# Hibernate Validator Demo


# 特别说明

自定义`AOP`测试了一下并不能实现，查阅了很多资料，有的是说加上一个`kapt`插件，官方文档是加上一个`org.jetbrains.kotlin:kotlin-allopen`插件，修改了相关配置之后还是不行，因此`aop`包下的文件都注释了。

另外参考了[该仓库](https://github.com/KotlinSpringBoot/demo2_aop_logging)，这个是能实现的，但是是在`JDK8`上，笔者在该仓库的基础上修改了一下配置，在`JDK11`上能运行，但是本仓库的`demo`却失败。

望热心人士可以提个`PR`修复一下，笔者能力有限，感激不尽。
