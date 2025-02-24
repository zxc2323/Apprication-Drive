<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "metier.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Detail</title>

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

    .Detail-Produit {
        margin-top: 120px; /* 留出顶部导航栏的空间 */
        display: flex;
        justify-content: center;
        align-items: center;
        padding: 20px;
    }

    .product-container {
        background-color: #fff;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        padding: 20px;
        max-width: 400px;
        width: 100%;
        text-align: center;
    }

    .product-image {
        max-width: 100%;
        height: auto;
        border-radius: 10px;
    }

    .product-name {
        font-size: 24px;
        font-weight: bold;
        margin: 15px 0;
    }

    .product-price {
        font-size: 20px;
        color: #e67e22;
        margin: 10px 0;
    }

    .quantity-selector {
        margin: 20px 0;
    }

    .quantity-selector label {
        font-size: 16px;
        margin-right: 10px;
    }

    .quantity-selector input {
        width: 60px;
        padding: 5px;
        font-size: 16px;
        border: 1px solid #ccc;
        border-radius: 5px;
    }

    .buttons {
        display: flex;
        justify-content: space-between;
        margin-top: 20px;
    }

    .buttons button {
        padding: 10px 20px;
        font-size: 16px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }

    .add-to-cart {
        background-color: #3498db;
        color: #fff;
    }

    .add-to-cart:hover {
        background-color: #2980b9;
    }

    .add-to-wishlist {
        background-color: #e74c3c;
        color: #fff;
    }

    .add-to-wishlist:hover {
        background-color: #c0392b;
    }
</style>
</head>
<body>
<div class="Title"> 
    <div class="logo"><img src="./css/images/logo.png" width="100" height="80"></div>
    <div class="nav-links"> 
        <a class="nav-link" href="Index">Home</a>
        <a class="nav-link" href="Produit">Shop</a>
        <a class="nav-link" href=""> <img src="./css/images/fangdajing.png" width="30" height="30"></a>
        <a class="nav-link" href="Cart">My Cart</a>
        <a class="nav-link" href="Login">Login</a>
    </div>
</div>
<% Produit p = (Produit)request.getAttribute("p"); %>
<div class="Detail-Produit">
    <div class="product-container">
       
        <img src="./css/images/exp.jpg" alt="Product Image" class="product-image">

       
        <div class="product-name"><%=p.getLibellePro() %></div>
		<p hidden id="hidden"><%=p.getIdPro() %></p>
      
        <div class="product-price">Prix Unitaire : <%=p.getPrixUnitaire() %></div>
        <div class="product-price">Prix Kg : <%=p.getPrixKg() %></div>
      

     
        <div class="quantity-selector">
            <label for="quantity">Quantity:</label>
            <input type="number" id="quantity" name="quantity" min="1" value="1">
        </div>

        
        <div class="buttons">
            <button class="add-to-cart" onclick="addToCart()">Add to Cart</button>
            <button class="add-to-wishlist" onclick="addToWishlist()">Add to ListCourse</button>
        </div>
    </div>
</div>

<script>
    function addToCart() {
        const productId = document.getElementById('hidden').textContent;
        const quantity = document.getElementById('quantity').value;


        fetch('ComfirmerPanier', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                productId: parseInt(productId),
                quantity: parseInt(quantity)
            })
        })
        .then(response => {
            if (response.ok) {
                return response.json();
            } else {
                throw new Error('Failed to add to cart');
            }
        })
        .then(data => {
            alert(data.message); // 显示后端返回的消息
        })
        .catch(error => {
            console.error('Error:', error);
            alert('Failed to add to cart. Please try again.');
        });
        // 这里可以添加实际的加入购物车逻辑，例如发送 AJAX 请求
    }

    // 加入收藏逻辑
    function addToWishlist() {
        alert('Added to wishlist!');
        // 这里可以添加实际的加入收藏逻辑，例如发送 AJAX 请求
    }
</script>
</body>
</html>