<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Save book</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body class="container">
<div class="container">
    <main>
        <div class="py-5 text-center">
            <img class="d-block mx-auto mb-4" src="imgs/book.png" alt="" width="72" height="57">
            <h2>Guardar un libro nuevo</h2>
            <p class="lead"></p>
        </div>
        <div class="row g-5">
            <div class="col-md-7 col-lg-8">
                <h4 class="mb-3">Guardar el libro nuevo</h4>
                <form class="needs-validation" novalidate="" action="/book" method="post">
                    <div class="row g-3">
                        <div class="col-12">
                            <label for="title" class="form-label">Titulo</label>
                            <input type="text" class="form-control" id="title" placeholder="" value="" required="">
                            <!-- Validar -->
                            <div class="invalid-feedback">
                                Valid first name is required.
                            </div>

                        </div>

                        <div class="col-12">
                            <label for="author" class="form-label">Autor</label>
                            <div class="input-group has-validation">
                                <!--<span class="input-group-text">@</span>-->
                                <input type="text" class="form-control" id="author" placeholder="Author" required="">
                                <!-- Validar -->
                                <div class="invalid-feedback">
                                    Your username is required.
                                </div>
                            </div>
                        </div>
                        <div class="col-12">
                            <label for="address" class="form-label">Unidades</label>
                            <input type="text" class="form-control" id="address" placeholder="1234 Main St" required="">
                            <div class="invalid-feedback">
                                Please enter your shipping address.
                            </div>
                        </div>

                        <div class="col-12">
                            <label for="address2" class="form-label">Fecha de devolución</label>
                            <input type="text" class="form-control" id="address2" placeholder="">
                        </div>

                    </div>
                    <button class="w-100 btn btn-primary btn-lg" type="submit">Guardar</button>
                </form>
            </div>
        </div>
    </main>

    <footer class="my-5 pt-5 text-muted text-center text-small">
        <p class="mb-1">©Biblioteca</p>
    </footer>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>
