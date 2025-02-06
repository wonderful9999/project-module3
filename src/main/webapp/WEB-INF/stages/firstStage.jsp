<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="../../css/style.css">
    <script src="<c:url value="/static/jquery-3.6.0.min.js"/>"></script>
</head>
<body>
<h1>Первый этап. Поиск места сбора.</h1>
<h2>
    Ты с друзьями наткнулись на старуху в славном городе на берегу. <br>
    Для прохода дальше нужно пройти у нее испытание, а именно ответить на всего 1 вопрос. <br>
    Итак, перед тобой встал выбор, спасти любимую возлюбленную или спасти родную мать. <br>
    Что же ты выберешь?
</h2>
<form action="/negativeScenario/negativeFirstStages.jsp" method="get">
    <button class="confirm_button" >спасти мать</button>
</form>
<form action="/negativeScenario/negativeFirstStages.jsp" method="get">
    <button class="confirm_button" >спасти возлюбленную</button>
</form>
<form action="/stages-servlet" method="get">
    <button class="confirm_button" >молча вернутся домой</button>
</form>
</body>
</html>
