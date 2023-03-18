import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wxt.Application;
import com.wxt.entity.Message;
import com.wxt.entity.Todayeat;
import com.wxt.mapper.MessageMapper;
import com.wxt.mapper.TodayeatMapper;
import com.wxt.service.MessageService;
import com.wxt.service.impl.MessageServiceImpl;
import com.wxt.tool.MakeNeko;
import com.wxt.tool.Send_To_minio;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@SpringBootTest(classes = Application.class)
public class up {
    @Autowired
    private Send_To_minio send_to_minio;
    @Autowired
    private MessageServiceImpl service;
    @Autowired
    private MessageMapper mapper;

    @Autowired
    private TodayeatMapper todayeatMapper;

    @Test
    public void uptodayeat()  {
        QueryWrapper<Todayeat> objectQueryWrapper = new QueryWrapper<>();
        List<Todayeat> messages = todayeatMapper.selectList(objectQueryWrapper);

        for (Todayeat message :  messages) {
            try {
            String message1 = message.getMessage();

            String pattern = "https?://[^\\s]+";
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(message1);
            String[] split = message1.split("\\[");
            String messagetext= split[0];
            String image ="";
            if(m.find()){
                String group = m.group();
                image = group.replaceAll("]", "");
            }
                String newpicture = send_to_minio.Send_ToMinio_Picture_new(image);
                Todayeat todayeat = new Todayeat();
                todayeat.setId(message.getId());
                todayeat.setQq(message.getQq());
                todayeat.setMessage(messagetext+MakeNeko.MakePicture(newpicture));
                todayeatMapper.updateById(todayeat);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


    @Test
    public void upmessage()  {
        QueryWrapper<Message> objectQueryWrapper = new QueryWrapper<>();
        List<Message> messages = mapper.selectList(objectQueryWrapper);
        for (Message message :  messages) {
            String valuemessage = message.getValuemessage();
            String url = message.getUrl();
              if (url!=null&&!url.isEmpty()){
                  Message re= new Message();
                  String newurl = null;
                  try {
                      newurl = send_to_minio.Send_ToMinio_Picture_new(url);
                      re.setUrl(newurl);
                      re.setKeymessage(message.getKeymessage());
                      re.setId(message.getId());
                      re.setQq(message.getQq());
                      re.setValuemessage(MakeNeko.MakePicture(newurl));
                      mapper.updateById(re);
                  } catch (IOException e) {
                      e.printStackTrace();
                  }

              }

        }

    }
}
