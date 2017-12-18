#education_teacher
<div>
    <p>
       远程教育系统之teacher层
    </p>
</div>
<div>
    <ul>
		<li>1.该模块为教师端的控制层接口</li>
		<li>2.主要提供教师的各项操作</li>
		<li>3.该层所使用的业务层的接口来源于dubbo所发布在zookeeper集群上的接口</li>
		<li>4.该层的dubbo的配置文件是dubbo下的dubbo-spring.xml文件，配置了集群的端口+ip</li>
		<li>5.该层与学生端共用一个服务端</li>
	</ul>
</div>

	