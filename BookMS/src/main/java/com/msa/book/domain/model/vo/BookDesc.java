package com.msa.book.domain.model.vo;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class BookDesc {
    private String author;
    private String isbn;
    private String description;
    private LocalDate publicationDate;
    private Source source;

    public static BookDesc createBookDesc(String author, String isbn, String description, LocalDate publicationDate, Source source) {
        return new BookDesc(author, isbn, description, publicationDate, source);
    }

    public static BookDesc sample() {
        return createBookDesc("마틴파울러", "123123123", "엔터프라이즈 아키텍처 패턴을 잘 설명해주는 도서", LocalDate.now(), Source.SUPPLY);
    }
}
