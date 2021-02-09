package com.example.codeclan.folderservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name="files")
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String extension;

    @Column
    private int size;

    @ManyToOne // Many files can exist in one folder
    @JoinColumn(name = "folder_id", nullable=false)
    @JsonIgnoreProperties({"files"})
    private Folder folder;

    public File(String name, String extension, int size) {
        this.name = name;
        this.extension = extension;
        this.size = size;
    }

    // Default constructor for Spring to use
    public File() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Folder getFolder() {
        return folder;
    }

    public void setFolder(Folder folder) {
        this.folder = folder;
    }
}
