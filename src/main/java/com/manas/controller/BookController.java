package com.manas.controller;

import com.manas.entity.Book;
import com.manas.service.BookService;
import com.manas.service.VendorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@Controller
@RequestMapping("/{vendorId}/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    private final VendorService vendorService;

    @GetMapping
    public String getAll(@PathVariable Long vendorId, Model model) {
        try {
            model.addAttribute("vendor", vendorService.getById(vendorId));
            model.addAttribute("books", bookService.getAll(vendorId));
            return "book/books";
        } catch (NoSuchElementException e) {
            return e.getMessage();
        }
    }

    @GetMapping("/new")
    public String createNewBook(@PathVariable Long vendorId, Model model) {
        model.addAttribute("book", new Book());
        return "book/new";
    }

    @PostMapping("/save")
    public String save(@PathVariable Long vendorId,
                       @ModelAttribute(
                               "book") Book book,
                       BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "book/new";
        }
        bookService.save(vendorId, book);
        return "redirect:/{vendorId}/books";
    }

    @GetMapping("/{bookId}/edit")
    public String getUpdateForm( @PathVariable Long vendorId,
                                @PathVariable("bookId") Long bookId,
                                 Model model){
            model.addAttribute("book", bookService.findById(bookId));
            return "book/update";
    }

    @PostMapping("/{bookId}/update")
    public String update(@PathVariable Long vendorId,
                         @PathVariable("bookId") Long bookId,
                         @ModelAttribute("book")  Book book,
                         BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "book/update";
        }
            bookService.update(bookId, book);
            return "redirect:/{vendorId}/books";
    }

    @GetMapping("/{bookId}/delete")
    public String delete(@PathVariable Long vendorId,
                         @PathVariable("bookId") Long bookId) {
        bookService.delete(bookId);
        return "redirect:/{vendorId}/books";
    }

}
