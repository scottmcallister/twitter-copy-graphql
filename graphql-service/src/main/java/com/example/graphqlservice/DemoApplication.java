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

import java.util.HashMap;
import java.util.Map;

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
			Map<String, User> users = generateUsers(userRepository);
			generateTweets(tweetRepository, users);
		};
	}

	public Map<String, User> generateUsers(UserRepository userRepository) {
		Map<String, User> users = new HashMap<>();
		User trump = new User();
		trump.setName("Donald J. Trump");
		trump.setHandle("realDonaldTrump");
		trump.setBio("45th President of the United States of America\uD83C\uDDFA\uD83C\uDDF8");
		trump.setLocation("Washington, DC");
		trump.setWebsite("Instagram.com/realDonaldTrump");
		users.put("trump", trump);
		User taylor = new User();
		taylor.setName("Taylor Swift");
		taylor.setHandle("taylorswift13");
		taylor.setBio("The old Taylor can't come to the phone right now.");
		taylor.setWebsite("taylor.lk/reputation-iT");
		users.put("taylor", taylor);
		User kim = new User();
		kim.setName("Kim Kardashian West");
		kim.setHandle("KimKardashian");
		kim.setWebsite("KKWBEAUTY.COM");
		users.put("kim", kim);
		User obama = new User();
		obama.setName("Barack Obama");
		obama.setHandle("BarackObama");
		obama.setBio("Dad, husband, President, citizen.");
		obama.setLocation("Washington, DC");
		obama.setWebsite("obama.org");
		users.put("obama", obama);
		userRepository.save(trump);
		userRepository.save(obama);
		userRepository.save(kim);
		userRepository.save(taylor);
		return users;
	}

	public void generateTweets(TweetRepository tweetRepository, Map<String, User> users) {
		Tweet tweet = new Tweet();
		tweet.setAuthor(users.get("trump"));
		tweet.setText("We are prepared to launch fire and fury on North Korea!");
		tweetRepository.save(tweet);
		Tweet tweet2 = new Tweet();
		tweet2.setAuthor(users.get("trump"));
		tweet2.setText("Despite the negative press covfefe");
		tweetRepository.save(tweet2);
		Tweet tweet3 = new Tweet();
		tweet3.setAuthor(users.get("trump"));
		tweet3.setText("Crooked Hillary is the worst (and biggest) loser of all time");
		tweetRepository.save(tweet3);
		Tweet tweet4 = new Tweet();
		tweet4.setAuthor(users.get("obama"));
		tweet4.setText("No one is born hating another person because of the color of his " +
				"skin or his background or his religion...");
		tweetRepository.save(tweet4);
		Tweet tweet5 = new Tweet();
		tweet5.setAuthor(users.get("obama"));
		tweet5.setText("John McCain is an American hero & one of the bravest fighters I've ever known. " +
				"Cancer doesn't know what it's up against. Give it hell, John.");
		tweetRepository.save(tweet5);
		Tweet tweet6 = new Tweet();
		tweet6.setAuthor(users.get("taylor"));
		tweet6.setText("I just used a Sharpie as eye liner in the airplane bathroom");
		tweetRepository.save(tweet6);
		Tweet tweet7 = new Tweet();
		tweet7.setAuthor(users.get("taylor"));
		tweet7.setText("Just clipped my cat's claws all by myself. Didn't get mauled. Celebrate life's little victories");
		tweetRepository.save(tweet7);
		Tweet tweet8 = new Tweet();
		tweet8.setAuthor(users.get("taylor"));
		tweet8.setText("It's a daily struggle for me not to buy more cats.");
		tweetRepository.save(tweet8);
		Tweet tweet9 = new Tweet();
		tweet9.setAuthor(users.get("kim"));
		tweet9.setText("Watching paternity tests on Maury! So scandalous!!!");
		tweetRepository.save(tweet9);
		Tweet tweet10 = new Tweet();
		tweet10.setAuthor(users.get("kim"));
		tweet10.setText("This 2 year old smoking baby in Indonesia is just disturbing. Is this legal?");
		tweetRepository.save(tweet10);
		Tweet tweet11 = new Tweet();
		tweet11.setAuthor(users.get("kim"));
		tweet11.setText("Kit Kat is my fav candy bar but its tastes different in other countries. " +
				"Why would they change the filling in between the wafers?");
		Tweet tweet12 = new Tweet();
		tweet12.setAuthor(users.get("obama"));
		tweet12.setText("It's been the honor of my life to serve you. You made me a better leader and a better man.");
		tweetRepository.save(tweet12);

	}

}
