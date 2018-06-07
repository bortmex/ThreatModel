<%@ page import="ru.javaproject.threatmodel.model.Threat" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Денис
  Date: 16.04.2018
  Time: 18:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="${pageContext.request.contextPath}/"/>
    <link rel="stylesheet" href="resources/css/style.css">
    <link rel="stylesheet" href="webjars/bootstrap/3.3.7-1/css/bootstrap.min.css">
    <link rel="stylesheet" href="webjars/datatables/1.10.16/css/jquery.dataTables.min.css">
    <link rel="stylesheet" href="webjars/datatables/1.10.16/css/dataTables.bootstrap.min.css">
    <link rel="shortcut icon" href="resources/image/threat-icon.png">
    <style>
        body {
            background-image: url('resources/image/s1_1376630963.jpg');
            background-attachment: fixed;
            background-size: 100%;
            opacity: 0.90;
        }

        a { cursor: pointer; }

        .modal-dialog {
            max-width: 400px;
        }
    </style>

    <!--http://stackoverflow.com/a/24070373/548473-->
    <script type="text/javascript" src="webjars/jquery/3.2.1/jquery.min.js" defer></script>
    <script type="text/javascript" src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js" defer></script>
    <script type="text/javascript" src="webjars/datatables/1.10.16/js/jquery.dataTables.min.js" defer></script>
    <script type="text/javascript" src="resources/js/forthreat.js" defer></script>
    <script type="text/javascript">
        function show() {
            $('#editRow').modal();
        }

        function dontshow() {
            $('#editRow').modal('hide');
        }
    </script>
</head>

<body>

<div class="container">
    <div class="table-wrapper">
        <div class="table-title">
            <div class="row">
                <div class="col-sm-10">
                    <h2><spring:message code="threat.list"/></h2>
                </div>
                <div class="col-sm-2">
                    <a href="startpage" class="btn btn-primary"><span>Назад</span></a>
                </div>
            </div>
        </div>
        <table class="table table-hover table-bordered results display" id="datatables">
            <thead>
            <tr>
                <th><fmt:message key="threat.id"/></th>
                <th class="col-md-1 col-xs-1"><fmt:message key="threat.name"/></th>
                <th class="col-md-6 col-xs-6"><fmt:message key="threat.description"/></th>
                <th class="col-md-3 col-xs-3"><fmt:message key="threat.source"/></th>
                <th class="col-md-2 col-xs-2"><fmt:message key="threat.the.object.of.the.impact"/></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${threats}" var="threat">
                <jsp:useBean id="threat" type="ru.javaproject.threatmodel.model.Threat" scope="page"/>
                <tr>
                    <%
                        String jid = Integer.toString(threat.getId());
                        switch (jid.length()) {
                            case 1:
                                jid = "00" + jid;
                                break;
                            case 2:
                                jid = "0" + jid;
                                break;
                        }
                    %>
                    <td><a <%--href="threat/${threat.id}" --%>onclick="show()"><%=jid%>
                    </a></td>
                    <td><c:out value="${threat.name}"/></td>
                    <td><c:out value="${threat.description}"/></td>
                    <td><c:out value="${threat.sourceOfThreat}"/></td>
                    <td><c:out value="${threat.theObjectOfTheImpact}"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<div class="modal fade" id="editRow">
    <div class="modal-dialog">
        <div class="modal-content">
            <form:form class="form-horizontal" action="${pageContext.request.contextPath}/threatyes">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title"></h4>
                </div>
                <div class="modal-body">
                    <input id="password" name="password" type=text value="" class="form-control" autocomplete="off" spellcheck="false">
                </div>
                <div class="modal-footer">
                    <input type="submit" class="btn btn-primary"  value="Submit" onclick="dontshow()">
                </div>

            </form:form>
        </div>
    </div>
</div>
</body>
</html>