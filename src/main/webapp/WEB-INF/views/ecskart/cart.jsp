<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ include file = "Header.jsp" %>

	<section id="cart_items">
		<div class="container">
			<div class="breadcrumbs">
				<ol class="breadcrumb">
				  <li><a href="#">Home</a></li>
				  <li class="active">Shopping Cart</li>
				</ol>
			</div>
			<div class="table-responsive cart_info">
				<table class="table table-condensed" id = "item_table">
					<thead>
						<tr class="cart_menu">
							<td class="image">Item</td>
							<td class="description"></td>
							<td class="price">Price</td>
							<td class="quantity">Quantity</td>
							<td class="total">Total</td>
							<td></td>
						</tr>
					</thead>
					<tbody>
						
						
						<c:forEach items = "${busket}" var = "cart"  >
						
						
						<tr>
							<td class="cart_product">
								<a href=""><img src="/ecskart/${cart.image}" style = "width: 115px;" alt=""></a>
							</td>
							<td class="cart_description">
								<h4><a href=""> ${cart.name} </a></h4>
								<p>Web ID: 1089772</p>
							</td>
							<td class="cart_price">
								<p>$${cart.rate }</p>
							</td>
							<td class="cart_quantity">
								<div class="cart_quantity_button" style = "flex-direction: row; " onClick =   >
									<button class="cart_quantity_up" id = "plus_${cart.id}" onClick="plus(${cart.id}, ${cart.rate })"  > + </button>
									<input  type="text" name="quantity" value= ${cart.quantity } id = "qty_${cart.id}" autocomplete="off" size="2">
									<button class="cart_quantity_down"  id="minus_${cart.id}" onClick="minus(${cart.id}, ${cart.rate })"  > - </button>
								</div>
							</td>
							<td class="cart_total">
								<p class="cart_total_price" id="amount_${cart.id}" >$ ${cart.price } </p>
							</td>
							<td class="cart_delete">
								<button class="cart_quantity_delete" onClick="removeRow(this)" ><i class="fa fa-times"></i></button>
							</td>
						</tr>
						
						
						 </c:forEach>
						
						
					</tbody>
				</table>
			</div>
		</div>
	</section> <!--/#cart_items-->

	<section id="do_action">
		<div class="container">
		
			<div class="row">
				
				<div class="col-sm-6">
					<div class="total_area">
						<ul>
							<li>Cart Sub Total <span>$59</span></li>
							<li>Eco Tax <span>$2</span></li>
							<li>Shipping Cost <span>Free</span></li>
							<li>Total <span>$61</span></li>
						</ul>
							<a class="btn btn-default update" href="">Update</a>
							<a class="btn btn-default check_out" href="">Check Out</a>
					</div>
				</div>
			</div>
		</div>
	</section><!--/#do_action-->
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