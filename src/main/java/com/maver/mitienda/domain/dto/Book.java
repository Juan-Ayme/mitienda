package com.maver.mitienda.domain.dto;//(2.1)

import lombok.Data;

@Data
public class Book
{
    private long idBook;
    private String title;
    private String slug;
    private String coverRoute;
    private String fileRoute;
    private float price;
}
