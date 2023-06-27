package com.example.validate_information_form.controller;

import com.example.validate_information_form.model.Song;
import com.example.validate_information_form.dto.SongDto;
import com.example.validate_information_form.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/song")
public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping("")
    public String song(Model model) {
        model.addAttribute("songs",songService.getList());
        return "display";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("songDto", new SongDto());
        return "create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute SongDto songDto, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "create";
        }
        Song song=new Song();
        BeanUtils.copyProperties(songDto,song);
        songService.create(song);
        redirectAttributes.addFlashAttribute("msg","Add successfully");
        return "redirect:/song";
    }

    @GetMapping("/update/{id}")
        public String update(@PathVariable int id, Model model){
        if(songService.findById(id)==null){
            model.addAttribute("msg","Not found");
        }else {
            model.addAttribute("song", songService.findById(id));
        }
        return "update";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute SongDto songDto, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()) {
            return "update";
        }
        Song song=new Song();
        BeanUtils.copyProperties(songDto,song);
        songService.update(song);
        redirectAttributes.addFlashAttribute("msg","Update successfully");
        return "redirect:/song";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id,RedirectAttributes redirectAttributes,Model model){
        if(songService.findById(id)==null){
            model.addAttribute("msg","Not found");
        }else {
            songService.findById(id).setFlag(true);
            songService.delete(id);
            redirectAttributes.addFlashAttribute("msg","Delete successfully");
        }
        return "redirect:/song";
    }
}
