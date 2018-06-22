package at.pz.pwny.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import at.pz.pwny.model.Stream;
import at.pz.pwny.service.TwitchService;

@Controller
@RequestMapping("/twitch")
public class TwitchController {

  @Autowired
  private TwitchService twitchService;

  @RequestMapping("/getStreams")
  @ResponseBody
  public List<Stream> getStreams() {
    return twitchService.getStreams();
  }

}
