#education_service
<div>
    <p>
       远程教育系统之service层
    </p>
</div>
<div>
    <ul>
		<li>1.该层主要实现serviceapi层接口，并进行处理</li>
		<li>2.该层使用dubbo+zookeeper进行接口的发布</li>
		<li>3.dubbo配置文件是resource文件夹下的dubbo文件夹下的dubbo-spring.xml文件</li>
		<li>4.每一个接口都需要在这里进行配置并且发布（下面是配置实例）</li>
</ul>
</div>
	