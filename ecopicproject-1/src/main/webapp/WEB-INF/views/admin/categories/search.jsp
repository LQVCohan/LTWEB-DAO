<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>

<body>
	<section class = "row">
		<div class = "col mt-4"> 
			<div class = "card"> 
			<div class = "card-header">List Category</div>
			<div class = "card-body">
			<c:if test="${message != null}">
				<div class = "alert alert-primary" 
				role ="alert"> 
				<i>${message}</i> 
				</div>
			</c:if>
			<div class="row mt-2 mb-2">
				<div class ="col-md-6">
					<form action="/admin/categories/search">
						<div class="input-group">
							<input type="text"
							class = "form-control mt-2" name="name" id = "name"
							placeholder="Nhập từ khóa để tìm kiếm"/>
							<button class = "btn btn-outline-primary mt-2">Search</button>
						</div>
					</form>
				</div>
				<div class="col-md-1">
					<div class="float-right">
					<a class="btn btn-outline-success" href="/admin/categories/add">Add New Category</a>
					</div>
				</div>
			</div>
			
			
			
			
			
			
			
			
			<table class="table table-striped table-responsive">
				<thead class ="thead-inverse">
					<tr>
						<th>Category ID</th>
						<th>Category Name</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items ="${categories}" var="category">
					<tr>
						<td scope="row">${category.categoryId}</td>
						<td>${category.categoryName}</td> 
						<td>
							<a href="/admin/categories/view/${category.categoryId}" class="btn btn-outline-info"><i class = "fa fa-info"></i></a>
							<a href="/admin/categories/edit/${category.categoryId}" class="btn btn-outline-warning"><i class = "fa fa-edit"></i></a>
							<a href="/admin/categories/delete/${category.categoryId}" class="btn btn-outline-danger"><i class = "fa fa-trash"></i></a>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			 </table>
			</div>
			</div> 
		</div>
	 </section>
	 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
	
</body>
</html>