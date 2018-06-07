<%@ page import="static ru.javaproject.threatmodel.util.GetLowMediumHigh.get" %>
<%@ page import="static ru.javaproject.threatmodel.util.GetLowMediumHigh.*" %>
<%@ page import="ru.javaproject.threatmodel.model.ExcelModelElement" %>
<%@ page import="java.util.*" %>
<%@ page import="ru.javaproject.threatmodel.model.Threat" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="ru.javaproject.threatmodel.util.ExcelWorker" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://threatmodel.javaproject.ru/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: Денис
  Date: 20.04.2018
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Answer</title>

    <link href="webjars/bootstrap/3.3.7-1/css/bootstrap.min.css" rel="stylesheet">
    <link href="webjars/datatables/1.10.16/css/jquery.dataTables.min.css" rel="stylesheet">
    <link href="webjars/datatables-buttons/1.5.1/css/buttons.dataTables.scss" rel="stylesheet">
    <style>
        body{
            background-image: url('http://www.accaglobal.com/content/accaglobal/ca/en/student/exam-support-resources/fundamentals-exams-study-resources/f1/technical-articles/how-to-answer-multiple-choice-questions/_jcr_content/article/image_75a1.img.jpg/1517490585895.jpg');
            background-attachment: fixed;
            background-size: 100%;
        }
        .container {
            opacity: 0.95;
        }
    </style>

    <link rel="stylesheet" href="resources/css/style_for_answer.css">

    <script type="text/javascript" src="webjars/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="webjars/datatables/1.10.16/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="webjars/datatables-buttons/1.5.1/js/dataTables.buttons.js"></script>
    <script>
        $(function() {
            $('#datTables').DataTable( {
                dom: 'Bfrtip',
                lengthMenu: [
                    [ 5, 10, 25, 50, -1 ],
                    [ '5 rows', '10 rows', '25 rows', '50 rows', 'Show all' ]
                ],
                buttons: [
                    'pageLength'
                ]
            } );
        } );
    </script>

</head>
<body>

<%
    ExcelWorker excelWorker = new ExcelWorker();
    List<ExcelModelElement> excelExit = new ArrayList<>();
