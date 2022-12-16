package vn.ecopic.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Picture")
public class Picture implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PictureId")
	private int pictureId;
	
	@Column(name = "PictureTitle", columnDefinition = "nvarchar(255) not null")
	private String pictureTitle ;
	
	@Column(name = "PictureDescription", columnDefinition = "nvarchar(255) not null")
	private String pictureDescription ;
	
	@Column(name = "PictureImage")
	private String pictureImage ;
	
	@Column(name = "PicturePrice")
	private Float picturePrice ;
	
	@Column(name = "PicturePublishDate")
	private Date picturePublishDate;
	
	
	@ManyToOne
	@JoinColumn(name="CategoryId")
	private Category category;
	


}
