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
                    <h1>Pruchase</h1>
                    <h2>進貨</h2>
                </div>
                <table class="pure-table" style="border: none;">
                    <td valign="top">
                        <!-- 進貨列表 -->
                        <fieldset class="pure-form">
                            <legend>Inventory list</legend>
                            
                        </fieldset>

                    </td>
                    <td valign="top">
                        <!-- 進貨列表 -->
                        <fieldset class="pure-form">
                            <legend>Pruchase list</legend>
                            
                        </fieldset>
                    </td>
                </table> 
            </div>
        </div>

        <!-- Foot -->
        <%@include file="../include/foot.jspf"  %>

    </body>
</html>