package com.example.configuration;


import com.example.model.Clazz;
import com.example.model.Student;
import com.example.service.ClazzService;
import com.example.service.IClazzService;
import com.example.service.IStudentService;
import com.example.service.StudentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.example")
public class AppConfiguration implements WebMvcConfigurer {
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
    @Bean
    public IStudentService<Student> StudentService(){
        return new StudentService();
    }
    @Bean
    public IClazzService<Clazz> ClazzService() {
        return new ClazzService();
    }
}
