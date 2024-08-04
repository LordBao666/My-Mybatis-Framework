# 简介
此仓库是我学习Mybatis所用，参考视频为[尚硅谷SSM框架](https://www.bilibili.com/video/BV1AP411s7D7)，配套文档[Mybatis实践](https://www.wolai.com/oLP8DUTzo2JRX1DfZNZn6c)。**建议先看文档，再看视频**。

<br>

# MyBatis学习总结

**Mybatis是一个半自动的ORM持久层框架**。这里面涉及两点概念，**第一、ORM指的是Java实体到数据库表的映射**，说简单点就是程序员如何用Java去访问数据库，访问的结果又如何转换为Java实体。**第二、ORM框架分为半自动框架和全自动框架**，这部分在配套文档中有阐述，我这里简要概括：**所谓半自动框架指的是程序员仍然要担当起撰写sql的责任;全自动框架则是框架给你封装了很多访问数据库的方法，为程序员省去了写sql的麻烦**。之前学习Spring课程中的JDBCTemplate以及这里的Mybatis都是半自动框架，而全自动框架有Hibernate、Spring Data JPA、MyBatis-Plus 等。无论是全自动还是半自动框架，最终底层都会将sql语句发送到数据库。**到底用哪个框架更好？我个人认为 在全自动框架的基础上仍然给与程序员DIY sql的权利，这样才是最好的**。

尚硅谷讲述的Mybatis的使用方式是基于XML的，即一张表对应一个Java实体、Mapper接口和Mapper.xml。最终所有的Mapper.xml都需要注册在一个总的MybatisConfig.xml中。底层会根据你的Mapper接口和Mapper.xml 生成对应的JDK动态代理对象，基于此对象来对数据库进行访问。

**就单表访问而言**，专注于两个东西，即**数据输入和数据输出**。数据输入实际说的是，你的Mapper接口方法的参数可能是一个(或多个)基本类型，复杂类型，Map等等，你如何在Mapper.xml中去撰写配置；数据输出说的是你查询的结果到底以怎样的形式返回，基本类型还是复杂类型，Map，或List等，你又该在Mapper.xml中去撰写配置。

**就多表访问而言**，比如访问一个`Customer`和对应的`List<Order>`，你该如何去撰写配置文件。这里细分为了对一和对多，

| 关联关系 | 配置项关键词                              | 所在配置文件和具体位置            |
| -------- | ----------------------------------------- | --------------------------------- |
| 对一     | association标签/javaType属性/property属性 | Mapper配置文件中的resultMap标签内 |
| 对多     | collection标签/ofType属性/property属性    | Mapper配置文件中的resultMap标签内 |

所谓对一，比如一个Order只有一个对应的Customer实体；所谓对多，比如一个Customer可以对应多个Order实体，这些如何在Mapper.xml中去体现。

面对这样一种场景，用户在商城中输入若干条件，比如价格区间，品牌商，你又该如何去撰写SQL语句呢？**事实上，这就涉及到了动态SQL的概念，我们要掌握相应的Mybatis标签，如`<if>,<where>,<foreach>`等等**。

课程的最后阐述了**Mybatis的高级特性**，以解决更多的问题：

1. 如果Mapper.xml足够多，那么在MybatisConfig.xml注册会比较麻烦，因此引入Mybatis批量映射优化；
2. 使用PageHelper来实现分页功能；
3. 使用MybatisX 插件来根据数据库表逆向生成相应的实体类，Mapper，Mapper.xml以完成简单的单表访问，解放重复冗余的工作，使得程序员将核心精力放在更复杂的多表查询上。

<br>



# Mybatis学习顺序
- 入门: mybatis-quickstart
- 基本使用: mybatis-curd-practice
- 多表查询: mybatis-multiple-table
- 动态SQL: mybatis-dynamic-sql
- 高阶特性: mybatis-advanced-features