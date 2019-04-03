package com.festlist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.TemplateEngine;

import com.festlist.model.Festival;
import com.festlist.service.EmailSender;


@Controller
public class MailController {

	private Festival festival;
	private final EmailSender emailSender;
	private final TemplateEngine templateEngine;

	
	@Autowired
	public MailController(EmailSender emailSender, TemplateEngine templateEngine) {
		this.emailSender = emailSender;
		this.templateEngine = templateEngine;
	}
	
	
	@RequestMapping("/sendmail")
    public String send() {
		
		org.thymeleaf.context.Context context = new org.thymeleaf.context.Context();
        context.setVariable("header", "x");
        context.setVariable("title", "#TEST");
        context.setVariable("description", "MAIN MAIL");
        String body = templateEngine.process("template", context);
        emailSender.sendEmail("test46004@gmail.com", "Brzask band booking", body);
        return "festival";
    }


}
