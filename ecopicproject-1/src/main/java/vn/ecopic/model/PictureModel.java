package vn.ecopic.model;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PictureModel {
	
	private int pictureId;
	@NotEmpty
	private String pictureTitle ;
	private String pictureDescription ;
	private String pictureImage ;
	private MultipartFile imageFile;
	private Float picturePrice ;
	private Date picturePublishDate ;
	private Long categoryId;
	private Boolean isEdit = false;
}
