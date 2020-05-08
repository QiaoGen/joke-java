package com.joke.controller;

import com.joke.config.tip.SuccessTip;
import com.joke.config.tip.Tip;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/WxUpload")
public class WxUploadController {

    @PostMapping("/uploadFile")
    @ResponseBody
    public Tip upLoadFeedBackImage(@RequestParam("file") MultipartFile files, HttpServletRequest request){
//        for (int i = 0; i < files.size(); i++){
            try {
                String originalName = files.getOriginalFilename();
                System.out.println(originalName.substring(originalName.lastIndexOf('.')));
                String newName = UUID.randomUUID() + originalName.substring(originalName.lastIndexOf('.'));
                String path= "D://usr/audio/" + newName;
                File newFile = new File(path);
                files.transferTo(newFile);
//                String httpFeedBackName ="/"+ Constants.FEEDBACKURL +"/"+ newName;
//                HttpSession session = request.getSession();
//                String sessionId = WebUtils.toHttp(request).getHeader(AUTHORIZATION).toLowerCase();
//                List<String> httpFeedBackNames = (LinkedList<String>) session.getAttribute(sessionId) ;
//                if(httpFeedBackNames == null){
//                    httpFeedBackNames = new LinkedList<>();
//                }
//                httpFeedBackNames.add(httpFeedBackName);
//                session.setAttribute(sessionId,httpFeedBackNames);
//                session.setMaxInactiveInterval(300);
            } catch (IOException e) {
                e.printStackTrace();
            }
//        }
        return new SuccessTip();
    }

}
