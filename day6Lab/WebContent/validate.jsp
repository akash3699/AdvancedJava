<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:setProperty property="*" name="voter" />
<jsp:setProperty property="*" name="candidate" />
<c:redirect url="${sessionScope.voter.authenticateVoter()}.jsp" ></c:redirect>