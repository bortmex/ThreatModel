<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <meta charset="utf-8"/>
    <base href="${pageContext.request.contextPath}/"/>
    <title>Gamedev Canvas Work</title>
    <script type="text/javascript" src="resources/js/phaser.min.js" defer></script>
    <style>
        * {
            padding: 0;
            margin: 0;
        }
/*
        canvas {
            background: #eee;
            display: block;
            margin: 0 auto;
        }*/
    </style>
</head>
<body>

<script type="text/javascript" src="resources/js/main.js" defer></script>


<%--<canvas id="myCanvas" width="880" height="560"></canvas>--%>

<c:set value="${pass}" scope="page" var="pass"/>
<input id="checkpass2" name="checkpass2" type="hidden" value="${pass}">
<c:set value="${pass1}" scope="page" var="pass1"/>
<input id="checkpass1" name="checkpass1" type="hidden" value="${pass1}">


</body>
</html>
