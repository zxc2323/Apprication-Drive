<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>

.Title{
	position: fixed;
	    top: 0;
	    left: 0;
	    width: 100%;
	    background-color: white; /* 头部的背景颜色 */
	    color: black; /* 文字颜色 */
	    padding: 10px 0;
	    display: flex; /* 使用flex布局 */
	    align-items: center; /* 垂直居中 */
	    justify-content: flex-start; /* 从左侧开始排列 */
	    z-index: 1000; /* 确保头部在其他内容之上 */
	    }
	.logo {
		width:30%;
	    margin-left: 100px; /* 左侧外边距 */
	    margin-top: 20px;
	  }
	  .nav-links {
	  display: flex; /* 使用flex布局 */
	  justify-content: space-around; /* 平均分布导航链接 */
	  flex-grow: 1; /* 允许导航链接占据剩余空间 */
	  margin-left: 20px; /* 导航链接与logo的间隔 */
	}

	.nav-link {
	  text-decoration: none; /* 去除下划线 */
	  color: black; /* 链接颜色 */
	  padding: 0 15px; /* 添加内边距 */
	}
</style>

</head>
<body>
<div class="Title"> 
<div class="logo"><img  src="../css/images/logo.png" width="100" height="80"></div>
<div class="nav-links"> 
<a class="nav-link" href="">Home</a>
<a class="nav-link" href="">Shop</a>
<a class="nav-link" href=""> <img src="../css/images/fangdajing.png" width="30" height="30"></a>
<a class="nav-link" href="">My Cart</a>
<a class="nav-link" href="Login">Login</a>
</div>
</div> 
</body>
</html>