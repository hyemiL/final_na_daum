package com.project.nadaum.audiobook.model.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlbumTrack implements Serializable{

	private static final long serialVersionUID = 1L;

	private int no;
	private String albumCode;
	private String name;
	private String originalFilename;
	private String renamedFilename;
	private Date regDate;
	private Date chgDate;
	private String timeStamp;
	private int playCount;
	private String status;
}
