package com.ldf.carsharingcompany.Controller;

import com.ldf.carsharingcompany.Service.TimerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TimerController {

    @Autowired
    private TimerService timerService;

    @GetMapping("/startTimer")
    public String startTimer() {
        timerService.startTimer();
        return "redirect:/";
    }

    @GetMapping("/stopTimer")
    public String stopTimer(Model model) {
        long elapsedTime = timerService.stopTimer();
        model.addAttribute("elapsedTime", elapsedTime);
        return "redirect:/";
    }
}
