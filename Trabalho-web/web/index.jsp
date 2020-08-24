<%@ page errorPage="erro.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="/head.jsp"/>
    </head>
    <body>
        <jsp:include page="/nav.jsp"/>
        <link rel="stylesheet" type="text/css" href="css/index.css">
        <section class="site-hero overlay" data-stellar-background-ratio="0.5" style="background-image: url(../images/big_image_1.jpg);">  
            <div class="container">
                <div class="row align-items-center site-hero-inner justify-content-center">
                    <div class="col-md-8 text-center">
                        <div class="mb-5 element-animate">
                            <h1>loripsum</h1>
                            <p class="lead">loremipsum</p>.</p>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <section class="school-features d-flex justify-content-center">
                <table class="tabela-img">
                    <tr>
                        <td>
                            <div class="inner" align="center">
                            <div class="media d-block feature">
                            <div class="icon"><span class="flaticon-video-call"></span></div>
                            <div class="media-body">
                                <h3 class="mt-0 text-black">PÉS</h3>
                                <img src="img/foto1.jpg" class="img-responsive" alt="Cinque Terre" style="width:15em ;height: 220px">
                            </div>
                        </div>
                        </td>
                        <td>
                            <div class="media d-block feature">
                            <div class="icon"><span class="flaticon-video-call"></span></div>
                            <div class="media-body">
                                <h3 class="mt-0 text-black">MÃOS</h3>
                                <img src="img/foto2.jpg"  class="img-responsive" alt="Cinque Terre" style="width:15em;height: 220px">
                            </div>
                        </div>
                        </td>
                        <td>
                            <div class="media d-block feature">
                            <div class="icon"><span class="flaticon-video-call"></span></div>
                            <div class="media-body">
                                <h3 class="mt-0 text-black">FACIAL</h3>
                                <img src="img/foto3.jpg"  class="img-responsive" alt="Cinque Terre" style="width:15em ; height: 220px">

                            </div>
                        </div> 
                        </td>
                        <td>
                            <div class="media d-block feature">
                            <div class="icon"><span class="flaticon-video-call"></span></div>
                            <div class="media-body">
                                <h3 class="mt-0 text-black">SPA</h3>
                                <img src="img/foto4.jpg"  class="img-responsive" alt="Cinque Terre" style="width:15em ;height: 220px">
                            </div>
                        </div> 
                        </td>
                    </tr>
                </table>  
            </div>
        </section>
        <jsp:include  page="/footer.jsp"/>
    </body>
</html>