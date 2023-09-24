package com.wilfred.springdatarest.springdatarest.entities;

import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data

public class ArticleDTO {
    private String title;
    private String content;
    private List<String> tags;
}
