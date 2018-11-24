package cn.forgeeks.awesome.springboot.fastDFS.controller;

import cn.forgeeks.awesome.springboot.fastDFS.common.FastDFSClientWrapper;
import cn.forgeeks.awesome.springboot.fastDFS.common.MailUtil;
import cn.forgeeks.awesome.springboot.fastDFS.common.MemcachedRunner;
import cn.forgeeks.awesome.springboot.fastDFS.common.FastDFSClientWrapper;
import cn.forgeeks.awesome.springboot.fastDFS.common.MailBean;
import cn.forgeeks.awesome.springboot.fastDFS.common.MailUtil;
import cn.forgeeks.awesome.springboot.fastDFS.common.MemcachedRunner;
import net.spy.memcached.MemcachedClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class UploadController {
    private static Logger log = LoggerFactory.getLogger(UploadController.class);

    @Autowired
    MemcachedRunner memcachedRunner;

    @Autowired
    MailUtil mailUtil;

    @GetMapping("/")
    public String index() {
        return "upload";
    }


    @Autowired
    private FastDFSClientWrapper fastDFSClientWrapper;


    // 上传图片
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String imgUrl = fastDFSClientWrapper.uploadFile(file);
        String txtUrl = fastDFSClientWrapper.updateFileByContent();
        return imgUrl+"  " + txtUrl;

    }




    @PostMapping("/testmail")
    public void testMail(){
        MailBean mailBean = new MailBean();
        mailBean.setSubject("Have a nice try on the link below.");
        mailBean.setContent("http://fuckqq.com");
        mailBean.setRecipient("forgeekscn@gmail.com");

        mailUtil.sendSimpleMail(mailBean);
        mailUtil.sendAttachmentMail(mailBean);
        mailUtil.sendHTMLMail(mailBean);
        mailUtil.sendInlineMail(mailBean);
        mailUtil.sendTemplateMail(mailBean);

    }

    @PostMapping("/testMemcached")
    public void testMemcached(){
        MemcachedClient memcachedClient = memcachedRunner.getClient();
        memcachedClient.set("testkey", 1000, "666666");
        log.info("***********  [{}]" , memcachedClient.get("testkey").toString());
    }




}