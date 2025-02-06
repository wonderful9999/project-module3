<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="css/style.css">
    <script src="<c:url value="/static/jquery-3.6.0.min.js"/>"></script>
</head>
<body>
<h1>Пролог</h1>
<h2>
    Привет! Это твой экзамен на хантера. <br>
    Твоя цель пройти все испытания заготовленные нашими людьми. <br>
    Они не простые! Не думай что будет легко. <br>
    Удачи юный будущий хантер :)
</h2>
<form action="/login-servlet" method="post">
    <label class="label_input_text" for="name">Введи своё имя: </label>
    <input type="text"
           class="input_text"
           id="name"
           name="name"
           required>
    <button class="confirm_button" >подтвердить</button>
</form>
</body>
</html>
