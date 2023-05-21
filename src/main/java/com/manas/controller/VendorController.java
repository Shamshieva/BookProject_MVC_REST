package com.manas.controller;

import com.manas.entity.Vendor;
import com.manas.service.BookService;
import com.manas.service.VendorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@Controller
@RequestMapping("/vendors")
@RequiredArgsConstructor
public class VendorController {

    private final VendorService vendorService;
    private final BookService bookService;

    @GetMapping
    public String getAll(@RequestParam(name = "keyWord", required = false) String keyWord, Model model) {
        model.addAttribute("keyWord", keyWord);
        model.addAttribute("vendors", vendorService.getAllVendors(keyWord));
        return "vendor/main";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") Long vendorId, Model model) {
        int countBooks = bookService.getAll(vendorId).size();
//        int countTran = transactionService.getAll(vendorId).size();
        try {
            model.addAttribute("countBooks", countBooks);
//            model.addAttribute("countTran", countTran);
            model.addAttribute("vendor", vendorService.getById(vendorId));

            return "vendor/vendorInfo";
        } catch (NoSuchElementException e) {
            return e.getMessage();
        }
    }

    @GetMapping("/new")
    public String createNewVendor(Model model) {
        model.addAttribute("vendor", new Vendor());
        return "vendor/new";
    }

    @PostMapping("/save")
    public String saveVendor(@ModelAttribute("vendor")  Vendor vendor,
                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "vendor/new";
        }
        vendorService.save(vendor);
        return "redirect:/vendors";
    }


    @GetMapping("/{id}/delete")
    public String deleteVendor(@PathVariable Long id) {
        vendorService.delete(id);
        return "redirect:/vendors";
    }

    @GetMapping("/{id}/edit")
    public String getUpdateForm(@PathVariable("id") Long id, Model model) {
        try {
            model.addAttribute("vendor", vendorService.getById(id));
            return "vendor/update";
        } catch (NoSuchElementException e) {
            return e.getMessage();
        }
    }

    @PostMapping("/{id}/update")
    public String updateVendor(@PathVariable("id") Long id,
                                 @ModelAttribute("vendor")  Vendor vendor,
                                 BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "vendor/update";
        }
        vendorService.update(id, vendor);
        return "redirect:/vendors";
    }
}
