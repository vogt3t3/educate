<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">


<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
<style type="text/css">
a {
	
}
</style>
<body>

	<div>
		<div class="row">
			<div class="col-md-12 text-center">
				<h1>报名 信 息 填 写</h1>
				<hr />
			</div>
		</div>

		<div class="row">
			<div class="col-md-1"
				style="margin: 20px 0 0 60px; border: 1px solid CadetBlue; height: 400px; width: 200px;">
				<ul class="list-unstyled">
					<li><h3>
							<a>报名须知</a>
						</h3></li>
					<hr />
					<li><h3>
							<a>报名</a>
						</h3></li>
					<hr />
					<li><h3>
							<a>查询</a>
						</h3></li>
					<hr />
					<li><h3>
							<a>在线测试</a>
						</h3></li>
					<hr />
					<li><h3>
							<a>缴费</a>
						</h3></li>
				</ul>
			</div>
			<div class="col-md-10"
				style="margin: 20px 0 0 10px; border: 1px solid CadetBlue; height: 680px; width: 1200px;">
                <div style="width:700px;">
				<!-- 报名表单 -->
				<form style="margin:40% 0 0 30%">
				<button type="submit" class="btn btn-primary">身份证号</button> &nbsp;&nbsp;&nbsp;&nbsp;   
                    <label for="exampleInputPassword1">身份证号码:</label><input type="text" name="textone" id="input01"/>
					 <button type="reset" class="btn btn-danger" onClick="chaxun()">输入</button>
					 <span id="font"></span>
					
				</form>
                </div>
				<!-- 报名表单  end-->
			</div>

			<!-- 底部 -->
			<div class="row">
				<hr />
				<div class="col-md-12 text-center">
					<h4>©2017 yawushan 使用前必读 | 华育远程教育平台 | 合作平台</h4>
				</div>
				<hr />
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">

function chaxun(){
  serach=$("#input01").val();
  	 $.ajax({
			type:"POST",
     		url:"/api/cx",
     		dataType:"text",
     		data:"serach="+serach+"",
     		success : function(cxxy){
     			console.log(cxxy)
     		        if(cxxy==1){
     		           $("#font").html("");
     		          $("#font").css({ color: "green"});
                       $("#font").html("审核通过");
     		         }else{
     		        	$("#font").html("");
     		        	 $("#font").css({ color: "red"});
                        $("#font").html("审核未通过");
                       
     		        }
                    
     			  }
			 }); 
  

}
</script>
</html>
