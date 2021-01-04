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
                    <h1>Inventory</h1>
                    <h2>庫存</h2>
                </div>
                <table class="pure-table" style="border: none;">
                    <td valign="top">
                        <!-- 庫存列表 -->
                        <form class="pure-form">
                            <fieldset>
                                <legend>庫存列表</legend>
                                
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