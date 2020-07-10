package com.techleads.app.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Book")
public class Book {
	@Id
	private Integer id;
	private String bookName;
	private String authorName;
	private List<String> subscribed;
	private List<Post> posts;

}
