package metube.domain.models.view;

/**
 * Created by Nino Bonev - 7.2.2019 г., 20:07
 */
public class TubesDetailsViewModel {

    private String name;
    private String description;
    private String youTubeLink;
    private String uploader;

    public TubesDetailsViewModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getYouTubeLink() {
        return youTubeLink;
    }

    public void setYouTubeLink(String youTubeLink) {
        this.youTubeLink = youTubeLink;
    }

    public String getUploader() {
        return uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }
}
