package com.example.springpractice.event;

import org.springframework.context.ApplicationEvent;

public class OneSecEvent extends ApplicationEvent {
	public OneSecEvent(Object source) {
		super(source);
	}
}
