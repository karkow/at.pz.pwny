package at.pz.pwny.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {

  @JsonProperty("data")
  private List<Stream> data;

  public List<Stream> getData() {
    return data;
  }

  public void setData(List<Stream> data) {
    this.data = data;
  }

}
