package vn.ecopic.model;



import javax.validation.constraints.NotEmpty;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CategoryModel {
	private Long categoryId;
	@NotEmpty
	private String categoryName;
	private Boolean IsEdit = false ;
	public Boolean getIsEdit() {
		return IsEdit;
	}
	public void setIsEdit(Boolean isEdit) {
		IsEdit = isEdit;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	
	
}
