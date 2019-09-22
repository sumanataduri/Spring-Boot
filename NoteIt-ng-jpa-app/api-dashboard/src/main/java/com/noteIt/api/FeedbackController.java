package com.noteIt.api;

import javax.validation.ValidationException;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.noteIt.api.viewmodel.FeedbackViewModel;
import com.noteIt.mail.FeedbackSender;

@RestController
@RequestMapping("/api/feedback")
@CrossOrigin
public class FeedbackController {
	
	private FeedbackSender feedbackSender;

	public FeedbackController(FeedbackSender feedbackSender) {
		this.feedbackSender = feedbackSender;
	}
	
	@PostMapping
	public void sendFeedback(@RequestBody FeedbackViewModel feedbackViewModel,
			BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			throw new ValidationException("Feedback has errors: Cannot send Feedback");
		}
		
		this.feedbackSender.sendFeedback(
				feedbackViewModel.getEmail(),
				feedbackViewModel.getName(),
				feedbackViewModel.getFeedback());
		
	}
	

}
