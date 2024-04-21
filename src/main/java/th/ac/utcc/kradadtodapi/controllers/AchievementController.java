package th.ac.utcc.kradadtodapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import th.ac.utcc.kradadtodapi.models.Achievement;
import th.ac.utcc.kradadtodapi.repositories.AchievementRepository;

import java.util.List;

@RestController
@RequestMapping("/achievement")
public class AchievementController {
    private final AchievementRepository achievementRepository;

    public AchievementController(AchievementRepository achievementRepository) {
        this.achievementRepository = achievementRepository;
    }

    @GetMapping("/getAchievement")
    List<Achievement> getAllAchievement() {
        return achievementRepository.findAll();
    }

    @GetMapping("/getById")
    List<Achievement> getAllTransactions(@RequestParam Long id) {
        return achievementRepository.findByMemberId(id);
    }
}
