<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Map<String, String> error = (Map<String, String>)request.getAttribute("error");
%>

<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8" charset="UTF-8">
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <link href="CSS/sign-in.css" rel="stylesheet">
</head>
<body class="text-center">
    <main class="form-signin w-100 m-auto">
        <form action="/login" method="post">
            <img class="mb-4" src="imgs/Logo.png" alt="" width="92" height="92">
            <h1 class="h3 mb-3 fw-normal">Inicia sesión</h1>
            <%  if (error != null && error.containsKey("invalid")){%>
                <div class="row mb-3 alert alert-danger col-sm-12" style="color: red">
                    <%= error.get("invalid") %>
                </div>
            <%}%>
            <div class="form-floating">
                <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com" name="email" value="${param.email}">
                <label for="floatingInput">Email</label>
            </div>
            <% if(error != null && error.containsKey("email")) { %>
            <div class="row mb-3 alert alert-danger col-sm-12" style="color: red">
                <%= error.get("email") %>
            </div>
            <%}%>
            <div class="form-floating">
                <input type="password" class="form-control" id="floatingPassword" placeholder="Password" name="password">
                <label for="floatingPassword">Contraseña</label>
            </div>
            <% if(error != null && error.containsKey("password")) { %>
            <div class="row mb-3 alert alert-danger col-sm-12" style="color: red">
                <%= error.get("password") %>
            </div>
            <%}%>
            <button class="w-100 btn btn-lg btn-primary" type="submit">Iniciar sesión</button>
            <p class="mt-5 mb-3 text-muted">©YOWI 2023</p>
        </form>
    </main>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>