%>
<section>
    <%--    <H1>Answers</H1>
        <div>${answers}</div>--%>
    <c:set var="answerForQuestion" value="${answerForQuestion}"/>
    <jsp:useBean id="answerForQuestion" type="java.lang.Object" scope="page"/>
    <c:set var="userResponses" value="${userResponses}"/>
    <jsp:useBean id="userResponses" type="java.lang.Object" scope="request"/>
        <c:set value="${Y1P}" scope="page" var="y1p"/>
        <jsp:useBean id="y1p" type="java.lang.String" scope="page"/>
        <c:set value="${excelgo}" scope="page" var="excelgo"/>
        <jsp:useBean id="excelgo" type="java.lang.Boolean" scope="page"/>
        <div class="container">
                <div class="col-md-6">
                    <h3> Tables used in calculations</h3>
                    <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                        <!-- Indicators -->
                        <ol class="carousel-indicators">
                            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                        </ol>

                        <!-- Wrapper for slides -->
                        <div class="carousel-inner" role="listbox">
                            <div class="item active">
                                <img src="resources/image/table8.jpg" alt="...">
                            </div>
                            <div class="item">
                                <img src="resources/image/table4.jpg" alt="...">
                            </div>
                            <div class="item">
                                <img src="resources/image/mytable.png" alt="...">
                            </div>
                        </div>

                        <!-- Controls -->
                        <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>
                </div>
                <div class="col-md-6">
                    <c:set value="${allvariablequest10}" scope="page" var="allvariablequest10"/>
                    <jsp:useBean id="allvariablequest10" type="java.lang.String[]" scope="page"/>
                    <div class="container">
                        <h2>Вы выбрали следующих нарушителей</h2>
                        <ul class="list-group">
                            <c:forEach items="${allvariablequest10}" var="variable">
                                <li style="width: 50%" class="list-group-item">${variable}</li>
                            </c:forEach>
                        </ul>
                    </div>
                    <div class="container">
                        <h2>Уровень защищенности ИС (Y<sub>1П</sub>)</h2>
                        <ul class="list-group">
                            <li style="width: 50%" class="list-group-item">${Y1P}</li>
                        </ul>
                    </div>
                </div>

        </div>
        <br>
        <br>
        <div class="container-fluid">
        <table id="datTables" class="table table-hover table-bordered results">
            <thead>
            <tr>
                <th>ID</th>
                <%--<th>К</th>
                <th>Ц</th>
                <th>Д</th>--%>
                <th>Source Threat</th>
                <th>Степень<br> ущерба (X<sub>j</sub>)</th>
                <th>Возможность <br> реализации УБИ (Y<sub>j</sub>)</th>
                <th>Тип нарушителя</th>
                <th>Потенциал <br> нарушителя (Y<sub>2</sub>)</th>
                <th>Актуальность (УБИ<sub>j</sub>А)</th>
                <th>Обоснование</th>
            </tr>
            </thead>
            <c:forEach items="${threats}" var="threat">
                <jsp:useBean id="threat" type="ru.javaproject.threatmodel.model.Threat" scope="page"/>
                <tr>

                    <td>${fn:getId(threat.id)}</td>
                    <%
                        String q11 = get(threat.getBreachOfConfidentiality(), (Integer[][]) userResponses, (Integer[][]) answerForQuestion, 11);
                        String q12 = get(threat.getIntegrityViolation(), (Integer[][]) userResponses, (Integer[][]) answerForQuestion, 12);
                        String q13 = get(threat.getViolationOfAvailability(), (Integer[][]) userResponses, (Integer[][]) answerForQuestion, 13);
                        String[] array = new String[3];
                        array[0] = q11;
                        array[1] = q12;
                        array[2] = q13;
                        String xj = getMax(array);
                    %>
                        <%--<td><%=q11%>
                        </td>
                        <td><%=q12%>
                        </td>
                        <td><%=q13%>
                        </td>--%>
                    <td style="width: 15%">${threat.sourceOfThreat}</td>
                    <td><%=xj%>
                    </td>
                    <td>${YJ}</td>
                    <td>${typeViolator}</td>
                    <td>${Y2}</td>
                    <c:set value="${typeViolator}" scope="page" var="typeViolator"/>
                    <jsp:useBean id="typeViolator" type="java.lang.String" scope="page"/>
                    <c:set value="${YJ}" scope="page" var="yj"/>
                    <jsp:useBean id="yj" type="java.lang.String" scope="page"/>
                    <c:set value="${Y2}" scope="page" var="y2"/>
                    <jsp:useBean id="y2" type="java.lang.String" scope="page"/>

                    <%
                        Integer[][] arr = getArrFromDao((Integer[][]) userResponses, 17, 3);
                        String UBIaj = "";
                        String[] yjarr = yj.split("<br>");

                        Integer[][] sourceOfThreat = getArrParseSourceOfThreat(threat.getSourceOfThreat());
                        Integer[] type_of_offender = sourceOfThreat[0]; //тип нарушителя из базы
                        Integer[] the_potential_intruder = sourceOfThreat[1]; //потенциал нарушителя из базы

                        Integer[] type_of_offender_calculation = getArrParseSourceOfThreatCalculationType(typeViolator.split("<br>")); //тип нарушителя из анкеты
                        Integer[] the_potential_intruder_calculation = getArrParseSourceOfThreatCalculationY2(y2.split("<br>")); //потенциал нарушителя из анкеты

                        String[] UBIajArray = new String[yjarr.length];
                        for (int i = 0; i < yjarr.length; i++) {
                            UBIajArray[i] = getActial(arr[getNumber(yjarr[i])][getNumber(xj)]);
                        }
                        String detailedDescription = "";
                        if (sourceOfThreat[0].length != 0) {
                            for (int i = 0; i < UBIajArray.length; i++) {
                                if (UBIajArray[i].equals("актуальный")) {
                                    if (!Arrays.asList(sourceOfThreat[0]).contains(type_of_offender_calculation[i])) {
                                        if (type_of_offender_calculation[i] != 2) {
                                            UBIajArray[i] = "неактуальный";
                                            detailedDescription += "Тип нарушителя не соответс типу из бд" + "<br>";
                                            continue;
                                        }
                                    }
                                    if (!getTrueFalseStream(sourceOfThreat, type_of_offender_calculation[i], the_potential_intruder_calculation[i])) {
                                        detailedDescription += "Недостаточный потенциал" + "<br>";
                                        UBIajArray[i] = "неактуальный";
                                        continue;
                                    }
                                    detailedDescription += "<br>";
                                } else detailedDescription += "XJ/YJ look table, не подходит<br>";
                            }

                            for (int i = 0; i < UBIajArray.length; i++) {
                                UBIaj += UBIajArray[i] + "<br>";
                            }
                        } else {
                            UBIaj = "смотреть примечание";
                            detailedDescription = "нет данных о нарушителе в бд";
                        }
                    %>
                    <td><%=UBIaj%>
                    </td>
                    <td><%=detailedDescription%>
                    </td>

                    <%
                        if(excelgo) {
                            ExcelModelElement excelModelElement = new ExcelModelElement(new Threat(threat.getId(), threat.getName(), threat.getDescription(),
                                    threat.getSourceOfThreat(), threat.getTheObjectOfTheImpact(), 0, 0, 0,
                                    threat.getDateOfInclusionOfThreatInTheBND(), threat.getLastModifiedDate()), q11,
                                    q12, q13, y1p.split(" ")[4], y2.replaceAll("<br>", System.lineSeparator()),
                                    yj.replaceAll("<br>", System.lineSeparator()), xj, UBIaj.replaceAll("<br>", System.lineSeparator()),
                                    detailedDescription.replaceAll("<br>", System.lineSeparator()));
                            excelExit.add(excelModelElement);
                        }
                    %>
                </tr>
            </c:forEach>
            <%
                if(excelgo) {
                    excelWorker.createListForExcel(excelExit);
                }
            %>
        </table>

        </div>
</section>

</body>
</html>
