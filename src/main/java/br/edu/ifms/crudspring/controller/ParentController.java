package br.edu.ifms.crudspring.controller;

import java.util.*;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifms.crudspring.model.Parent;
import br.edu.ifms.crudspring.service.ParentService;

@Controller
@RequestMapping("/parent")
public class ParentController {

    @Autowired
    ParentService parentService;

    @PostMapping("/")
    public String save(@ModelAttribute("parent") Parent parent) {
        parentService.save(parent);
        return "redirect:/parent/";
    }

    // -------------------------------------------
    @GetMapping("/")
    public String locAll(Model model) {
        List<Parent> parents = parentService.getParents();
        model.addAttribute("parents", parents);
        return "parent";
    }

    // -------------------------------------------
    @GetMapping("/cadastrarParent")
    public String newParent(Model model) {
        model.addAttribute("parent", new Parent());
        return "cadastrarParent";
    }

    // -------------------------------------------
    @GetMapping("/remove/{id}")
    public String removerParent(@PathVariable("id") UUID id) {

        parentService.delete(id);
        return "redirect:/parent/";
    }

    @GetMapping("/edit/{id}")
    public String editParent(@PathVariable("id") UUID id, Model model) {

        Parent parent = parentService.findById(id);
        model.addAttribute("parent", parent);

        return "editParent";
    }

    @PostMapping("/update/{id}")
    public String updateParent(@PathVariable("id") UUID id, @ModelAttribute Parent parent) {
        parentService.save(parent);

        return "redirect:/parent/";
    }

}