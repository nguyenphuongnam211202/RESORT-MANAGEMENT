<%@ taglib prefix="cg" uri="customTag" %>

<cg:table header="Full Name,Identify Number,Phone,Email,Address" column="fullname,identifyNumber,phone,email,address" result="${result}"></cg:table>
<cg:addEdit name="customer" exclude="email" radio="[{\"field\":\"gender\",\"data\":[{\"key\":\"Male\",\"value\":\"true\"},{\"key\":\"Female\",\"value\":\"false\"}]}]"
            select="customerTypeId"></c ></cg:addEdit>