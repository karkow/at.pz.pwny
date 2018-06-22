package at.pz.pwny.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Stream {

  private String userLogin;

  private String title;

  @JsonProperty("thumbnail_url")
  private String thumbnailUrl;

  private String type;

  @JsonProperty("viewer_count")
  private int viewerCount;

  @JsonProperty("user_id")
  private String userId;

  private String wowClass;

  public String getUserLogin() {
    return userLogin;
  }

  public void setUserLogin(String userLogin) {
    this.userLogin = userLogin;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getThumbnailUrl() {
    return thumbnailUrl;
  }

  public void setThumbnailUrl(String thumbnailUrl) {
    this.thumbnailUrl = thumbnailUrl;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public int getViewerCount() {
    return viewerCount;
  }

  public void setViewerCount(int viewerCount) {
    this.viewerCount = viewerCount;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getWowClass() {
    return wowClass;
  }

  public void setClass(String wowClass) {
    this.wowClass = wowClass;
  }
}
