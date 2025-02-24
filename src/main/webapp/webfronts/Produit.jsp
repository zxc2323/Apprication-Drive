<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "metier.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
    .Title {
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
        width: 30%;
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

    .image-container {
        margin-top: 150px; /* 与头部的间距 */
        position: relative;
        height: 400px;
    }
    .image-container img {
        width: 100%;
        height: 100%;
        object-fit: cover;
    }
    .image-container::after {
        content: "shop";
        position: absolute;
        top: 50%;
        left: 15%;
        transform: translate(-50%, -50%);
        color: white;
        font-size: 48px;
        font-weight: bold;
        text-align: center;
        background-color: rgba(0, 0, 0, 0);
        padding: 10px;
    }

    .content-container {
        display: flex; /* 使用flex布局 */
        margin-top: 20px; /* 与图片的间距 */
    }

    .sort-title {
        flex: 70%; /* sort-title占据70%宽度 */
        font-size: 16px;
        display: relative;
        gap: 20px; /* 元素之间的间距 */
    }

    .Rayon {
        flex: 30%; /* Rayon占据30%宽度 */
        padding: 20px; /* 添加内边距 */
        background-color: #f9f9f9; /* 背景颜色 */
        box-shadow: -2px 0 5px rgba(0, 0, 0, 0.1); /* 添加阴影 */
    }

    .search-container {
        display: inline-block;
        
        gap: 10px; /* 输入框和按钮之间的间距 */
    }

    .search-input {
    	margin-left:100px;
        width: 40%; /* 宽度 */
        height: 80%; /* 高度 */
        padding: 10px; /* 内边距 */
        border: 2px solid #333; /* 边框 */
        border-radius: 5px; /* 圆角 */
        font-size: 16px; /* 字体大小 */
        background-color: #1a1a1a; /* 高级黑背景 */
        color: #fff; /* 文字颜色 */
        outline: none; /* 移除默认轮廓 */
    }

    .search-input::placeholder {
        color: #999; /* 占位符颜色 */
    }

    .search-input:focus {
        border-color: #007BFF; /* 聚焦时边框颜色 */
    }

    .search-button {
    	
        width: 100px; /* 宽度 */
        height: 50px; /* 高度 */
        background-color: #333; /* 按钮背景 */
        color: #fff; /* 文字颜色 */
        border: none; /* 移除边框 */
        border-radius: 5px; /* 圆角 */
        font-size: 16px; /* 字体大小 */
        cursor: pointer; /* 鼠标指针样式 */
        transition: background-color 0.3s ease; /* 背景色过渡效果 */
    }

    .search-button:hover {
        background-color: #007BFF; /* 鼠标悬停时背景色 */
    }

    .typebutton {
        display: block;
        width: 100%;
        padding: 10px;
        margin: 5px 0;
        background-color: #fff;
        border: 1px solid #ddd;
        border-radius: 5px;
        cursor: pointer;
        text-align: left;
    }

    .typebutton:hover {
        background-color: #f1f1f1;
    }
    
    .product-container {
        display: flex; /* 使用flex布局 */
        flex-wrap: wrap; /* 允许换行 */
        gap: 20px; /* 产品之间的间距 */
        padding: 20px; /* 内边距 */
    }

    .product-card {
        flex: 1 1 calc(25% - 20px); /* 每行显示4个产品，减去间距 */
        box-sizing: border-box; /* 包含内边距和边框 */
        border: 1px solid #ddd; /* 边框 */
        border-radius: 8px; /* 圆角 */
        padding: 15px; /* 内边距 */
        background-color: #fff; /* 背景颜色 */
        text-align: center; /* 文字居中 */
    }

    .product-card img {
        max-width: 240px; /* 图片最大宽度 */
        height: auto; /* 图片高度自适应 */
        border-radius: 8px; /* 圆角 */
    }

    .product-card h3 {
        font-size: 18px; /* 标题字体大小 */
        margin: 10px 0; /* 上下外边距 */
    }

    .product-card p {
        font-size: 14px; /* 描述字体大小 */
        color: #555; /* 文字颜色 */
    }

    .product-card .price {
        font-size: 16px; /* 价格字体大小 */
        font-weight: bold; /* 加粗 */
        color: #007BFF; /* 价格颜色 */
    }    
</style>

</head>
<body>
<div class="Title"> 
    <div class="logo"><img src="./css/images/logo.png" width="100" height="80"></div>
    <div class="nav-links"> 
        <a class="nav-link" href="Index">Home</a>
        <a class="nav-link" href="">Shop</a>
        <a class="nav-link" href=""> <img src="./css/images/fangdajing.png" width="30" height="30"></a>
        <a class="nav-link" href="">My Cart</a>
        <a class="nav-link" href="Login">Login</a>
    </div>
</div>

<div class="image-container">
    <img src="./css/images/shop-top.jpg">
</div>

<div class="content-container">
    <div class="sort-title">
        <label for="sort" style="margin-top:8px;">Sort by : </label>
        <select id="sort" name="sort" style="font-size: 16px; height:40px;">
            <option>prix:High -> Low</option>
            <option>prix:Low -> High</option>
        </select>
        <div class="search-container">
            <input type="text" class="search-input" placeholder="Search">
            <button class="search-button">Search</button>
        </div>
        
		<div class="product-container">
		    <%
		    ArrayList<Produit> ListP = (ArrayList<Produit>)request.getAttribute("ListP");
		    for(int i=0; i<ListP.size(); i++) {
		    %>
		    <div class="product-card">
		        <img src="./css/images/exp.jpg">
		        <h3><a href="./DetailProduit?id=<%=ListP.get(i).getIdPro()%>"> <%= ListP.get(i).getLibellePro() %></a></h3>
		        <p><%= ListP.get(i).getPrixKg() %></p>
		        
		    </div>	
		    <%
		    }
		    %>
		</div>
        
    </div>

    <div class="Rayon">
        <h2>Rayon</h2>
        <%
        ArrayList<Rayon> ListR = (ArrayList<Rayon>)request.getAttribute("ListR");
        ArrayList<Categorie> ListC = (ArrayList<Categorie>)request.getAttribute("ListC");
        for(int i=0; i<ListR.size(); i++) {
        %>
        <br>
        <button class="typebutton"><%= ListR.get(i).getNomRayon() %></button>	
        <br>
        <%
        for(int j=0; j<ListC.size(); j++) {
            if(ListC.get(j).getRayon().getIdRayon() == ListR.get(i).getIdRayon()) {
        %>		
        <button class="typebutton"><%= ListC.get(j).getNomCate() %></button>
        <%	
            }
        }
        }
        %>
    </div>
    
    
</div>

</body>
</html>