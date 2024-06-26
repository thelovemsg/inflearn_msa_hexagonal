package com.msa.book.application.inputport;

import com.msa.book.application.outputport.BookOutPutPort;
import com.msa.book.application.usecase.AddBookUsecase;
import com.msa.book.domain.model.Book;
import com.msa.book.domain.model.vo.Classification;
import com.msa.book.domain.model.vo.Location;
import com.msa.book.domain.model.vo.Source;
import com.msa.book.framework.web.dto.BookInfoDTO;
import com.msa.book.framework.web.dto.BookOutPutDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class AddBookInputPort implements AddBookUsecase {

    private final BookOutPutPort bookOutPutPort;

    @Override
    public BookOutPutDTO addBook(BookInfoDTO bookInfoDTO) {
        Book book = Book.enterBook(bookInfoDTO.getTitle()
                , bookInfoDTO.getAuthor()
                , bookInfoDTO.getIsbn()
                , bookInfoDTO.getDescription()
                , bookInfoDTO.getPublicationDate()
                , Source.valueOf(bookInfoDTO.getSource())
                , Classification.valueOf(bookInfoDTO.getClassification())
                , Location.valueOf(bookInfoDTO.getLocation()));
        Book savedBook = bookOutPutPort.save(book);
        return BookOutPutDTO.mapToDTO(savedBook);
    }
}
