package com.example.codeclan.folderservice.components;

import com.example.codeclan.folderservice.models.File;
import com.example.codeclan.folderservice.models.Folder;
import com.example.codeclan.folderservice.models.User;
import com.example.codeclan.folderservice.repositories.FileRepository;
import com.example.codeclan.folderservice.repositories.FolderRepository;
import com.example.codeclan.folderservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


// This file will seed the database each time we run the program.

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;
    @Autowired
    FolderRepository folderRepository;
    @Autowired
    FileRepository fileRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args) {

        User user1 = new User("Bob Fellows");
        userRepository.save(user1);
        User user2 = new User("Green Arrow");
        userRepository.save(user2);
        User user3 = new User("The Bean");
        userRepository.save(user3);

        Folder folder1 = new Folder("My Documents", user1);
        folderRepository.save(folder1);
        Folder folder2 = new Folder("My Fav Food", user2);
        folderRepository.save(folder2);
        Folder folder3 = new Folder("Programs x86", user3);
        folderRepository.save(folder3);

        File file1 = new File("resume", "doc", 450, folder1);
        fileRepository.save(file1);
        File file2 = new File("recipes", "txt", 110, folder2);
        fileRepository.save(file2);
        File file3 = new File("how to guide", "exe", 9500, folder3);
        fileRepository.save(file3);

    }

}