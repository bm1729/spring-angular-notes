package com.benmumford;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.benmumford.data.dao.NoteRepository;
import com.benmumford.data.dao.TagRepository;
import com.benmumford.data.entity.Note;
import com.benmumford.data.entity.Tag;

@SpringBootApplication
public class SpringAngularNotesApplication implements CommandLineRunner {

    @Autowired TagRepository tagRepository;
    @Autowired NoteRepository noteRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringAngularNotesApplication.class, args);
    }

	@Override
	public void run(String... arg0) throws Exception {
		Tag tag = new Tag();
		tag.setName("name");
		tag = tagRepository.save(tag);
		
		Note note = new Note();
		note.setBusinessContent("businessContent");
		note.setTechnicalContent("technicalContent");
		note.setTitle("title");
		note.setTags(Arrays.asList(tag));
		note = noteRepository.save(note);
	}
}
