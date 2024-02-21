package com.app.slackdame;

import com.app.slackdame.entity.Channel;
import com.app.slackdame.entity.Post;
import com.app.slackdame.entity.User;
import com.app.slackdame.repository.ChannelRepository;
import com.app.slackdame.repository.PostRepository;
import com.app.slackdame.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class SlackDameApplicationTests {

	@Autowired
	UserRepository userRepository;

	@Autowired
	ChannelRepository channelRepository;

	@Autowired
	PostRepository postRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void addUserToChannelAndPost() {
		//add user
		User user1 = new User("jeff", "jeff@jeff.com", "123");
		userRepository.save(user1);

		//add channel
		Channel channel1 = new Channel("canal 1", true);
		channel1.setUser(user1);
		channelRepository.save(channel1);

		//add post
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		Date postDate;
		try {
			postDate = dateFormat.parse("2024-05-05T18:00:00");
		} catch (ParseException e) {
			// Handle the exception appropriately
			throw new RuntimeException("Error parsing date string", e);
		}

		Post post1 = new Post("post 1", postDate);
		post1.setUser(user1);
		post1.setChannel(channel1);
		postRepository.save(post1);
	}

}
