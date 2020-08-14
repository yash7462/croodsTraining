package com.batchdemo.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.batchdemo.model.Person;

@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

	private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);
	
	private final JdbcTemplate jdbcTemplete;

	@Autowired
	public JobCompletionNotificationListener(JdbcTemplate jdbcTemplete) {
		this.jdbcTemplete = jdbcTemplete;
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
			log.info("---JOB FINISHED, time to verify the result---");
			
			jdbcTemplete.query("select firstname,lastname from people",
					(rs,row) -> new Person(rs.getString(1), rs.getString(2)))
			.forEach(person -> log.info("Found <" + person + "> in the database."));
			
		}
	}
	
	
}
