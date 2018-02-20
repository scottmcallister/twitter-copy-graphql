package com.example.graphqlservice;

import com.example.graphqlservice.model.Tweet;
import com.example.graphqlservice.model.User;
import com.example.graphqlservice.repository.*;
import com.example.graphqlservice.resolver.Mutation;
import com.example.graphqlservice.resolver.Query;
import com.example.graphqlservice.resolver.TweetResolver;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public TweetResolver userResolver(UserRepository userRepository) {
		return new TweetResolver(userRepository);
	}

	@Bean
	public Query query(TweetRepository tweetRepository, UserRepository userRepository) {
		return new Query(tweetRepository, userRepository);
	}

	@Bean
	public Mutation mutation(TweetRepository tweetRepository, UserRepository userRepository) {
		return new Mutation(tweetRepository, userRepository);
	}

	@Bean public CommandLineRunner demo(TweetRepository tweetRepository, UserRepository userRepository) {
		return (args) -> {
			User user = new User();
			user.setName("Donald J. Trump");
			user.setHandle("realDonaldTrump");
			user.setBio("45th President of the United States of America\uD83C\uDDFA\uD83C\uDDF8");
			user.setLocation("Washington, DC");
			user.setWebsite("Instagram.com/realDonaldTrump");
			userRepository.save(user);
			Tweet tweet = new Tweet();
			tweet.setAuthor(user);
			tweet.setText("We are prepared to launch fire and fury on North Korea!");
			tweetRepository.save(tweet);
			Tweet tweet2 = new Tweet();
			tweet2.setAuthor(user);
			tweet2.setText("Despite the negative press covfefe");
			Tweet tweet3 = new Tweet();
			tweetRepository.save(tweet2);
			tweet3.setAuthor(user);
			tweet3.setText("Crooked Hillary is the worst (and biggest) loser of all time");
			tweetRepository.save(tweet3);
		};
	}

}
