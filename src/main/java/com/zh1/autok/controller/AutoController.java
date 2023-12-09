package com.zh1.autok.controller;

import com.zh1.autok.model.AutoModel;
import com.zh1.autok.service.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AutoController
{
    @Autowired
    AutoService autoService;

    @GetMapping("/")
    public String AutokMegjelenitese(Model model)
    {
        AutoModel autoModel = new AutoModel();
        model.addAttribute(autoModel);
        model.addAttribute("autoList", autoService.GetAutoList());
        return "index";
    }

    @GetMapping("/add-cars")
    public String HozzaadasiOldal(Model model)
    {
        AutoModel autoModel = new AutoModel();
        model.addAttribute(autoModel);
        return "add-cars";
    }

    @PostMapping("/add-car")
    public String AutoHozzaadasa(@RequestParam String rendszam, @RequestParam String gyarto,
                                 @RequestParam String tipus, @RequestParam int loero)
    {
        autoService.AutoHozzaadasa(rendszam, gyarto, tipus, loero);
        return "redirect:/";
    }

    @PostMapping("/update-car")
    public String AutoSzerkesztese(@RequestParam String rendszam, @RequestParam String gyarto,
                                   @RequestParam String tipus, @RequestParam int loero)
    {
        autoService.AutoFrissitese(rendszam, gyarto, tipus, loero);
        return "redirect:/";
    }

    @PostMapping("/update-car/{id}")
    public String AutoKivalasztasaSzerkesztesre(@PathVariable("id") String id, Model model)
    {
        AutoModel autoModel = autoService.AutokLekerese(id);
        if (autoModel != null)
        {
            model.addAttribute(autoModel);
            return "edit-car";
        }
        return "redirect:/";
    }

    @PostMapping("/delete-car/{id}")
    public String AutoTorlese(@PathVariable("id") String id)
    {
        System.out.println(id);
        autoService.AutoTorlese(id);
        return "redirect:/";
    }
}
