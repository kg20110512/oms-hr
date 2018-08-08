package com.neo.web;

import com.neo.entity.Atm;
import com.neo.entity.AtmRet;
import com.neo.service.AtmService;
import org.bson.types.Binary;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/atm")
public class AtmController {

    @Resource
    AtmService atmService;

    @RequestMapping("/list/{userid}")
    public String list(Model model, @PathVariable String userid) {
        List<Atm> atms = atmService.getAtmList(userid);
        model.addAttribute("userid", userid);
        model.addAttribute("atms", atms);
        return "atm/list";
    }


    @PostMapping("/{userid}")
    public ResponseEntity<AtmRet> add(@RequestParam("file") MultipartFile file, @PathVariable String userid) throws IOException {
//        atmService.save(atm);
        Atm returnFile = null;
        AtmRet atmRet = new AtmRet();
        Atm atm = new Atm(file.getOriginalFilename(), userid, file.getContentType(), file.getSize(),
                new Binary(file.getBytes()));
        returnFile = atmService.save(atm);
        atmRet.setFileId(returnFile.getId());
        atmRet.setFile(returnFile);
        return ResponseEntity.status(HttpStatus.OK).body(atmRet);

    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Object> serveFile(@PathVariable String id) throws UnsupportedEncodingException {

        Optional<Atm> atm = atmService.findById(id);
        if (atm.isPresent()) {
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; fileName=" + new String(atm.get().getName().getBytes("utf-8"), "ISO-8859-1"))
                    .header(HttpHeaders.CONTENT_TYPE, "application/octet-stream")
                    .header(HttpHeaders.CONTENT_LENGTH, atm.get().getSize() + "").header("Connection", "close")
                    .body(atm.get().getContent().getData());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("File was not fount");
        }

    }


    @GetMapping("/list/del/{id}/{userid}")
    public String delete(@PathVariable String id, @PathVariable String userid) {
        atmService.delete(id);
        return "redirect:/atm/list/"+userid;
    }
}
