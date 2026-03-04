package io.darbata.runactivitytracker.tracker;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TrackerController {

    private final TrackerService service;

    public TrackerController(TrackerService service) {
        this.service = service;
    }

    // home page
    @GetMapping("/")
    public String index(Model model) {
        List<RunActivityDto> runs = service.findAllRunActivities();
        model.addAttribute("runs", runs);
        model.addAttribute("postRequest", new RunActivityPostRequest(0, 0, 0));
        return "index";
    }

    @PostMapping("/runs")
    public String saveRunActivity(RunActivityPostRequest request) {
        service.saveRunActivity(request.distance(), request.averagePace(), request.averageHeartRate());
        return "redirect:/"; // go back to index
    }

    @DeleteMapping("/runs/{runId}")
    public String deleteRunActivity(@PathVariable("runId") long runId) {
        service.deleteRunActivity(runId);
        return "redirect:/";
    }

}