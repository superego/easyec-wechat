package com.googlecode.easyec.wechat.test.template;

import com.googlecode.easyec.wechat.template.handler.GetTemplateListRequestHandler;
import com.googlecode.easyec.wechat.template.handler.SendTemplateMessageRequestHandler;
import com.googlecode.easyec.wechat.template.handler.SetIndustryRequestHandler;
import com.googlecode.easyec.wechat.template.model.*;
import com.googlecode.easyec.wechat.test.BaseTest;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by 平功元 on 2016/4/25.
 */
public class WeChatTemplateTest extends BaseTest {

    //设置行业
    @Test
    public void setIndustry() throws Exception {
        SetIndustryEntity se = new SetIndustryEntity();
        se.setCredential(getCredential());
        se.setIndustryId1("1");
        se.setIndustryId2("4");
        handleRequest(
            new SetIndustryRequestHandler(jsonObjectFactory, baseUri, se)
        );
    }


    //获取模板列表
    @Test
    public void getTemplateList() throws Exception {
        GetTemplateListEntity ge = new GetTemplateListEntity();
        ge.setCredential(getCredential());
        GetTemplateListResult result = handleRequest(
            new GetTemplateListRequestHandler(jsonObjectFactory, baseUri, ge)
        );
        Assert.assertNotNull(result);
    }

    //发送消息
    @Test
    public void sendMessage() throws Exception {
        SendTemplateMessage sendTm = new SendTemplateMessage();
        sendTm.setCredential(getCredential());
        sendTm.setToUser("o_oWEv4suB3ANev76hbnRZ1Ukii8");
        sendTm.setTemplateId("eH1P30kyB84eH9QjuJ76-ghMIrnOKLK4cohBdEsx8K8");
        sendTm.setUrl("http://baidu.com");

        sendTm.addValue("first", "恭喜你购买成功！", "#173177");
        sendTm.addValue("keynote1", "巧克力");
        sendTm.addValue("keynote2", "39.8元");
        sendTm.addValue("keynote3", "2016年5月18日");
        sendTm.addValue("remark", "欢迎再次购买!");

        byte[] bs = jsonObjectFactory.writeValue(sendTm);
        System.out.println(new String(bs, "utf-8"));

        TemplateMessageResult result = handleRequest(
            new SendTemplateMessageRequestHandler(jsonObjectFactory, baseUri, sendTm)
        );

        Assert.assertNotNull(result);
        System.out.print(result.getMsgId());
    }
}
