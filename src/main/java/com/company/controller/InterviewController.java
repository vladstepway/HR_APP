package com.company.controller;

import com.company.model.Interview;
import com.company.service.CandidateService;
import com.company.service.InterviewService;
import com.company.service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

/**
 *
 */
@Controller
public class InterviewController {

    @Autowired
    private InterviewService interviewService;
    @Autowired
    private VacancyService vacancyService;
    @Autowired
    private CandidateService candidateService;

    @RequestMapping(value = "/interview/{id}", method = RequestMethod.GET)
    public String getInterview(@PathVariable int id, ModelMap interviewModel) {
        interviewModel.addAttribute("interview", interviewService.getInterview(id));
        return "interview/interviewInfo";
    }

    @RequestMapping(value = "/allInterviews", method = RequestMethod.GET)
    public String getInterviews(ModelMap interviewModel) {
        interviewModel.addAttribute("interview", interviewService.getAllInterviews());
        return "interview/allInterviews";
    }

    @RequestMapping(value = "/interview/add", method = RequestMethod.GET)
    public String addPage(Model model) {
        model.addAttribute("interview", new Interview());
        return "interview/addInterview";
    }

    @RequestMapping(value = "/interview/add.do", method = RequestMethod.POST)
    public String addInterview(@Valid Interview interview, BindingResult bindingResult,
                               Model interviewModel) {
        if (bindingResult.hasErrors()) {
            return "interview/addInterview";
        }
        interviewModel.addAttribute("interview", interview);

        int resp = interviewService.addInterview(interview);
        if (resp > 0) {
            interviewModel.addAttribute("msg", "Interview with id : " + resp + " added successfully.");
            interviewModel.addAttribute("interview", interviewService.getAllInterviews());
            return "interview/allInterviews";
        } else {
            interviewModel.addAttribute("msg", "Interview addition failed.");
            return "interview/addInterview";
        }
    }

    @RequestMapping(value = "/interview/delete/{id}", method = RequestMethod.GET)
    public String deleteInterview(@PathVariable("id") int id, ModelMap interviewModel) {
        int resp = interviewService.deleteInterview(id);
        interviewModel.addAttribute("interview", interviewService.getAllInterviews());
        if (resp > 0) {
            interviewModel.addAttribute("msg", "Interview with id : " + id + " deleted successfully.");
        } else {
            interviewModel.addAttribute("msg", "Interview with id : " + id + " deletion failed.");
        }
        return "interview/allInterviews";
    }

    @RequestMapping(value = "/interview/update/{id}", method = RequestMethod.GET)
    public String updatePage(@PathVariable("id") int id, ModelMap interviewModel) {
        interviewModel.addAttribute("id", id);
        interviewModel.addAttribute("interview", interviewService.getInterview(id));
        return "interview/updateInterview";
    }

    @RequestMapping(value = "/interview/update", method = RequestMethod.POST)
    public String updateInterview(Interview interview,
                                  Model interviewModel) {
        interviewModel.addAttribute("interview", interview);

        int resp = interviewService.updateInterview(interview);
        interviewModel.addAttribute("id", interview.getId());
        if (resp > 0) {
            interviewModel.addAttribute("msg", "Interview with id : " + interview.getId() + " updated successfully.");
            interviewModel.addAttribute("interview", interviewService.getAllInterviews());
            return "interview/allInterviews";
        } else {
            interviewModel.addAttribute("msg", "Interview with id : " + interview.getId() + " update failed.");
            interviewModel.addAttribute("interview", interviewService.getInterview(interview.getId()));
            return "interview/updateInterview";
        }
    }

    @ModelAttribute("vacancyIdList")
    public List<String> getVacancyIdList() {
//         добавляем все id вакансий
        return vacancyService.getVacanciesID();
    }

    @ModelAttribute("vacancyPositionsList")
    public List<String> getVacancyPositionsList() {
        // добавляем все id вакансий
        return vacancyService.getVacanciesPosition();
    }


    @ModelAttribute("candidateIdList")
    public List<String> getCandidateIdList() {
        return candidateService.getAllCandidatesID();
    }
}
