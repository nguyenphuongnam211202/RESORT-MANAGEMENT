<%@ page import="java.util.stream.IntStream" %>
<%@ page import="m3.furama.model.Customer" %>
<%@ page import="m3.furama.util.paging.Page" %>
<%@ page import="java.util.stream.Collectors" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="d-flex justify-content-between">
    <div class="row">
        <div class="col-2 dropdown">
            <button type="button" class="btn btn-secondary dropdown-toggle" data-bs-toggle="dropdown">
                ${result.getPageSize()}
            </button>
            <ul class="dropdown-menu">
                <li><a class="dropdown-item" href="?n=${result.getNumber()}&s=5${search}">5</a></li>
                <li><a class="dropdown-item" href="?n=${result.getNumber()}&s=10${search}">10</a></li>
                <li><a class="dropdown-item" href="?n=${result.getNumber()}&s=15${search}">15</a></li>
                <li><a class="dropdown-item" href="?n=${result.getNumber()}&s=20${search}">20</a></li>
                <li><a class="dropdown-item" href="?n=${result.getNumber()}&s=25${search}">25</a></li>
            </ul>
        </div>
        <div class="col-10 ps-4 pt-2">
            Showing
            <b>${result.getPageSize() > result.getTotalElements() ? result.getTotalElements() : result.getPageSize()}</b>
            out of
            <b>${result.getTotalElements()}</b> entries
        </div>
    </div>

    <ul class="pagination justify-content-end pt-1">
        <li class="page-item ${result.hasPrevious() ? '' : 'disabled'}">
            <a class="page-link" href="?n=${result.getNumber() - 1}&s=${result.getPageSize()}${search}">Previous</a>
        </li>

        <% Page<Customer> p = (Page<Customer>) request.getAttribute("result");%>
        <c:set var="t"
               value="<%= IntStream.rangeClosed(1, p.getTotalPages()).boxed().collect(Collectors.toList()) %>"></c:set>
        <c:forEach var="i" items="${t}">
            <li class="page-item ${i == result.getNumber() ? 'active' : ''}">
                <a class="page-link" href="?n=${i}&s=${result.getPageSize()}${search}">${i}</a>
            </li>
        </c:forEach>

        <li class="page-item ${result.hasNext() ? '' : 'disabled'}">
            <a class="page-link" href="?n=${result.getNumber() + 1}&s=${result.getPageSize()}${search}">Next</a>
        </li>
    </ul>
</div>