<jsp:include page="/top.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="contentarea">
	<div id="rightbar">
		<c:if test="${message ne null}">
			<p>${message}</p>
		</c:if>
	</div>
	<div id="rightbar">
		<form method="post">
			<c:if test="${user eq null}">
				<p>Enter your username and password for authorization.</p>
				<p>
					Login <input type="text" name="login" class="text"
						onfocus="this.value=''" onmouseover="this.className='text_hover'"
						onmouseout="this.className='text'" />
				</p>
				<p>
					Password <input type="password" name="password" class="text"
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