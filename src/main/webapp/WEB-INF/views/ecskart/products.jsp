<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ include file="Header.jsp" %>
	
	<section id="form"><!--form-->
		<div class="container">
		
		 <table class="table table-striped table-bordered">
    <thead style="background-color: orange; color: white;" >
      <tr>
        <th>id</th>
        <th>Product name</th>
        <th>price</th>
        <th>Discount</th>
        <th>Category</th>
        <th>Sub Category</th>
        <th>Inner Category</th>
        <th>Available</th>
        <th>On Sale</th>
        <th>operations</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${products}" var = "product">
      <tr>
        <td>${product.product_id}</td>
        <td>${product.product_name}</td>
        <td>${product.price}</td>
        <td>${product.cat_name}</td>
        <td>${product.sub_cat_name}</td>
        <td>${product.inner_cat_name}</td>
      </tr>
      </c:forEach>
    </tbody>
  </table>
		
			<div class="row">
				<c:forEach items="${products}" var = "product">
				<div class="col-sm-3">
							<div class="product-image-wrapper">
								<div class="single-products">
										<div class="productinfo text-center">
											<img src="/ecskart/${product.image }" alt="" style="height: 200px; background-repeat: no-repeat;" />
											<h2> ₹ ${product.price}</h2>
											<p>${product.product_name}</p>	
										</div>
										<!-- 
										<div class="product-overlay">
											<div class="overlay-content">
												<h2>${feature.price}</h2>
												<p>${feature.product_name }</p>
												<button  class="btn btn-default add-to-cart"  ><i class="fa fa-shopping-cart"></i>Add to cart</button>
											</div>
										</div>
										 -->
								</div>
								<div class="choose">
									<ul class="nav nav-pills nav-justified">
										<li><a href="/ecskart/delete/${product.product_id }"><i class="fa fa-plus-square"></i>Delete product</a></li>
										<li><a href="/ecskart/product/${product.product_id }"><i class="fa fa-plus-square"></i>Edit information</a></li>
									</ul>
								</div>
							</div>
						</div>
				</c:forEach>				
			</div>
		</div>
	</section><!--/form-->
	
	
	<%@include file = "Footer.jsp" %>
	

  
    <script src="/ecskart/js/jquery.js"></script>
	<script src="/ecskart/js/price-range.js"></script>
	<script src="/ecskart/js/jquery.redirect.js"></script>
    <script src="/ecskart/js/jquery.scrollUp.min.js"></script>
	<script src="/ecskart/js/bootstrap.min.js"></script>
    <script src="/ecskart/js/jquery.prettyPhoto.js"></script>
    <script src="/ecskart/js/main.js"></script>
</body>
</html>