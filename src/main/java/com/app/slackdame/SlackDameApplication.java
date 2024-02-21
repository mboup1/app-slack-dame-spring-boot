package com.app.slackdame;

import com.app.slackdame.entity.Channel;
import com.app.slackdame.repository.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class SlackDameApplication {

		public static void main(String[] args) {
			SpringApplication.run(SlackDameApplication.class, args);
		}


	@Component
	class DataLoader implements ApplicationRunner {

		@Autowired
		ChannelRepository channelRepository;

		@Override
		public void run(ApplicationArguments args) {

			if (channelRepository.count() == 0) {
				// Si la liste des channels est vide, créez le canal Général
				Channel general = new Channel("Général", false);
				channelRepository.save(general);
			}
		}
	}


}
