package com.book.onboard.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookAllDetailsDTO {
	private Integer id;
	private String name;
	private String datetimestamp;
	
	private Integer cid;
	private String cname;
	private String cdatetimestamp;
	
	private Integer rId;
	private String rdatetimestamp;
	private Integer wordCount;

    public BookAllDetailsDTO(Integer id, String name, String datetimestamp, Integer cid, String cname,
			String cdatetimestamp, Integer rId, String rdatetimestamp, Integer wordCount) {
		super();
		this.id = id;
		this.name = name;
		this.datetimestamp = datetimestamp;
		this.cid = cid;
		this.cname = cname;
		this.cdatetimestamp = cdatetimestamp;
		this.rId = rId;
		this.rdatetimestamp = rdatetimestamp;
		this.wordCount = wordCount;
	}
}