<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ include file="Header.jsp" %>
	
	<section id="form"><!--form-->
		<div class="container">
			<div class="row">
				<div class="col-sm-5 col-sm-offset-1">
					<div class="login-form"><!--login form-->
						<h2>Add a product</h2>
						
						<form:form modelAttribute="product"  method="POST"  action="/ecskart/uploadFile" onsubmit="return validateForm()"  enctype="multipart/form-data">
							<label for="product_name">product name<span style="color:red;" > *</span></label>
							<form:input path="product_name" placeholder ="Product Name"  type="text" name="product_name" id="product_name"  />
							
							<label for="product_name">Description<span style="color:red;" > *</span></label>
							<form:textarea path="description" placeholder ="Description"  type="text" name="Description" length="300" id="description" />				
							
							<label for="price">Price <span style="color:red;" > *</span></label>
							<form:input path="price" type="number" placeholder ="Price" name="Price" step="1.0" id="price" />
							
							<label for="price">Discount Percent</label>
							<form:input path = "discount" placeholder = "Discount" type="text" name="Discount" />
							
							<label for="Available">Available</label>
							<form:select path ="available" type="text" name="Available" >
								<option value="1">AVAILABLE</option>
								<option value="0">NOT AVAILABLE</option>
							</form:select>
							
							<label for="OnSale">On Sale</label>
							<form:select path="onsale" type="text" name="OnSale" >
								<option value="0">NOT ON SALE</option>
								<option value="1">ON SALE</option>
							</form:select>
								
							<label for="Category_id">Category <span style="color:red;" > *</span></label>
							<form:select path="cat_id" name="Category_id" onchange="getval(this);"  style="padding: 10px;" id="category" >
								<option value="">SELECT CATEGORY</option>
								<c:forEach items ="${categories}" var = "category"  >
									 <option value="${category.category_id}">${category.category_name}</option>
								</c:forEach>
							</form:select>
							
							<label for="Sub_category_id">Sub Category<span style="color:red;" > *</span></label>
							<form:select path="sub_cat_id"  type="text" name="Sub_category_id" onChange="getFloorCategories(this);" style="padding: 10px;" id="sub_category_select"  ></form:select>
							
							<label for="floor_category_id">Inner Category<span style="color:red;" > *</span></label>
							<form:select path="floor_cat_id"  type="text" name="floor_category_id"  id="floor_category_select" style="padding: 10px;"  ></form:select>
							
							<form:hidden path = "image" />
							<form:hidden path = "product_id" />
							File to upload (Max size 200Kb, .jpg format): <span style="color:red;" > *</span>
   							<input type="file" accept="image/*" name="file" id="files" style = "backgroundColor: '#fff' !important"/><br /> 
							<button type="submit" value="Upload" class="btn btn-default">Submit</button>
						
						</form:form>	
						
						
					 
					</div><!--/login form-->
				</div>
				
				<div class="col-sm-3 bg-dark">
					<img alt="" src="/ecskart/${product.image}" style = "width: 300px;  height: auto; background-size:'cover'; margin-top:70px  " id="imageDisplay"  >
				</div>
			</div>
		</div>
	</section><!--/form-->
	
	
	<%@include file = "Footer.jsp" %>
	

  
    <script src="/ecskart/js/jquery.js"></script>
    <script src="/ecskart/js/jquery.redirect.js"></script>
	<script src="/ecskart/js/price-range.js"></script>
    <script src="/ecskart/js/jquery.scrollUp.min.js"></script>
	<script src="/ecskart/js/bootstrap.min.js"></script>
    <script src="/ecskart/js/jquery.prettyPhoto.js"></script>
    <script src="/ecskart/js/main.js"></script>
</body>
</html>