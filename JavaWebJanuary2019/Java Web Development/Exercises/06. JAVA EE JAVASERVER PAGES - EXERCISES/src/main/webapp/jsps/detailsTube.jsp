<%@ page import="metube.domain.models.view.TubesDetailsViewModel" %><%--
  Created by IntelliJ IDEA.
  User: NinoB
  Date: 7.2.2019 г.
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <c:import url="templates/head.jsp"/>
</head>
<body>
<% TubesDetailsViewModel tubesDetailsViewModel = (TubesDetailsViewModel) request.getAttribute("tubeDetailsViewModel");%>
<div class="container">
    <main>
        <div class="jumbotron">
            <div class="row">
                <div class="col col-md-12 d-flex justify-content-center">
                    <h1>
                        <%= tubesDetailsViewModel.getName()%>
                    </h1>
                </div>
            </div>
            <hr/>
            <div class="row">
                <div class="col col-md-12 d-flex justify-content-center">
                    <h3>
                        <%= tubesDetailsViewModel.getDescription() %>
                    </h3>
                </div>
            </div>
            <hr/>

            <div class="row">
                <div class="col col-md-6 d-flex justify-content-center">
                    <a href="<%= tubesDetailsViewModel.getYouTubeLink() %>">Link To Video</a>
                </div>
                <div class="col col-md-6 d-flex justify-content-center">
                    <p><%=tubesDetailsViewModel.getUploader()%></p>
                </div>
            </div>
            <div class="row">
                <div class="col col-md-12 d-flex justify-content-center">
                    <a href="/">Back to Home</a>
                </div>
            </div>
        </div>
    </main>
    <footer>
        <c:import url="templates/footer.jsp"/>
    </footer>
</div>
</body>
</html>
