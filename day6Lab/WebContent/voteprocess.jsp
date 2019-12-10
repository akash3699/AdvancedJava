<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:setProperty property="*" name="voter"/>
<jsp:setProperty property="*" name="candidate"/>
${sessionScope.voter.updateVoterStatus()}
${sessionScope.candidate.updateVotes()}
<c:redirect url="status.jsp"></c:redirect>