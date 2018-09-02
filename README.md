# AndroidModule
android 组件化 demo
# Android组件化配置
![images](https://github.com/Wiser-Wong/AndroidModule/blob/master/images/module.png)
由于我这个是已经完成了组件化配置了所以onemodule和twomodule是属于了与app module平级的module文件而不是Android library了,可以看文件夹图标显示,但是第一次创建这几个文件的时候都是创建Android library module.

# tip:组件化即是多个library Module组成
### 1.创建属于自己的组件library module
### 2.创建一个公共的library module库用于存放公共的依赖库以及一些公共的base类和一些基本的Utils
### 3.每一个组件library module 都需要依赖这个公共的library库
### 4.主工程app也要依赖这个公共的library库
### 5.为了区分使用组件还是集成需要进行判断运行,在项目根目录下有gradle.properties文件 可用于存放全局常量,在该文件中定义一个常量isModule=true，是否要使用组件化开发,第一次增加该常量需要构建一下才能生效,每次修改都要Sync Now一下才会生效.
### 6.主工程的结构代码不变,只有app module下的build.gradle文件需要声明什么时候依赖组件library module
![images](https://github.com/Wiser-Wong/AndroidModule/blob/master/images/app_gradle.png)
### 7.组件化library module 工程结构需要变化 每一个组件化的library 基本都是一样结构,在onemodule组件中main路径下的Java路径下创建一个文件夹debug与onemodule组件包路径同级
[image:0A77CF6C-EA27-45E9-8782-0E3D11C73A18-490-00000173BA251B8A/15291233-25E0-4399-B964-E33EBD6B38E6.png]
用于存放一些假数据公共的测试工具之类的一些不需要最终打集成包用到的类文件.
### 8.在onemodule组件library中main路径下创建一个文件夹与java 平级永于存放AndroidManifest.xml文件,没有该文件不会生成组件module,必须指定默认启动的Activity 因为是单独的一个组件需要单独运行，必须指定启动Activity
[image:D7D6063C-8A78-43C8-837E-38B9DD42D155-490-000001215F5E2047/5DB12726-DE70-44FF-960E-B667EB896172.png]
然后AndroidManifest.xml文件中代码如下
[image:62944F1F-A08D-4F5A-8A94-8300CFF6AEA2-490-000001322355F24B/2374492F-614A-4FB7-B7F6-2C8E093A8EBE.png]
### 9.在onemodule组件下默认生成的AndroidManifest.xml文件中修改自己的Activity注册 application用统一的风格就行了也可以修改其他风格,但是最终集成的时候需要与主工程风格一致所以保持一致就可以了
[image:137AC78D-F920-439E-84B1-E137547811B8-490-0000019C0D14A6E6/E2FE3151-8B4C-452F-AAC4-03B8A1A15CA6.png]
### 10.然后就是onemodule 下的build.gradle文件的修改，这个时候isModule就有用武之地了，插件判断是组件化使用library插件否则用application
[image:58968862-25E0-48AA-B79D-BEFDDB22D4C2-490-000001CA9047858E/22215573-7A1A-425D-A6C3-678E97A6C7EE.png]
### 11.其次就是需要注册AndroidManifest.xml在build.gradle中
[image:261BE428-1A30-4FD6-868B-9241F5BE67C3-490-000001E143E5EF6D/2918C355-9063-4846-A946-5EB844722BD4.png]
因为之前创建的debug文件夹下是一些测试用的数据所以集成打包的时候删除掉debug文件夹 
### 12.其他组件library基本和onemodule配置一样
### 13.现在说一下公共组件我命名为Common library module 里面存放一些公共的属性 theme 基类 工具类和依赖库等等一些公共的东西所有组件module和猪app module都依赖此组件 使用其内部的工具
13.至此组件化开发的配置基本完成
