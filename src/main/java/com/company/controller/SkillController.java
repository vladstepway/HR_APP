package com.company.controller;

import com.company.model.Skill;
import com.company.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class SkillController {

    @Autowired
    private SkillService skillService;



    @RequestMapping(value = "/allSkills", method = RequestMethod.GET)
    public String getAllSkills(ModelMap skillModel) {
        skillModel.addAttribute("skill", skillService.getAllSkills());
        return "skill/allSkills";
    }

    @RequestMapping(value = "skill/add")
    public String addPage(Model model) {
        model.addAttribute("skill",new Skill());
        return "skill/addSkill";
    }

    @RequestMapping(value = "/skill/add.do", method = RequestMethod.POST)
    public String addSkill(Skill skill,
                           ModelMap skillModel) {
        skillModel.addAttribute("skill", skill);
        int resp = skillService.addSkill(skill);
        if (resp > 0) {
            skillModel.addAttribute("msg", "Skill: " + skill.getName() + " added successfully.");
            skillModel.addAttribute("skill", skillService.getAllSkills());
            return "skill/allSkills";
        } else {
            skillModel.addAttribute("msg", "Skill addition failed.");
            return "skill/addSkill";
        }
    }

    @RequestMapping(value = "/skill/delete/{name}", method = RequestMethod.GET)
    public String deleteSkill(@PathVariable("name") String name, ModelMap skillModel) {
        int resp = skillService.deleteSkill(name);
        skillModel.addAttribute("skill", skillService.getAllSkills());
        if (resp > 0) {
            skillModel.addAttribute("msg", "Skill  : " + name + " deleted successfully.");
        } else {
            skillModel.addAttribute("msg", "Skill with id : " + name + " deletion failed.");
        }
        return "skill/allSkills";
    }

    @RequestMapping(value = "/skill/update/{name}", method = RequestMethod.GET)
    public String updatePage(@PathVariable("name") String name, ModelMap skillModel) {
        skillModel.addAttribute("name", name);
        skillModel.addAttribute("skill", skillService.getSkill(name));
        return "skill/updateSkill";
    }

    @RequestMapping(value = "/skill/update", method = RequestMethod.POST)
    public String updateSkill(@RequestParam(value = "name", required = true) String name,
                             ModelMap skillModel) {
        Skill skill = new Skill();
        skill.setName(name);
        int resp = skillService.addSkill(skill);
        skillModel.addAttribute("name", name);
        if (resp > 0) {
            skillModel.addAttribute("msg", "Skill  : " + name + " updated successfully.");
            skillModel.addAttribute("skill", skillService.getAllSkills());
            return "skill/allSkills";
        } else {
            skillModel.addAttribute("msg", "Skill : " + name + " updating failed.");
            skillModel.addAttribute("skill", skillService.getSkill(name));
            return "skill/updateSkill";
        }
    }
}
