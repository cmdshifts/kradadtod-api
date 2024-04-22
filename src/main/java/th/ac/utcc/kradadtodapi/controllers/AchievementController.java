package th.ac.utcc.kradadtodapi.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import th.ac.utcc.kradadtodapi.dataTransfer.AchievementPutDTO;
import th.ac.utcc.kradadtodapi.models.Achievement;
import th.ac.utcc.kradadtodapi.models.Member;
import th.ac.utcc.kradadtodapi.repositories.AchievementRepository;
import th.ac.utcc.kradadtodapi.repositories.MemberRepository;

import java.util.List;

@RestController
@RequestMapping("/achievement")
public class AchievementController {
    private final AchievementRepository achievementRepository;
    private final MemberRepository memberRepository;

    public AchievementController(AchievementRepository achievementRepository, MemberRepository memberRepository) {
        this.achievementRepository = achievementRepository;
        this.memberRepository = memberRepository;
    }

    @GetMapping("/getAchievement")
    List<Achievement> getAllAchievement() {
        return achievementRepository.findAll();
    }

    @GetMapping("/getByMemberId")
    List<Achievement> getAllTransactions(@RequestParam Long id) {
        return achievementRepository.findByMemberId(id);
    }

    @PutMapping
    public ResponseEntity<Achievement> createAchievement(@RequestBody AchievementPutDTO achievementPutDTO) throws Exception {
        Member member = memberRepository.findById(achievementPutDTO.getMemberId())
                .orElseThrow(() -> new Exception("Member not found with id: " + achievementPutDTO.getMemberId()));

        Achievement achievement = new Achievement();
        achievement.setId(achievementPutDTO.getAchievementId());
        achievement.setMember(member);
        achievement.setAmount(achievementPutDTO.getAmount());
        achievement.setTime(achievementPutDTO.getDate());

        Achievement savedAchievement = achievementRepository.save(achievement);
        return new ResponseEntity<>(savedAchievement, HttpStatus.OK);
    }
}
