<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>MODEL THREAT</title>
  <base href="${pageContext.request.contextPath}/"/>
  <link rel="shortcut icon" href="resources/image/threat-icon.png">
  <link href="webjars/bootstrap/3.3.7-1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
  <link rel="stylesheet" href="resources/css/style.css">
    <script src="webjars/jquery/3.2.1/jquery.min.js" defer></script></head>
    <script src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js" defer></script>
  <body>
<div id="myCarousel" class="carousel slide">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
    </ol>

    <!-- Wrapper for Slides -->
    <div class="carousel-inner">
        <div class="item active">
            <!-- Set the first background image using inline CSS below. -->
            <div class="fill" style="background-image:url('http://energysmi.ru/uploads/posts/2015-10/14459961131020545321192.jpeg');"></div>
            <div class="carousel-caption">
                <h2 class="animated fadeInLeft">Посмотреть базу данных уязвимостей ФСТЕК</h2>
                <p class="animated fadeInUp">Данные представлены ввиде обычной таблицы</p>
                <p class="animated fadeInUp"><a href="threats" class="btn btn-transparent btn-rounded btn-large">Посмотреть</a></p>
            </div>
        </div>
        <div class="item">
            <!-- Set the second background image using inline CSS below. -->
            <div class="fill" style="background-image:url('http://mcykt.ru/wp-content/uploads/2016/10/51038c8d36c3347a4bd9e6e392ab54e0.jpg');"></div>
            <div class="carousel-caption">
                <h2 class="animated fadeInDown">Создать модель угроз</h2>
                <p class="animated fadeInUp">Модель составляется ввиде анкетирования</p>
                <p class="animated fadeInUp"><a href="questionnaire" class="btn btn-transparent btn-rounded btn-large">Пройти</a></p>
            </div>
        </div>
    </div>

    <!-- Controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
        <span class="icon-prev"></span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
        <span class="icon-next"></span>
    </a>

</div>

  </body>
</html>
