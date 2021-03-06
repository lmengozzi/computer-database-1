package com.excilys.cli;

import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.excilys.services.ComputerService;

@Component
public class DeleteComputerCommand implements Command {
	
	@Autowired
	private ComputerService service;
	
	final Logger logger = LoggerFactory.getLogger(DeleteComputerCommand.class);

	@Override
	public void doAction(List<String> args, Scanner sc) {
		for (String s : args) {
			try {
				service.deleteComputer(Long.parseLong(s));
				logger.info("Computer " + s + " deleted.");
			} catch (NumberFormatException e) {
				logger.error("The entered number isn't a long.");
			}
		}
	}

}
