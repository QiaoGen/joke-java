个人学习笔记

问题:
    1.springboot相较于spring 配置文件带来了很大的提升,但是如何保留配置文件的灵活属性又能保证在'配置中配置',这是一个问题,
    例如shiro的Configuration中如何区分dev or prod?如果使用@ConditionalOnProperty配置不同的'配置类',那么也将毫无意义