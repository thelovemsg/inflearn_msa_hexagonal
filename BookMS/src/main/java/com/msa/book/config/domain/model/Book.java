package com.msa.book.config.domain.model;

import com.msa.book.config.domain.model.vo.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private long no;
    private String title;
    private BookDesc desc;
    private Classification classification;
    private BookStatus bookStatus;
    private Location location;

    public static Book enterBook(String title, String author, String isbn, String description, LocalDate publicationDate, Source source, Classification classification, Location location) {
        BookDesc bookDesc = BookDesc.createBookDesc(author, isbn, description, publicationDate, source);
        Book book = new Book();
        book.setTitle(title);
        book.setDesc(bookDesc);
        book.setClassification(classification);
        book.setLocation(location);
        book.setBookStatus(BookStatus.ENTERED);
        return book;
    }

    public static Book sample() {
        return enterBook("엔터프라이즈 아키텍처 패턴", "마틴파울러", "123123123"
                        , "엔터프라이즈 아키텍처 패턴을 잘 설명해주는 도서", LocalDate.now()
                        , Source.SUPPLY, Classification.COMPUTER, Location.JEONGJA);
    }

    public Book makeAvailable() {
        setBookStatus(BookStatus.AVAILABLE);
        return this;
    }

    public Book makeUnavailable() {
        setBookStatus(BookStatus.UNAVAILABLE);
        return this;
    }
}
