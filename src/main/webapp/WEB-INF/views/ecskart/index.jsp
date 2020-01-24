<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ include file = "Header.jsp" %>
	<section id="slider"><!--slider-->
		<div class="container">
			<div class="row">
				<div class="col-sm-12">
					<div id="slider-carousel" class="carousel slide" data-ride="carousel">
						<ol class="carousel-indicators">
							<li data-target="#slider-carousel" data-slide-to="0" class="active"></li>
							<li data-target="#slider-carousel" data-slide-to="1"></li>
							<li data-target="#slider-carousel" data-slide-to="2"></li>
						</ol>
						
						<div class="carousel-inner">
							<div class="item active">
								<div class="col-sm-6">
									<h1><span>E</span>CSKart</h1>
									<h2>Free E-Commerce Template</h2>
									<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. </p>
									
								</div>
								<div class="col-sm-6">
									<img src="/ecskart/images/home/girl1.jpg" class="girl img-responsive" alt="" />
									<img src="/ecskart/images/home/pricing.png"  class="pricing" alt="" />
								</div>
							</div>
							<div class="item">
								<div class="col-sm-6">
									<h1><span>E</span>CSKart</h1>
									<h2>100% Responsive Design</h2>
									<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. </p>
									
								</div>
								<div class="col-sm-6">
									<img src="/ecskart/images/home/girl2.jpg" class="girl img-responsive" alt="" />
									<img src="/ecskart/images/home/pricing.png"  class="pricing" alt="" />
								</div>
							</div>
							
							<div class="item">
								<div class="col-sm-6">
									<h1><span>E</span>CSKart</h1>
									<h2>Free Ecommerce Template</h2>
									<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. </p>
									
								</div>
								<div class="col-sm-6">
									<img src="/ecskart/images/home/girl3.jpg" class="girl img-responsive" alt="" />
									<img src="/ecskart/images/home/pricing.png" class="pricing" alt="" />
								</div>
							</div>
							
						</div>
						
						<a href="#slider-carousel" class="left control-carousel hidden-xs" data-slide="prev">
							<i class="fa fa-angle-left"></i>
						</a>
						<a href="#slider-carousel" class="right control-carousel hidden-xs" data-slide="next">
							<i class="fa fa-angle-right"></i>
						</a>
					</div>
					
				</div>
			</div>
		</div>
	</section><!--/slider-->
	
	<section>
		<div class="container">
			<div class="row">
				<div class="col-sm-3">
					<div class="left-sidebar">
						<h2>Category</h2>
						<div class="panel-group category-products" id="accordian"><!--category-productsr-->
							<c:forEach items="${category }" var="valone" >
							
							
							<div class="panel panel-default"> 
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordian" href="#${valone.category_id }">
											<span class="badge pull-right"><i class="fa fa-plus"></i></span>
											${valone.category_name }
										</a>
									</h4>
								</div>
								<div id="${valone.category_id }" class="panel-collapse collapse">
									<div class="panel-body">
						
										
										<c:forEach items = "${valone.subcatList }" var="subcat" >
											<div class="panel-group category-products" style="padding:0;margin-top: 3px; margin-bottom: 3px;" id="accordian1">
											<div class="panel panel-default"> 
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordian1" href="#${subcat.sub_cat_id}">
											<span class="badge pull-right"><i class="fa fa-plus"></i></span>
											${subcat.sub_cat_name }
										</a>
									</h4>
								</div>
								<div id="${subcat.sub_cat_id}" class="panel-collapse collapse">
									<div class="panel-body">
										<ul>
											
											<c:forEach items="${subcat.fList}" var="fdata" >
											<li><a href="#"> ${fdata.floor_category_name } </a></li>
											</c:forEach>
										</ul>
									</div>
								</div>
								</div>	
							</div>		
					</c:forEach>
									</div>
								</div>
							</div>
							</c:forEach>
						</div><!--/category-products-->
						
						
						
					
					</div>
				</div>
				
				<div class="col-sm-9 padding-right">
					<div class="features_items"><!--features_items-->
						<h2 class="title text-center">Features Items</h2>
						<c:forEach items="${features}" var="feature">
						<div class="col-sm-4">
							<div class="product-image-wrapper">
								<div class="single-products">
										<div class="productinfo text-center">
											<img src="/ecskart/${feature.image }" alt="" style="height: 200px; background-repeat: no-repeat;" />
											<h2> ₹ ${feature.price}</h2>
											<p>${feature.product_name}</p>	
											<button  class="btn btn-default add-to-cart"  onClick = "updatecookie('${feature.product_id}, ${feature.product_name}, ${feature.price},${feature.image}')" ><i class="fa fa-shopping-cart"></i>Add to cart</button>
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
										<li><a href="#"><i class="fa fa-plus-square"></i>Add to wishlist</a></li>
										<li><a href="#"><i class="fa fa-plus-square"></i>Add to compare</a></li>
									</ul>
								</div>
							</div>
						</div>
						</c:forEach>		
					</div><!--features_items--> 
					
					
					
					<div class="recommended_items"><!--recommended_items-->
						<h2 class="title text-center">recommended items</h2>
						
						<div id="recommended-item-carousel" class="carousel slide" data-ride="carousel">
							<div class="carousel-inner"> 
								<div class="item active"> 	
									<c:forEach items = "${recommandation}" var = "recog">
									<div class="col-sm-4">
										<div class="product-image-wrapper">
											<div class="single-products">
												<div class="productinfo text-center">
													<img src="/ecskart/${recog.image }" alt="" />
													<h2>₹ ${recog.price}</h2>
													<p>${recog.product_name}</p>
													<button  class="btn btn-default add-to-cart" onClick = "updatecookie('${recog.product_id},${recog.product_name},${recog.price},${recog.image}')"><i class="fa fa-shopping-cart"></i>Add to cart</button>
												</div>
												
											</div>
										</div>
									</div>
									</c:forEach>
								
								</div>
								<div class="item">	
									<div class="col-sm-4">
										<div class="product-image-wrapper">
											<div class="single-products">
												<div class="productinfo text-center">
													<img src="/ecskart/images/home/recommend1.jpg" alt="" />
													<h2>$56</h2>
													<p>Easy Polo Black Edition</p>
													<button  class="btn btn-default add-to-cart" onClick = "updatecookie('${recog.product_id},${recog.product_name},${recog.price},${recog.image}')"><i class="fa fa-shopping-cart"></i>Add to cart</button>												</div>
												
											</div>
										</div>
									</div>
									<div class="col-sm-4">
										<div class="product-image-wrapper">
											<div class="single-products">
												<div class="productinfo text-center">
													<img src="/ecskart/images/home/recommend2.jpg" alt="" />
													<h2>$56</h2>
													<p>Easy Polo Black Edition</p>
													<button  class="btn btn-default add-to-cart" onClick = "updatecookie('${recog.product_id},${recog.product_name},${recog.price},${recog.image}')"><i class="fa fa-shopping-cart"></i>Add to cart</button>												</div>
												
											</div>
										</div>
									</div>
									<div class="col-sm-4">
										<div class="product-image-wrapper">
											<div class="single-products">
												<div class="productinfo text-center">
													<img src="/ecskart/images/home/recommend3.jpg" alt="" />
													<h2>$56</h2>
													<p>Easy Polo Black Edition</p>
													<button  class="btn btn-default add-to-cart" onClick = "updatecookie('${recog.product_id},${recog.product_name},${recog.price},${recog.image}')"><i class="fa fa-shopping-cart"></i>Add to cart</button>												</div>
												
											</div>
										</div>
									</div>
								</div>
							</div>
							 <a class="left recommended-item-control" href="#recommended-item-carousel" data-slide="prev">
								<i class="fa fa-angle-left"></i>
							  </a>
							  <a class="right recommended-item-control" href="#recommended-item-carousel" data-slide="next">
								<i class="fa fa-angle-right"></i>
							  </a>			
						</div>
					</div><!--/recommended_items-->
					
				</div>
			</div>
		</div>
	</section>
	
	<%@ include file="Footer.jsp" %>

    <script src="/ecskart/js/jquery.js"></script>
    <script src="/ecskart/js/jquery.redirect.js"></script>
	<script src="/ecskart/js/bootstrap.min.js"></script>
	<script src="/ecskart/js/jquery.scrollUp.min.js"></script>
	<script src="/ecskart/js/price-range.js"></script>
    <script src="/ecskart/js/jquery.prettyPhoto.js"></script>
    <script src="/ecskart/js/main.js"></script>
</body>
</html>
