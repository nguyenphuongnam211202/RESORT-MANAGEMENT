<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="cg" uri="customTag" %>

<div class="table-title mt-3">
    <div class="row">
        <div class="col">
            <h3><b>Service</b></h3>
        </div>
        <div class="col-4">
            <button class="btn btn-success float-end me-2" data-bs-toggle="modal"
                    data-bs-target="#addEditModal">Add New
            </button>
        </div>
    </div>
</div>

<table class="table">
    <thead>
    <th>#</th>
    <th>Name</th>
    <th>Area</th>
    <th>Price</th>
    <th>Max People</th>
    <th>Rent Type</th>
    <th>Action</th>
    </thead>
    <tbody>
    <c:forEach items="${result.getContent()}" var="r" varStatus="i">
        <tr>
            <td>${i.count + (result.getNumber() -1) * result.getPageSize()}</td>
            <td>${r.name}</td>
            <td>${r.area}</td>
            <td>${r.price}</td>
            <td>${r.maxPeople}</td>
            <td>${r.rentType}</td>
            <td>
                <button class="btn btn-success">Edit</button>
                <button onclick="deleteItem('${r.id}')" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#deleteModal">Delete</button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<cg:paging params="${result}" search="${by}:${val}"></cg:paging>
<cg:delete></cg:delete>

<div class="modal fade" id="addEditModal" tabindex="-1" aria-hidden="true">
    <div class="modal-dialog">
        <form method="post" action="/service">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Create Service</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input name="id" hidden value="0">
                    <div class="mb-3">
                        <label class="form-label">Name</label>
                        <input class="form-control" name="name"/>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Area</label>
                        <input class="form-control" name="area"/>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Price</label>
                        <input class="form-control" name="price"/>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Max People</label>
                        <input class="form-control" name="maxPeople"/>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Standar Room</label>
                        <input class="form-control" name="standarRoom"/>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Pool Area</label>
                        <input class="form-control" name="poolArea"/>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Floor Number</label>
                        <input class="form-control" name="floorNumber"/>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Service Type</label>
                        <select name="serviceType" class="form-select" aria-label="Default select example">
                            <option>--- select service type ---</option>
                            <option value="1">Villa</option>
                            <option value="2">House</option>
                            <option value="3">Room</option>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Rent Type</label>
                        <select name="rentType" class="form-select" aria-label="Default select example">
                            <option>--- select rent type ---</option>
                            <option value="1">Day</option>
                            <option value="2">Month</option>
                            <option value="3">Year</option>
                            <option value="4">Hour</option>
                        </select>
                    </div>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                    <button type="submit" class="btn btn-success">Save</button>
                </div>
            </div>
        </form>
    </div>
</div>
<%--<% String mes = request.getParameter("m"); %>--%>
<c:set var="m" value='<%= request.getParameter("m") %>'></c:set>
<c:if test="${m > 0}">
   <script>
       iziToast.success({position: "topRight", message: "Successful!"});
   </script>
</c:if>