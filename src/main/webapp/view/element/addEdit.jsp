<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="modal fade" id="addEditModal" tabindex="-1" aria-hidden="true">
    <div class="modal-dialog">
        <form method="post" action="/${name}">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Create ${name}</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <c:forEach items="${fields}" var="f">
                        <c:if test="${f.getName().equals('id')}">
                            <input name="id" hidden value="0">
                        </c:if>
                        <c:if test="${!f.getName().equals('id')}">
                            <div class="mb-3">
                                <label class="form-label">${f.getName()}</label>
                                <input class="form-control" name="${f.getName()}"/>
                            </div>
                        </c:if>
                    </c:forEach>

                    <c:forEach items="${radios}" var="r">
                    <div class="mb-3">
                        <label class="form-label">${r.field}</label>
                        <c:forEach items="${r.data}" var="d">
                            <div class="form-check">
                                <input type="radio" class="form-check-input" name="${r.field}" value="${d.value}">
                                <label class="form-check-label">${d.key}</label>
                            </div>
                        </c:forEach>
                    </div>
                    </c:forEach>

                    <c:forEach items="${selects}" var="r">
                        <div class="mb-3">
                            <label class="form-label">${r.fieldDisplay}</label>
                            <select name="${r.field}" class="form-select" aria-label="Default select example">
                                <c:forEach items="${r.data}" var="d">
                                    <option value="${d.value}">${d.key}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </c:forEach>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                    <button type="submit" class="btn btn-success">Save</button>
                </div>
            </div>
        </form>
    </div>
</div>