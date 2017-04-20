package mars.com.dto;

/**
 * Created by Harsh on 12/23/2016.
 */
public class DashboardListItemsDTO {
    private String title;
    private String desc;
    private Integer image;

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
