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
.billboard-container {
    width: 100%;
    overflow: hidden;
    position: relative;
}

.billboard {
    display: flex;
    width: 200%; /* 两个广告页的宽度总和 */
    transition: transform 0.5s ease-in-out; /* 平滑过渡效果 */
    filter: brightness(1.25);
}

.billboard-page {
    width: 50%; /* 每个广告页占一半宽度 */
    height: 1000px; /* 广告页的高度 */
    display: flex;
    align-items: center;
    justify-content: center;
    flex-direction: column;
   
}

.billboard-container .prev-button,.billboard-container .next-button {
	background-color: #859910;
	color:white;
	display: grid;
  	place-items: center; 
    position: absolute;
    top: 50%;
    transform: translateY(-50%);
    cursor: pointer;
    z-index: 100;
    transition: background-color 0.5s ease;
    width:100px;
    height:100px;
}
.billboard-container .prev-button:hover,.billboard-container .next-button:hover{
	background-color: black;
}

.prev-button {
    left: 10px;
}

.next-button {
    right: 10px;
}
.billboard-page-backgroud-image {
    background-size: cover; /* 调整背景图片的大小 */
    background-position: center; /* 调整背景图片的位置 */
    background-repeat: no-repeat; /* 背景图片不重复 */
    filter: brightness(0.75); /* 降低图片亮度 */
    position: relative;
}

.billboard-content {
	font-size:100px;
    position: relative; /* 相对于父元素定位 */
    align-items: center;
    justify-content: center;
    color: white; /* 文字颜色 */
    z-index: 1; /* 确保内容在背景图片上方 */
}
.mainbutton{
	background-color: #759910;
	position : flex;
	text-decoration: none; /* 移除下划线 */
  	color: #fefefe; /* 设置字体颜色为黑色 */
  	font-size:30px;
  	width:152px;
  	height:50px;
  	
}
.mainbutton:hover {
  color: #101080; /* 鼠标悬停时的字体颜色，替换为你的颜色代码 */
}

.image-grid {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  gap: 10px; /* 空隙大小可以根据需要调整 */
}
.image-item {
  width: calc(30% - 20px); /* 三个图片并排，减去间隙 */
  margin: 10px;
  transition: transform 0.3s ease; /* 平滑过渡效果 */
}
.image-item img {
  width: 100%;
  display: block;
  border: 1px solid #ccc; /* 可选，为图片添加边框 */
}
.image-item:hover img {
  transform: translateY(-10px); /* 鼠标悬停时图片向上移动 */
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
<a class="nav-link" href="Login.jsp">Login</a>
</div>
</div> 
 
<div class="billboard-container">
    <div class="billboard">
        <div class="billboard-page billboard-page-backgroud-image" style="background-image: url('../css/images/banner-01.jpg');">
        	
	        <div class="billboard-content" >
		        <p>Votre Magasin</p>
	        </div>
	        <a class="mainbutton" href="../Produit">show view</a>
        </div>
        <div class="billboard-page billboard-page-backgroud-image" style="background-image: url('../css/images/banner-02.jpg');">第二页广告内容</div>
    </div>
    <div class="prev-button" onclick="prevPage()">上一页</div>
    <div class="next-button" onclick="nextPage()">下一页</div>
</div>



<div class="image-grid">
  <div class="image-item">
    <img src="path-to-your-image-1.jpg" alt="Image 1">
  </div>
  <div class="image-item">
    <img src="path-to-your-image-2.jpg" alt="Image 2">
  </div>
  <div class="image-item">
    <img src="path-to-your-image-3.jpg" alt="Image 3">
  </div>
  <!-- 更多图片可以继续添加 -->
</div>



<script>
let currentPage = 0;
const billboard = document.querySelector('.billboard');

function prevPage() {
    if (currentPage > 0) {
        currentPage--;
        billboard.style.transform = 'translateX(' + (-currentPage * 50) + '%)';
    }
}

function nextPage() {
    if (currentPage < 1) { // 假设有两页
        currentPage++;
        billboard.style.transform = 'translateX(' + (-currentPage * 50) + '%)';
    }
}
</script>
</body>
</html>