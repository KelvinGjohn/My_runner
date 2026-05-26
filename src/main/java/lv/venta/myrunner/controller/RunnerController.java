package lv.venta.myrunner.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.venta.myrunner.model.Runner;
import lv.venta.myrunner.repository.RunnerRepository;

@Controller
@RequestMapping("/runner")
public class RunnerController {

    @Autowired
    private RunnerRepository runnerRepo;

    // GET ALL RUNNERS
    @GetMapping("/all")
    public String getAllRunners(Model model) {

        try {

            List<Runner> runners = runnerRepo.findAll();

            model.addAttribute("runners", runners);

            return "all-runners-page";

        } catch (Exception e) {

            model.addAttribute("error", e.getMessage());

            return "error-page";
        }
    }

    // ADD RUNNER PAGE
    @GetMapping("/add")
    public String addRunnerPage(Model model) {

        model.addAttribute("runner", new Runner());

        return "add-runner-page";
    }

    // SAVE RUNNER
    @PostMapping("/add")
    public String saveRunner(Runner runner) {

        runnerRepo.save(runner);

        return "redirect:/runner/all";
    }

    // DELETE RUNNER
    @GetMapping("/delete/{id}")
    public String deleteRunner(@PathVariable int id) {

        runnerRepo.deleteById(id);

        return "redirect:/runner/all";
    }
    
    @GetMapping("/update/{idru}")
    public String updateRunnerPage(@PathVariable("idru") Integer idru, Model model) {

        Runner runner = runnerRepo.findById(idru).orElse(null);

        model.addAttribute("runner", runner);

        return "update-runner-page";
    }


    @PostMapping("/update/{idru}")
    public String updateRunner(@PathVariable("idru") Integer idru,
                               @ModelAttribute Runner runner) {

        Runner existingRunner = runnerRepo.findById(idru).orElse(null);

        existingRunner.setName(runner.getName());
        existingRunner.setSurname(runner.getSurname());

        runnerRepo.save(existingRunner);

        return "redirect:/runner/all";
    }
}