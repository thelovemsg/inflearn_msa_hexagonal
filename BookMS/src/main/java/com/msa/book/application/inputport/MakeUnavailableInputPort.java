package com.msa.book.application.inputport;

import com.msa.book.application.outputport.BookOutPutPort;
import com.msa.book.application.usecase.MakeUnavailableUsecase;
import com.msa.book.domain.model.Book;
import com.msa.book.framework.web.dto.BookOutPutDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MakeUnavailableInputPort implements MakeUnavailableUsecase {

    private final BookOutPutPort bookOutPutPort;

    @Override
    public BookOutPutDTO unavailable(Long bookNo) {
        Book loadedBook = bookOutPutPort.loadBook(bookNo);
        loadedBook.makeUnavailable();
        return BookOutPutDTO.mapToDTO(loadedBook);
    }
}
