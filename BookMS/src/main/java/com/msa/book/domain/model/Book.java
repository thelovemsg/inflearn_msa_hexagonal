package com.msa.book.domain.model;

import com.msa.book.domain.model.vo.*;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import static jakarta.persistence.GenerationType.AUTO;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = AUTO)
    private long no;
    private String title;

    @Embedded
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
