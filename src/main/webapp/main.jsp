<%@ page import="java.util.HashMap" %>
<%@ page import="com.example.demo.models.Book" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Library</title>
    <link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/headers/">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
        <a href="/" class="d-flex align-items-center col-md-3 mb-2 mb-md-0 text-dark text-decoration-none">

        </a>
        <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
            <li>
                <a href="#" class="nav-link px-2 link-secondary">Biblioteca</a>
            </li>
            <li>
                <a href="book.jsp" class="nav-link px-2 link-dark">Agregar</a>
            </li>
            <!--
            <li>
                <a href="#" class="nav-link px-2 link-dark">Prestamo</a>
            </li>
            -->
        </ul>
        <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" role="search">
            <input type="search" class="form-control" placeholder="Buscar..." aria-label="buscar">
        </form>
        <div class="col-md-3 text-end">
            <button type="button" class="btn btn-outline-primary me-2">crear cuenta</button>
            <button type="button" class="btn btn-primary">Iniciar sesion</button>
        </div>
    </header>
</div>
<br/>

<div id="myCarousel" class="carousel slide" data-bs-ride="carousel">
    <div class="carousel-indicators">
        <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="0" class="active" aria-label="Slide 1" aria-current="true"></button>
        <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="1" aria-label="Slide 2" class="active" aria-current="true"></button>
        <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="2" aria-label="Slide 3" class=""></button>
    </div>
    <div class="carousel-inner">
        <div class="carousel-item active">
            <svg class="bd-placeholder-img" width="100%" height="100%" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" preserveAspectRatio="xMidYMid slice" focusable="false">
                <rect width="100%" height="100%" fill="#777"></rect>
            </svg>
            <div class="container">
                <div class="carousel-caption text-start">
                    <p>Quien no haya leído al menos un libro, no conocerá el maravilloso mundo de la imaginación.</p>
                </div>
            </div>
        </div>
        <div class="carousel-item">
            <svg class="bd-placeholder-img" width="100%" height="100%" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" preserveAspectRatio="xMidYMid slice" focusable="false">
                <rect width="100%" height="100%" fill=""></rect></svg>
            <div class="container">
                <div class="carousel-caption">
                    <p>Un libro es como un buen amigo, que nos ayuda a ver la vida desde otro punto de vista.</p>
                </div>
            </div>
        </div>
        <div class="carousel-item">
            <svg class="bd-placeholder-img" width="100%" height="100%" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" preserveAspectRatio="xMidYMid slice" focusable="false"><rect width="100%" height="100%" fill="#777"></rect></svg>
            <div class="container">
                <div class="carousel-caption text-end">
                    <p>La ignorancia suele ser tal, que los ladrones no roban libros.</p>
                </div>
            </div>
        </div>

        <button class="carousel-control-prev" type="button" data-bs-target="#myCarousel" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#myCarousel" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>

</div>

<div class="album py-5 bg-light">
    <div class="container">
        <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
            <% HashMap<String, Book> books = (HashMap<String, Book>) request.getSession().getAttribute("bookList");
            for (Book book : books.values()) {%>
            <div class="col">
                <div class="card shadow-sm">
                    <svg class="bd-placeholder-img card-img-top" width="100%" height="225"  role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false" xmlns=<%=book.getImgLink()%>>
                        <title><%= book.getTitle()%></title>
                        <rect width="100%" height="100%" fill="#55595c"></rect>
                        <text x="50%" y="50%" fill="#eceeef" dy=".3em"><%=book.getTitle()%></text>
                    </svg>
                    <div class="card-body">
                        <h1><%=book.getTitle()%></h1>
                        <p class="card-text"><%= book.getAuthor()%></p>
                        <div class="d-flex justify-content-between align-items-center">
                            <form class="btn-group" method="post" action="/main">
                                <button type="button" class="btn btn-sm btn-outline-secondary" name="idBook" value=<%=book.getId()%>>Prestar</button>
                            </form>
                            <small class="text-muted"></small>
                        </div>
                    </div>
                </div>
            </div>
            <%}%>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>
