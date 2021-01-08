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
                    <h1>Sales</h1>
                    <h2>銷貨</h2>
                </div>
                <table class="pure-table" style="border: none;">
                    <tr>
                        <td valign="top">
                            <!-- 列表 -->
                            <fieldset class="pure-form">
                                <legend>Inventory list</legend>
                                <table class="pure-table pure-table-bordered" width="100%">
                                    <thead>
                                        <tr>
                                            <th nowrap>ID</th>
                                            <th nowrap>Name</th>
                                            <th nowrap>Image</th>
                                            <th nowrap>庫存量</th>
                                            <th nowrap>進貨均價</th>
                                            <th nowrap>銷貨均價</th>
                                            <th nowrap>售價一</th>
                                            <th nowrap>售價二</th>
                                            <th nowrap>欲銷貨數量</th>
                                            <th nowrap>欲銷貨價格</th>
                                            <th nowrap>賣出</th>
                                        </tr>
                                    </thead>

                                    <tbody>
                                        <c:forEach var="i" items="${ inventories2 }">
                                        <form class="pure-form" method="post" action="${pageContext.request.contextPath}/mvc/psi/sales">
                                            <tr>
                                                <td><input type="text" name="pid" value="${ i.id }" readonly style="max-width: 50px" /></td>
                                                <td>${ i.name }</td>
                                                <td><img style="cursor: zoom-in" id="blah" src="${ i.image==null?space:i.image }" width="${ i.image==null?'0':'100' }" /></td>
                                                <td>
                                                    <fmt:formatNumber type="number" pattern="###,###" value="${ i.qty }" />
                                                </td>
                                                <td>
                                                    <fmt:formatNumber type="number" pattern="###,###.0" value="${ i.puCost }" />
                                                </td>
                                                <td>
                                                    <fmt:formatNumber type="number" pattern="###,###.0" value="${ i.saCost }" />
                                                </td>
                                                <td>
                                                    <fmt:formatNumber type="number" pattern="###,###.0" value="${ i.price1 }" />
                                                </td>
                                                <td>
                                                    <fmt:formatNumber type="number" pattern="###,###.0" value="${ i.price2 }" />
                                                </td>
                                                <td><input type="number" name="quantity" value="0" style="max-width: 100px" /></td>
                                                <td><input type="number" name="price" value="0" style="max-width: 100px" /></td>
                                                <td><button type="submit" class="pure-button pure-button-primary" ${ qty <= 0 ? 'disabled' : '' }>Submit</button></td>
                                            </tr>
                                        </form>
                                    </c:forEach>
                                    </tbody>
                                </table> 
                            </fieldset>
                        </td>
                    </tr>
                    <tr>
                        <td valign="top">
                            <!-- 列表 -->
                            <fieldset class="pure-form">
                                <legend>Sales list</legend>
                                <table class="pure-table pure-table-bordered" width="100%">

                                    <thead>
                                        <tr>
                                            <th nowrap>ID</th>
                                            <th nowrap>PID</th>
                                            <th nowrap>品名</th>
                                            <th nowrap>價格</th>
                                            <th nowrap>數量</th>
                                            <th>銷貨時間</th>
                                        </tr>
                                    </thead>

                                    <tbody>
                                        <c:forEach var="s" items="${ sales }">
                                            <tr>
                                                <td>${ s.id }</td>
                                                <td>${ s.product.id }</td>
                                                <td>${ s.product.name }</td>
                                                <td>${ s.price }</td>
                                                <td>${ s.quantity }</td>
                                                <td>${ s.date }</td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table> 
                            </fieldset>
                        </td>
                    </tr>
                </table> 
            </div>
        </div>

        <!-- Foot -->
        <%@include file="../include/foot.jspf"  %>

    </body>
</html>