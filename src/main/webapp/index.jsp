<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<c:if test="${empty news_detailList}">
    <c:redirect url="/news/newslist"/>
</c:if>
</body>
</html>
