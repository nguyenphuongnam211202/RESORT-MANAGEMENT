<%@ taglib prefix="cg" uri="customTag" %>

<cg:table header="Full Name,Identify Number,Phone,Email,Address" column="fullname,identifyNumber,phone,email,address" result="${result}"></cg:table>
<cg:addEdit name="employee" exclude="email" select="positionId,degreeId,departmentId"></c ></cg:addEdit>