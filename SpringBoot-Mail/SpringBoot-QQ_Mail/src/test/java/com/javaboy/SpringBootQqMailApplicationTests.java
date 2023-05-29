package com.javaboy;

import com.javaboy.pojo.User;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Date;

@SpringBootTest
class SpringBootQqMailApplicationTests {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    void contextLoads() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("shmily.tell@foxmail.com"); // 邮件发送者
        message.setTo("shmily_live@yeah.net"); // 邮件接收者
        // message.setTo(""); // 可设置多个收件人
        // message.setCc("chaosong"); // 抄送
        message.setBcc("shmily_live@outlook.com"); // 指定抄送人，秘密抄送
        message.setSentDate(new Date()); // 发送时间
        message.setSubject("Java-Mail测试"); // 发送主题
        message.setText("java发送邮件测试"); // 发送内容

        javaMailSender.send(message);
    }

    @Test
    void mailTest() throws MessagingException {
        File file = new File("E:\\Software-Cache\\Windows\\Desktop\\mybatis.pdf");

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom("shmily.tell@foxmail.com"); // 邮件发送者
        helper.setTo("shmily_live@yeah.net"); // 邮件接收者
        // helper.setTo(""); // 可设置多个收件人
        // helper.setCc("chaosong"); // 抄送
        helper.setBcc("shmily_live@outlook.com"); // 指定抄送人，秘密抄送
        helper.setSentDate(new Date()); // 发送时间
        helper.setSubject("Java-Mail测试"); // 发送主题
        helper.setText("java发送邮件测试"); // 发送内容
        helper.addAttachment(file.getName(), file);

        javaMailSender.send(message);
    }

    @Test
    void mailTest2() throws MessagingException {
        File file = new File("E:\\Software-Cache\\Windows\\Desktop\\img\\image-20230425111138085.png");

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom("shmily.tell@foxmail.com"); // 邮件发送者
        helper.setTo("shmily_live@yeah.net"); // 邮件接收者
        // helper.setTo(""); // 可设置多个收件人
        // helper.setCc("chaosong"); // 抄送
        helper.setBcc("shmily_live@outlook.com"); // 指定抄送人，秘密抄送
        helper.setSentDate(new Date()); // 发送时间
        helper.setSubject("Java-Mail测试"); // 发送主题
        helper.setText("java发送邮件测试"); // 发送内容
        helper.setText("<div>这是一封内容带图片的邮件。。。</div><div><img src='cid:p01' /></div>", true);
        helper.addInline("p01", file); // 用来存放图片

        javaMailSender.send(message);
    }

    @Test
    void mailFreemarkerTest() throws MessagingException, IOException, TemplateException {

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom("shmily.tell@foxmail.com"); // 邮件发送者
        helper.setTo("shmily_live@yeah.net"); // 邮件接收者
        // helper.setTo(""); // 可设置多个收件人
        // helper.setCc("chaosong"); // 抄送
        helper.setBcc("shmily_live@outlook.com"); // 指定抄送人，秘密抄送
        helper.setSentDate(new Date()); // 发送时间
        helper.setSubject("Java-Mail测试"); // 发送主题
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_30);
        configuration.setClassLoaderForTemplateLoading(SpringBootQqMailApplicationTests.class.getClassLoader(), "mail");
        Template template = configuration.getTemplate("mail.ftl");
        User user = new User();
        user.setUsername("JavaBoy");
        user.setCompany("XXX公司");
        user.setPosition("Java架构师");
        user.setSalary(99999.0);

        StringWriter out = new StringWriter();

        template.process(user, out);
        String text = out.toString();
        helper.setText(text, true);

        System.out.println("text = " + text); // 打印渲染的信息
        javaMailSender.send(message);
    }

    @Test
    void mailThymeleafTest() throws MessagingException {

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom("shmily.tell@foxmail.com"); // 邮件发送者
        helper.setTo("shmily_live@yeah.net"); // 邮件接收者
        // helper.setTo(""); // 可设置多个收件人
        // helper.setCc("chaosong"); // 抄送
        helper.setBcc("shmily_live@outlook.com"); // 指定抄送人，秘密抄送
        helper.setSentDate(new Date()); // 发送时间
        helper.setSubject("Java-Mail测试"); // 发送主题

        Context context = new Context();
        context.setVariable("username", "javaboy");
        context.setVariable("position", "Java工程师");
        context.setVariable("company", "XXX公司");
        context.setVariable("salary", "9000");

        String process = templateEngine.process("mail.html", context);
        helper.setText(process, true);

        System.out.println("text = " + process); // 打印渲染的信息
        javaMailSender.send(message);
    }
}
