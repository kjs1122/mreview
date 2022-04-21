package org.zerock.mreview.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.mreview.dto.MovieDTO;
import org.zerock.mreview.dto.PageRequestDTO;
import org.zerock.mreview.service.MovieService;

@Controller
@RequestMapping("/movie")
@Log4j2
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/list")
    public String list(@ModelAttribute("pageRequestDTO") PageRequestDTO pageRequestDTO,
                       Model model) {
        log.info("pageRequestDTO = {}", pageRequestDTO);

        log.info("result = {}", movieService.getList(pageRequestDTO));
        model.addAttribute("result", movieService.getList(pageRequestDTO));

        return "movie/list";
    }

    @GetMapping("/register")
    public String register(@ModelAttribute("movieDTO") MovieDTO movieDTO) {
        return "movie/register";
    }

    @PostMapping("/register")
    public String registerPost(
            MovieDTO movieDTO,
            RedirectAttributes redirectAttributes) {

        log.info("movieDTO = {}", movieDTO);

        Long mno = movieService.register(movieDTO);

        redirectAttributes.addFlashAttribute("msg", mno);
        log.info("mno  = {}", mno);

        return "redirect:/movie/list";
    }

    @GetMapping("/read")
    public String read(
            Long mno,
            @ModelAttribute("requestDTO") PageRequestDTO requestDTO,
            Model model) {

        log.info("mno : {}", mno);

        model.addAttribute("dto", movieService.getMovie(mno));

        return "movie/read";
    }
}
