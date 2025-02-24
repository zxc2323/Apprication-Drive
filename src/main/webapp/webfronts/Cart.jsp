<%@page import="java.awt.RenderingHints.Key"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.HashMap" %>
<%@ page import = "metier.*" %>
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
	        body {
            font-family: 'Arial', sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }

	        /* 购物车容器 */
        .cart-container {
 
            background-color: #ffffff;
            border-radius: 12px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
            width: 800px;
            padding: 24px;
        }

        /* 购物车标题 */
        .cart-title {
            font-size: 24px;
            font-weight: bold;
            color: #333;
            margin-bottom: 20px;
        }

        /* 商品列表 */
        .cart-items {
            margin-bottom: 24px;
        }

        /* 单个商品 */
        .cart-item {
            display: flex;
            align-items: center;
            padding: 16px;
            border-bottom: 1px solid #eee;
        }

        .cart-item:last-child {
            border-bottom: none;
        }

        /* 商品图片 */
        .cart-item img {
            width: 80px;
            height: 80px;
            border-radius: 8px;
            margin-right: 16px;
        }

        /* 商品信息 */
        .item-info {
            flex: 1;
        }

        .item-info h3 {
            font-size: 18px;
            margin: 0 0 8px;
            color: #333;
        }

        .item-info p {
            font-size: 14px;
            color: #666;
            margin: 0;
        }

        /* 数量调整 */
        .quantity-control {
            display: flex;
            align-items: center;
        }

        .quantity-control button {
            background-color: #007bff;
            color: #fff;
            border: none;
            width: 30px;
            height: 30px;
            border-radius: 50%;
            cursor: pointer;
            font-size: 16px;
            display: flex;
            align-items: center;
            justify-content: center;
            margin: 0 8px;
        }

        .quantity-control button:hover {
            background-color: #0056b3;
        }

        .quantity-control input {
            width: 50px;
            text-align: center;
            border: 1px solid #ddd;
            border-radius: 4px;
            padding: 5px;
            font-size: 14px;
        }

        /* 删除按钮 */
        .remove-item {
            color: #ff4d4d;
            cursor: pointer;
            font-size: 14px;
            margin-left: 16px;
        }

        .remove-item:hover {
            text-decoration: underline;
        }

        /* 总价区域 */
        .cart-total {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 16px;
            background-color: #f8f9fa;
            border-radius: 8px;
            margin-top: 24px;
        }

        .cart-total h3 {
            font-size: 20px;
            margin: 0;
            color: #333;
        }

        .cart-total p {
            font-size: 18px;
            font-weight: bold;
            margin: 0;
            color: #007bff;
        }

        /* 结算按钮 */
        .checkout-button {
            width: 100%;
            background-color: #28a745;
            color: #fff;
            border: none;
            padding: 12px;
            font-size: 16px;
            border-radius: 8px;
            cursor: pointer;
            margin-top: 16px;
        }

        .checkout-button:hover {
            background-color: #218838;
        }
</style>

</head>
<body>
<div class="Title"> 
<div class="logo"><img  src="./css/images/logo.png" width="100" height="80"></div>
<div class="nav-links"> 
<a class="nav-link" href="Index">Home</a>
<a class="nav-link" href="">Shop</a>
<a class="nav-link" href=""> <img src="./css/images/fangdajing.png" width="30" height="30"></a>
<a class="nav-link" href="">My Cart</a>
<a class="nav-link" href="Login">Login</a>
</div>
</div> 

    <div class="cart-container">

        <div class="cart-title">Your Shopping Cart</div>
		<%
		float prix =(float) request.getAttribute("prix");
		HashMap<Produit,Integer> LP = (HashMap<Produit,Integer>)request.getAttribute("LP");
		if(LP!=null){
		for (HashMap.Entry<Produit, Integer> entry : LP.entrySet()) {
			Produit key = entry.getKey();
	        Integer value = entry.getValue();
	       	%>	

        <div class="cart-items">
     
            <div class="cart-item">
                <img src="./css/images/exp.jpg">
                <div class="item-info">
                    <h3><%=key.getLibellePro() %></h3>
                    <p><%=key.getPrixUnitaire()*value %></p>
                </div>
                <div class="quantity-control">
                    <button onclick="updateQuantity(this, -1)">-</button>
                    <input type="number" value="1" min="1" onchange="updateTotal()">
                    <button onclick="updateQuantity(this, 1)">+</button>
                </div>
                <div class="remove-item" onclick="removeItem(this)">Remove</div>
            </div>

<%}}%>

        
        <div class="cart-total">
            <h3>Total</h3>
            <p id="total-price"><%=prix %></p>
        </div>

        <button class="checkout-button" onclick="checkout()">Comfirmer</button>
        <button class="checkout-button" onclick="checkout()">Proceed to Checkout</button>
    </div>

    <script>
        
        function updateQuantity(button, change) {
            const input = button.parentElement.querySelector('input');
            let quantity = parseInt(input.value);
            quantity += change;
            if (quantity < 1) quantity = 1;
            input.value = quantity;
            updateTotal();
        }

        
        function removeItem(button) {
            const item = button.closest('.cart-item');
            item.remove();
            updateTotal();
        }

       
        function updateTotal() {

        }

        
        function checkout() {
            alert('Thank you for your purchase!');
           
        }

        
        
    </script>





</body>
</html>