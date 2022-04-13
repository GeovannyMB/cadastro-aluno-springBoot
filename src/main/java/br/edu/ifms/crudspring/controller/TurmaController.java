package br.edu.ifms.crudspring.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifms.crudspring.model.Turma;
import br.edu.ifms.crudspring.service.TurmaService;

@Controller
@RequestMapping("/turma")
public class TurmaController {

    @Autowired
    TurmaService turmaService;

    @PostMapping("/")
    public String save(@ModelAttribute("turma") Turma turma) {
        turmaService.save(turma);
        return "redirect:/turma/";
    }

    // -------------------------------------------
    @GetMapping("/")
    public String locAll(Model model) {
        List<Turma> turmas = turmaService.getTurmas();
        model.addAttribute("turmas", turmas);
        return "turma";
    }

    // -------------------------------------------
    @GetMapping("/cadastrarTurma")
    public String newStudent(Model model) {
        model.addAttribute("turma", new Turma());
        return "cadastrarTurma";
    }

    // -------------------------------------------
    @GetMapping("/remove/{id}")
    public String removerStudent(@PathVariable("id") UUID id) {

        turmaService.delete(id);
        return "redirect:/turma/";
    }

    @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable("id") UUID id, Model model) {

        Turma turma = turmaService.findById(id);
        model.addAttribute("turma", turma);

        return "editStudent";
    }

    @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable("id") UUID id, @ModelAttribute Turma turma) {
        turmaService.save(turma);

        return "redirect:/turma/";
    }

}
