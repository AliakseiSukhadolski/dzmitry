<jsp:include page="/top.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="contentarea">
	<div id="rightbar">
		<c:if test="${validateMessage ne null}">
			<p>${validateMessage}</p>
		</c:if>
	</div>
	<div id="rightbar">
		<form method="post">
			<c:if test="${user ne null}">
				<p>Enter date and amount of places on it</p>
				<p>
					Date(dd.MM.yyyy) <input type="text" name="date" class="text"
						onfocus="this.value=''" onmouseover="this.className='text_hover'"
						onmouseout="this.className='text'" />
				</p>
				<p>
					Amount <input type="text" name="amount" class="text"
						onfocus="this.value=''" onmouseover="this.className='text_hover'"
						onmouseout="this.className='text'" />
				</p>
				<input type="submit" id="submit"
					onmouseover="this.id='submit_hover'" onmouseout="this.id='submit'"
					value="login" />
			</c:if>
		</form>
	</div>
</div>
<jsp:include page="/bottom.jsp" />