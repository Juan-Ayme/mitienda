package com.maver.mitienda.domain.dto;//(2.1)

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class Book
{
    private long idBook;
    //no debe ser nulo, tampoco debe tener vacios, ni espacio en blanco
    @NotBlank
    @Size(min = 3, max = 100)
    private String title;
    @NotBlank
    private String description;
    @NotBlank
    private String slug;
    @NotBlank
    private String coverRoute;
    @NotBlank
    private String fileRoute;
    @NotNull//no debe ser nulo "not null" funciona con numericos
    @PositiveOrZero//no debe ser negativo
    private float price;
}
