package at.pz.pwny.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import at.pz.pwny.model.Data;
import at.pz.pwny.model.Stream;

@Service
public class TwitchService {

  @Autowired
  private RestTemplate restTemplate;

  @Value("${clientId}")
  private String clientId;

  public List<Stream> getStreams() {
    List<Stream> streamList = new ArrayList<>();
    HttpHeaders headers = new HttpHeaders();
    headers.set("Client-ID", clientId);

    HttpEntity<String> entity = new HttpEntity<>(headers);

    streamList.add(fetchStream("kernkow", "paladin",  entity));
    streamList.add(fetchStream("vonnogger", "rogue", entity));
    streamList.add(fetchStream("muchaolive", "monk", entity));

    return streamList;
  }

  private Stream fetchStream(String userLogin, String wowClass, HttpEntity<String> entity) {
    ResponseEntity<Data> response = restTemplate.exchange("https://api.twitch.tv/helix/streams?user_login=" + userLogin, HttpMethod.GET, entity, Data.class);
    List<Stream> data = response.getBody().getData();

    Stream stream = data.stream().findFirst().orElse(new Stream());
    stream.setUserLogin(userLogin);
    stream.setClass(wowClass);
    return stream;
  }

}
