<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Anketa</title>
    <base href="${pageContext.request.contextPath}/"/>
    <link rel="stylesheet" href="resources/css/style.css">
    <link href="webjars/bootstrap/3.3.7-1/css/bootstrap.min.css" rel="stylesheet">
    <link rel="shortcut icon" href="resources/image/threat-icon.png">
    <style>
        body{
            background-image: url('https://i.ytimg.com/vi/asMSnUThQKA/maxresdefault.jpg');
            background-attachment: fixed;
            background-size: 100%;
            opacity: 0.90;
        }
    </style>
    <script type="text/javascript" src="webjars/jquery/3.2.1/jquery.min.js" defer></script>
    <script type="text/javascript" src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"  defer></script>
    <script type="text/javascript" src="resources/js/quest.js"  defer></script>
    <script>
        function back() {
            $(location).attr('href',"startpage");
        }
    </script>
</head>
<body>

<section>
    <%--<a href="startpage">Back</a>--%>
    <button onclick="back()" type="button" class="btn btn-secondary">Back</button>

    <div  id='panel' class="container">
        <form id="detalForm">
            <c:forEach items="${questions}" var="question">
                <jsp:useBean id="question" scope="page" type="ru.javaproject.threatmodel.model.Question"/>
                <c:if test="${question.radio==true}">
                    <%int i = 0;%>
                    <br>
                    <div class="col-sm-7 form-group">
                        <label for="question${question.id}">${question.question}:</label>
                            <select class="form-control" id="question${question.id}">
                                <c:forEach items="${question.variantsOfAnswers}" var="variant">
                                    <option value="answers${question.id}[<%=i++%>">${variant}</option>
                                </c:forEach>
                            </select>
                    </div>
                    <br>
                </c:if>
                <c:if test="${question.radio==false}">
                    <%int j = 0;%>
                    <br>
                    <div class="col-sm-7 form-group">
                        <label for="question${question.id}">${question.question}:</label>
                        <select multiple class="form-control" id="question${question.id}">
                            <c:forEach items="${question.variantsOfAnswers}" var="variant">
                                <option value="answers${question.id}[<%=j++%>">${variant}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <br>
                </c:if>
            </c:forEach>
            <%--<div class="col-sm-12"> </div>
            <button type="submit" class="col-md-1 col-md-offset-5 btn btn-default">Submit</button>--%>
            <div>
                <input onsubmit="return false;" type="submit" class="col-md-1 col-md-offset-5 btn btn-default" id="submit"  name="submit" value="Submit">
            </div>
        </form>
    </div>

</section>
</body>
</html>













<%--<form action="answerthreat" method="post">

        <c:forEach items="${questions}" var="question">
            <jsp:useBean id="question" scope="page" type="ru.javaproject.threatmodel.model.Question"/>
            <c:if test="${question.radio==true}">
                <div class="form-row form-row-title">
                    <strong>${question.question}:</strong>
                </div>
                    <%int i = 0;%>
                <br>
                    <c:forEach items="${question.variantsOfAnswers}" var="variant">
                        <div style="padding-left:30px;" class="form-row">
                            <label >
                                <input value="question${question.id}[<%=i++%>" class="radio" type="radio" name="radio-test${question.id}">
                                <span class="radio-custom"></span>
                                <span style="padding-left:10px;" class="label">${variant}</span>
                            </label>
                        </div>
                    </c:forEach>
                <br>
            </c:if>
            <c:if test="${question.radio==false}">

                <div class="form-row form-row-title">
                    <strong>${question.question}:</strong>
                </div>
                    <%int j = 0;%>
                <br>
                    <c:forEach items="${question.variantsOfAnswers}" var="variant" >
                        <div style="padding-left:30px;" class="form-row">
                            <label>
                                <input value="question${question.id}[<%=j++%>" class="checkbox" type="checkbox" name="checkbox-test${question.id}">
                                <span class="checkbox-custom"></span>
                                <span style="padding-left:10px;" class="label">${variant}</span>
                            </label>
                        </div>
                    </c:forEach>
                <br>
            </c:if>
        </c:forEach>
        <input type="submit" value="Submit">
    </form>--%>