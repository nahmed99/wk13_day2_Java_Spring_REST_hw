package com.example.codeclan.folderservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="folders")
public class Folder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @OneToMany(mappedBy = "folder") // A folder can have many files. Map to folders in file objects
    @JsonIgnoreProperties("folder")
    private List<File> files;

    @ManyToOne // Many folders can be owned by one user
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnoreProperties("folders") // there is a LIST of folderS in the user object, that we need to ignore.
    private User user;

    public Folder(String title, List<File> files, User user) {
        this.title = title;
        this.files = files;
        this.user = user;
    }

    // empty constructor for Spring to use
    public Folder() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
