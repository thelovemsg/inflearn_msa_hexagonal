package com.msa.book.application.outputport;

import com.msa.book.domain.model.Book;
import org.springframework.stereotype.Repository;

@Repository
public interface BookOutPutPort {
    Book loadBook(long bookNo);
    Book save(Book book);
}
