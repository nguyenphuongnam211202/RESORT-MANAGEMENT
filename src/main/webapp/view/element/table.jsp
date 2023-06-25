<%@ page import="java.lang.reflect.Field" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="cg" uri="customTag" %>

<div class="table-title mt-3">
    <div class="row">
        <div class="col">
            <h3>
                <script>
                    const tmp = document.title;
                    $("h3").text(tmp.charAt(0).toUpperCase() + tmp.slice(1))
                </script>
            </h3>
        </div>
        <div class="col-4">
            <button onclick="resetCustomerForm()" class="btn btn-success float-end me-2" data-bs-toggle="modal"
                    data-bs-target="#addEditModal">Add New
            </button>
        </div>
    </div>
</div>
<table class="table">
    <thead>
    <th>#</th>
    <c:forEach var="h" items="${headers}">
        <th>${h}</th>
    </c:forEach>
    <th>Action</th>
    </thead>
    <tbody>
    <c:forEach items="${result.getContent()}" var="r" varStatus="i">
        <tr>
            <td>${i.count + (result.getNumber() -1) * result.getPageSize()}</td>
            <c:forEach var="c" items="${columns}">
                <%
                    Object result = null;
                    try {
                        Class<?> clazz = pageContext.getAttribute("r").getClass();
                        Field f = clazz.getDeclaredField(pageContext.getAttribute("c").toString());
                        f.setAccessible(true);
                        result = f.get(pageContext.getAttribute("r"));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                %>
                <td><c:out value="<%= result %>"></c:out></td>
            </c:forEach>
            <td>
                <button
                        class="btn btn-success" data-bs-toggle="modal" data-bs-target="#addEditModal">Edit
                </button>
                <button onclick="deleteItem('${r.id}')" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#deleteModal">Delete</button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<cg:paging params="${result}" search="${by}:${val}"></cg:paging>
<cg:delete></cg:delete>