#education（一个前后端分离开发的项目 前台使用Vue工程）
<div>
    <h2>
        Spring+SpringMVC+MyBatis+Shiro+MySQL+Vue.js+dubbo+zookeeper实现的远程教育系统
    </h2>
    <h2> 1.这是一个后台的管理系统的后台数据接口提供</h2>
</div>
<div>
    <h2>2.当你进入该项目时，你能看到几个目录结构（本系统后台采用Maven多模块）</h2>
    <ul>
        <li>（1）education根模块</li>
      	 <li>（2）education-model模块，用来存储实体bean对象</li>  
        <li>（3）education-dao模块，提供数据层，与Mybatis结合</li>
        <li>（4）education-serviceapi模块，用来提供业务层接口</li>
        <li>（5）education-service模块，用来实现业务层接口（该模块使用Dubbo服务端进行打包发布，详细请看该模块的ReadMe）</li>
         <li>（6）education-teacher模块，教师端控制层（web层），用来提供教师端的控制层URL以及数据返回和接收的入口（采用Dubbo客户端进行数据获取）</li>
      	 <li>（7）education-student模块，学生端控制层（web层），用来提供学生端的控制层URL以及数据返回和接收的入口（采用Dubbo客户端进行数据获取）</li>  
        <li>（8）education-util模块，该层主要提供公用的工具类</li>
    </ul>
    <h2>3.本系统采用zookeeper集群进行服务端的发布</h2>
</div>
