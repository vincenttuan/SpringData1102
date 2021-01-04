<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<html>
    <head>
        <!-- Head -->
        <%@include file="../include/head.jspf"  %>
        
    </head>
    <body style="padding: 10px">

        <div id="layout">
            <!-- Toggle -->
            <%@include file="../include/toggle.jspf"  %>

            <!-- Menu -->
            <%@include file="../include/menu.jspf"  %>

            <div id="main">
                <div class="header">
                    <h1>Product</h1>
                    <h2>商品</h2>
                </div>
                <table class="pure-table" style="border: none;">
                    <td valign="top">
                        <!-- 商品表單 -->
                        <form:form class="pure-form" 
                                   modelAttribute="product" 
                                   method="post" 
                                   action="${pageContext.request.contextPath}/mvc/psi/product/" >
                            <fieldset>
                                <legend>商品表單</legend>
                                
                            </fieldset>
                        </form:form>
                    </td>
                    <td valign="top">
                        <!-- 商品列表 -->
                        <form class="pure-form">
                            <fieldset>
                                <legend>商品列表</legend>
                                
                            </fieldset>
                        </form>
                    </td>
                </table>   


            </div>
        </div>

        <!-- Foot -->
        <%@include file="../include/foot.jspf"  %>

    </body>
</html>