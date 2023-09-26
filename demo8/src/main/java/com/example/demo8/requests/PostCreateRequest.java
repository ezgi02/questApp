package com.example.demo8.requests;

import lombok.Data;

@Data

public class PostCreateRequest {
	Long id;
	String text;
	String title;
	Long userId;
}
