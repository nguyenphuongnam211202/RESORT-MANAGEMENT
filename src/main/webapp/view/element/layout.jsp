<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<html>
<head>
    <title><tiles:getAsString name="title" /></title>
    <link rel="stylesheet" href="../../css/style.css">
    <link rel="stylesheet" href="webjars/bootstrap/5.1.3/css/bootstrap.min.css">
    <script src="webjars/jquery/3.6.0/dist/jquery.min.js"></script>
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="webjars/izitoast/1.4.0/dist/css/iziToast.min.css">
    <script src="webjars/izitoast/1.4.0/dist/js/iziToast.min.js"></script>
</head>
<body>
<div class="container-fluid">
    <tiles:insertAttribute name="header" />
    <main class="row">
        <tiles:insertAttribute name="menu" />
        <div class="col">
            <tiles:insertAttribute name="body" />
        </div>
    </main>
<%--    <tiles:insertAttribute name="footer" />--%>
</div>

<script src="../../js/main.js"></script>
</body>
</html>
