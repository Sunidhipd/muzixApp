package com.stackroute.muzixApp;

import com.stackroute.muzixApp.domain.Track;
import com.stackroute.muzixApp.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;

@ComponentScan
@SpringBootApplication
@PropertySource("classpath:application.properties")
public class MuzixAppApplication implements ApplicationListener<ContextRefreshedEvent> , CommandLineRunner {

	@Value("${trackID}")
	private int id;


	@Value("${trackName}")
	private String trackName;


	@Value("${trackComments}")
	private String trackComments;



	@Autowired
	private TrackRepository trackRepository;
	@Autowired
	private Environment env;

	public static void main(String[] args) {
		SpringApplication.run(MuzixAppApplication.class, args);
	}


	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		trackRepository.save(new Track(Integer.parseInt(env.getProperty("trackID")),env.getProperty("trackName"),env.getProperty("trackComments")));
	}

	@Override
	public void run(String...args) throws Exception {
		trackRepository.save(new Track(id,trackName,trackComments));
	}



}

