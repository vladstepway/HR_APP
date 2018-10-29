package com.company.controller;

import java.util.List;

import com.company.model.InterviewFeedback;

import com.company.service.InterviewFeedbackService;
import com.company.service.InterviewService;
import com.company.service.UserService;
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


/**
 *
 */
@Controller
public class InterviewFeedbackController {

    @Autowired
    private InterviewFeedbackService interviewFeedbackService;
    @Autowired
    private InterviewService interviewService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/interviewFeedback/{id}", method = RequestMethod.GET)
    public String getInterviewFeedback(@PathVariable int id, ModelMap interviewFeedbackModel) {
        interviewFeedbackModel.addAttribute("interviewFeedback", interviewFeedbackService.getInterviewFeedback(id));
        return "feedback/interviewFeedbackInfo";
    }

    @RequestMapping(value = "/allInterviewFeedbacks", method = RequestMethod.GET)
    public String getInterviewFeedbacks(ModelMap interviewFeedbackModel) {
        interviewFeedbackModel.addAttribute("interviewFeedback", interviewFeedbackService.getAllInterviewFeedbacks());
        return "feedback/allInterviewFeedbacks";
    }

    @RequestMapping(value = "/interviewFeedback/add", method = RequestMethod.GET)
    public String addPage(Model model) {
        model.addAttribute("interviewFeedback", new InterviewFeedback());
        return "feedback/addInterviewFeedback";
    }

    @RequestMapping(value = "/interviewFeedback/add.do", method = RequestMethod.POST)
    public String addInterviewFeedback(@Valid InterviewFeedback interviewFeedback, BindingResult bindingResult,
                                       Model interviewFeedbackModel) {
        if (bindingResult.hasErrors()) {
            return "feedback/addInterviewFeedback";
        }
        interviewFeedbackModel.addAttribute("interviewFeedback", interviewFeedback);

        int resp = interviewFeedbackService.addInterviewFeedback(interviewFeedback);
        if (resp > 0) {
            interviewFeedbackModel.addAttribute("msg", "InterviewFeedback with id : " + resp + " added successfully.");
            interviewFeedbackModel.addAttribute("interviewFeedback", interviewFeedbackService.getAllInterviewFeedbacks());
            return "feedback/allInterviewFeedbacks";
        } else {
            interviewFeedbackModel.addAttribute("msg", "InterviewFeedback addition failed.");
            return "feedback/addInterviewFeedback";
        }
    }

    @RequestMapping(value = "/interviewFeedback/delete/{id}", method = RequestMethod.GET)
    public String deleteInterviewFeedback(@PathVariable("id") int id, ModelMap interviewFeedbackModel) {
        int resp = interviewFeedbackService.deleteInterviewFeedback(id);
        interviewFeedbackModel.addAttribute("interviewFeedback", interviewFeedbackService.getAllInterviewFeedbacks());
        if (resp > 0) {
            interviewFeedbackModel.addAttribute("msg", "InterviewFeedback with id : " + id + " deleted successfully.");
        } else {
            interviewFeedbackModel.addAttribute("msg", "InterviewFeedback with id : " + id + " deletion failed.");
        }
        return "feedback/allInterviewFeedbacks";
    }

    @RequestMapping(value = "/interviewFeedback/update/{id}", method = RequestMethod.GET)
    public String updatePage(@PathVariable("id") int id, ModelMap interviewFeedbackModel) {
        interviewFeedbackModel.addAttribute("id", id);
        interviewFeedbackModel.addAttribute("interviewFeedback", interviewFeedbackService.getInterviewFeedback(id));
        return "feedback/updateInterviewFeedback";
    }

    @RequestMapping(value = "/interviewFeedback/update", method = RequestMethod.POST)
    public String updateInterviewFeedback(@Valid InterviewFeedback interviewFeedback, BindingResult bindingResult,
                                  Model model) {
        if (bindingResult.hasErrors()) {
            return "feedback/updateInterviewFeedback";
        }
        model.addAttribute("interviewFeedback", interviewFeedback);

        int resp = interviewFeedbackService.updateInterviewFeedback(interviewFeedback);
        model.addAttribute("id", interviewFeedback.getInterviewId());
        if (resp > 0) {
            model.addAttribute("msg", "InterviewFeedback with id : " + interviewFeedback.getInterviewId() + " updated successfully.");
            model.addAttribute("interviewFeedback", interviewFeedbackService.getAllInterviewFeedbacks());
            return "feedback/allInterviewFeedbacks";
        } else {
            model.addAttribute("msg", "InterviewFeedback with id : " + interviewFeedback.getInterviewId() + " update failed.");
            model.addAttribute("interviewFeedback", interviewFeedbackService.getInterviewFeedback(interviewFeedback.getInterviewId()));
            return "feedback/updateInterviewFeedback";
        }
    }
    @ModelAttribute("interviewIdList")
    public List<String> getInterviewIdList() {
        return interviewService.getAllInterviewsID();
    }
    @ModelAttribute("interviewerIdList")
    public List<String> getInterviewerIdList() {
        return userService.getInterviewerId();
    }
    @ModelAttribute("feedbackStatesList")
    public List<String> getFeedbackStatesList() {
        return interviewFeedbackService.getFeedbackStates();
    }
}
