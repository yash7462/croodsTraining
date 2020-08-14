package com.springbatchwithjpa.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/load")
public class MainController {

	@Autowired
	JobLauncher jobLauncher;

	@Autowired
	Job job;

	@GetMapping
	public BatchStatus show() throws JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException,
			JobInstanceAlreadyCompleteException {
		Map<String, JobParameter> maps = new HashMap<>();
		maps.put("time", new JobParameter(System.currentTimeMillis()));

		JobParameters parameters = new JobParameters(maps);
		JobExecution jobExecution = jobLauncher.run(job, parameters);
		
		System.out.println("job Execution:" +jobExecution.getStatus());;
		
		System.out.println("batch is running...");
		
		while(jobExecution.isRunning()) {
			System.out.println("....");
		}
		
		return jobExecution.getStatus();
	}

}
