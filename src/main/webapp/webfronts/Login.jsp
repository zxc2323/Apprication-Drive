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
	
	
   .container {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin-top: 100px; /* 避免与头部重叠 */
    }

    .form-container {
        background-color: white;
        padding: 40px;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        width: 300px;
        text-align: center;
    }

    .form-container h2 {
        margin-bottom: 20px;
        font-size: 24px;
        color: #333;
    }

    .form-container input {
        width: 100%;
        padding: 10px;
        margin: 10px 0;
        border: 1px solid #ccc;
        border-radius: 4px;
        font-size: 16px;
    }

    .form-container button {
        width: 100%;
        padding: 10px;
        background-color: #007BFF;
        color: white;
        border: none;
        border-radius: 4px;
        font-size: 16px;
        cursor: pointer;
    }

    .form-container button:hover {
        background-color: #0056b3;
    }

    .form-container p {
        margin-top: 20px;
        font-size: 14px;
    }

    .form-container a {
        color: #007BFF;
        text-decoration: none;
    }

    .form-container a:hover {
        text-decoration: underline;
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


<div class="container">
    <div class="form-container">
        <h2>Login</h2>
        <form action="../Login" method="POST">
            <input  type="text" name="username" placeholder="Email" required>
            <input type="password" name="password" placeholder="Password" required>
            <button type="submit">Login</button>
        </form>
        <p>Don't have an account? <a href="Register.jsp">Register here</a></p>
    </div>
</div>











</body>
</html>