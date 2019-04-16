package metube.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by Nino Bonev - 7.2.2019 г., 18:06
 */

@Entity(name = "tubes")
public class Tube extends BaseEntity{

    private String name;
    private String description;
    private String youTubeLink;
    private String uploader;

    public Tube() {
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "youTubeLink")
    public String getYouTubeLink() {
        return youTubeLink;
    }

    public void setYouTubeLink(String youTubeLink) {
        this.youTubeLink = youTubeLink;
    }

    @Column(name = "uploader")
    public String getUploader() {
        return uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }
}