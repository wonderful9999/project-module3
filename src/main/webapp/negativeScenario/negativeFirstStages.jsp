<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="../css/style.css">
    <script src="<c:url value="/static/jquery-3.6.0.min.js"/>"></script>
</head>
<body>
<h1>Неудача</h1>
<h2>
    Ты выбрал неверный ответ. Возвращайся через год, попробуй снова.
</h2>
<form action="/restart-servlet" method="get">
    <button class="confirm_button" >вернутся через год</button>
</form>
</body>
</html>
