<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>
 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<title>hello</title>
</head>

<body>
	<section class = "row">
		<div class = "col-6 offset-3 mt-4"> 
			<form action="<c:url value="/admin/categories/saveOrUpdate" />" method="POST">
			<div class = "card"> 
				<div class = "card-header">
					<h2> ${category.isEdit ? "Edit Category" : "Add New Category"}</h2>
				</div>
				<div class = "card-body">
					<div class = "mb-3">
						<label for=categoryId class="form-label">Category ID</label>
						<input type = "hidden" value = "${category.isEdit}">
						<input type = "text" readonly = "readonly" class="form-control" value="${category.categoryId}" id = "categoryId" name = "categoryId" aria-describedly = "categoryIdid" placeholder = "Category Id">
						
					</div>
					<div class="mb-3">
						<label for="categoryname>" class = "form-label"> Category Name: </label>
						<input type = "text" class="form-control" value="${category.categoryName}" id = "categoryName" name = "categoryName" aria-describedly = "nameid" placeholder = "Category Name">
					</div>
				</div>
			</div> 
		<div class = "card-footer text-muted">
		<a href = "<c:url value="/admin/categories/add"/>"class = "btn btn-secondary"><i class="fas fa-new"></i>New</a>
		<a href = "<c:url value="/admin/categories"/>"class = "btn btn-success"><i class="fas fa-bars"></i>List</a>
		<button class="btn btn-primary" type="submit"><i class="fas fa-save"></i>
		<c:if test = "${category.isEdit}">
		<span>Update</span>
		</c:if>
		<c:if test = "${!category.isEdit}">
		<span>Save</span>
		</c:if>
		</button>
		</div>
		</form>
		</div>
	 </section>
	 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
	
</body>
</html>