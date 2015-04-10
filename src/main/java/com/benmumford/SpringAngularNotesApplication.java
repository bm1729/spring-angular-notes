package com.benmumford;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.benmumford.data.dao.TagRepository;
import com.benmumford.data.entity.Tag;

@SpringBootApplication
public class SpringAngularNotesApplication implements CommandLineRunner {

    @Autowired TagRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(SpringAngularNotesApplication.class, args);
    }

	@Override
	public void run(String... arg0) throws Exception {
		Tag tag = new Tag();
		tag.setName("Hello");
		repository.save(tag);
	}
}
