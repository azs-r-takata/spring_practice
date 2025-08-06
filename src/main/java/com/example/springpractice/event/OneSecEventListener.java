package com.example.springpractice.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
@Getter
public class OneSecEventListener {
	private int count;
	
	@EventListener
	private void onOneSecEvent(OneSecEvent event) {
		this.count++;
	}
}
