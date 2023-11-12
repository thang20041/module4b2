package com.example.controller;

import com.example.model.Clazz;
import com.example.model.Student;
import com.example.service.ClazzService;
import com.example.service.IClazzService;
import com.example.service.IStudentService;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private IStudentService<Student> StudentService;
    @Autowired
    private IClazzService<Clazz> ClazzService;

    @GetMapping("findall")
    public ModelAndView FindAll() {
        ModelAndView modelAndView = new ModelAndView("home");
        List<Student> list = StudentService.FindAll();
        modelAndView.addObject("listStudent", list);
        return modelAndView;
    }

    @GetMapping("create")
    public ModelAndView Create() {
        ModelAndView modelAndView = new ModelAndView("create");
        List<Clazz> clazzList = ClazzService.findAll();
        modelAndView.addObject("clasezList", clazzList);
        return modelAndView;
    }

    @PostMapping("create")
    public String CreateStudent(@RequestParam("name") String name,
                                @RequestParam("dateOfBirth") String dob,
                                @RequestParam("email") String email,
                                @RequestParam("address") String address,
                                @RequestParam("phoneNumber") String phone,
                                @RequestParam("classRoomId") int classroomID) {
        StudentService.add(new Student(name, dob, email, address, phone, new Clazz(classroomID)));
        return "redirect:/student/findall";
    }

    @GetMapping("edit/{id}")
    public ModelAndView Edit(@PathVariable int id) {
        Student student = StudentService.findStudentById(id);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("editStudent", student);
        List<Clazz> clazzList = ClazzService.findAll();
        modelAndView.addObject("clasezList", clazzList);
        return modelAndView;
    }

    @PostMapping("edit/{id}")
    public String EditStudent(@RequestParam("id") int id,
                              @RequestParam("name") String name,
                              @RequestParam("dateOfBirth") String dob,
                              @RequestParam("email") String email,
                              @RequestParam("address") String address,
                              @RequestParam("phoneNumber") String phone,
                              @RequestParam("classRoomId") int classroomID
    ) {
        StudentService.edit(id, new Student(name, dob, email, address, phone, new Clazz(classroomID)));
        return "redirect:/student/findall";
    }

    @GetMapping("delete/{id}")
    public String DeleteStudent(@PathVariable int id) {
        StudentService.delete(id);
        return "redirect:/student/findall";
    }
}
