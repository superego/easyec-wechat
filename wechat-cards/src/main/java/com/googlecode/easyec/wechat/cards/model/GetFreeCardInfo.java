package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.googlecode.easyec.wechat.base.model.AbstractCredentialCtrl;

/**
 * 获取免费券数据接口
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(
        ignoreUnknown = true,
        value = "credential"
)
public class GetFreeCardInfo extends AbstractCredentialCtrl {

    @JsonProperty(value = "begin_date", required = true)
    private String beginDate;                              //查询数据的起始时间  2017-01-01 必须按照此样式

    @JsonProperty(value = "end_date", required = true)
    private String endDate;                                 //查询数据的截至时间 2017-01-01 必须按照此样式

    @JsonProperty(value = "cond_source", required = true)
    private int condSource;                                 //卡券来源，0为公众平台创建的卡券数据、1是API创建的卡券数据

    @JsonProperty(value = "card_id")
    private String cardId;                                  //卡券ID。填写后，指定拉出该卡券的相关数据


    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getCondSource() {
        return condSource;
    }

    public void setCondSource(int condSource) {
        this.condSource = condSource;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }
}
