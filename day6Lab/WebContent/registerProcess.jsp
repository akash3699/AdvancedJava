
<%-- <jsp:useBean id="voter" class="beans.VoterBean" scope="session" /> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:setProperty property="*" name="voter" /> 
<c:redirect url="${sessionScope.voter.addVoter()}.jsp" ></c:redirect> 
