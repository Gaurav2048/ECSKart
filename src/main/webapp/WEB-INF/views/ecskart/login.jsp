<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ include file = "Header.jsp" %>	
	<section id="form"><!--form-->
		<div class="container">
			<div class="row">			
				<div class="col-sm-4 ">
					<div class="login-form" ><!--login form-->
						<h2>Login to your account</h2>
						<form:form modelAttribute="user" action="/ecskart/login" onsubmit="return onLoginSubmit();" method="post" >
							<form:input path="email" type="text" placeholder="Email Address" id="email" />
							<form:input path="password" type="password" placeholder="Password" id="password" />
							<form:button type="submit" class="btn btn-default">Login</form:button>
						</form:form>
   					  <h4 style="color: red;" > ${error}</h4>
				</div>
				
			</div>
		</div>
	</section><!--/form-->
	
	<%@ include file = "Footer.jsp" %>

  
    <script src="/ecskart/js/jquery.js"></script>
	<script src="/ecskart/js/price-range.js"></script>
    <script src="/ecskart/js/jquery.scrollUp.min.js"></script>
	<script src="/ecskart/js/bootstrap.min.js"></script>
    <script src="/ecskart/js/jquery.prettyPhoto.js"></script>
    <script src="/ecskart/js/main.js"></script>
</body>
</html>