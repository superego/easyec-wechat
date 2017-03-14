package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.googlecode.easyec.wechat.cards.WeChatCardCodeType;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 微信卡券的基础信息类
 *
 * @author JunJie
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(
        ignoreUnknown = true,
        value = {"cardCodeType"}
)
public class WeChatCardBaseInfoImpl extends AbstractWeChatCardBaseInfo {

    /**
     * 表示该卡券为预存code模式卡券，
     * 须导入超过库存数目的自定义code后方可投放，
     * 填入该字段后，quantity字段须为0,须导入code
     * 后再增加库存
     */
    public static final String CUSTOM_CODE_MODE_DEPOSIT = "GET_CUSTOM_CODE_MODE_DEPOSIT";
    private static final long serialVersionUID = -7930262363970151639L;

    @JsonProperty(value = "logo_url", required = true)
    private String logoUrl;                            // 卡券的商户logo
    private WeChatCardCodeType cardCodeType;           // 卡券代码类型
    @JsonProperty(value = "brand_name", required = true)
    private String brandName;                          // 商户名字,字数上限为12个汉字
    @JsonProperty(required = true)
    private String title;                              // 卡券名，字数上限为9个汉字
    @JsonProperty(required = true)
    private String color;                              // 券颜色
    @JsonProperty(required = true)
    private String notice;                             // 卡券使用提醒，字数上限为16个汉字
    @JsonProperty(required = true)
    private String description;                        // 卡券使用说明，字数上限为1024个汉字
    @JsonProperty(required = true)
    private CardSku sku;                               // 商品信息
    @JsonProperty(value = "date_info", required = true)
    private CardDateInfo dateInfo;                     // 使用日期  *

    // ----- 卡券非必填字段
    @JsonProperty("use_custom_code")
    private boolean useCustomCode;                     // 是否自定义Code码
    @JsonProperty("get_custom_code_mode")
    private String customCodeMode;                     // 填入GET_CUSTOM_CODE_MODE_DEPOSIT，表示该卡券为预存code模式卡券  *
    @JsonProperty("bind_openid")
    private boolean bindOpenId;                        // 默认为false。通常指定特殊用户群体
    @JsonProperty("service_phone")
    private String servicePhone;                       // 客服电话
    @JsonProperty("location_id_list")
    private List<Integer> locationIds = new ArrayList<Integer>();     // 门店位置poiid
    @JsonProperty("use_all_locations")
    private boolean useAllLocations;                   // 设置本卡券支持全部门店
    @JsonProperty
    private String source;                             // 第三方来源名，例如同程旅游、大众点评
    @JsonProperty("custom_url_name")
    private String customUrlName;                      // 自定义跳转外链的入口名字
    @JsonProperty("center_title")
    private String centerTitle;                        // 卡券顶部居中的按钮
    @JsonProperty("center_sub_title")
    private String centerSubTitle;                     // 显示在入口下方的提示语
    @JsonProperty("center_url")
    private String centerUrl;                          // 顶部居中的url
    @JsonProperty("custom_url")
    private String customUrl;                          // 自定义跳转的URL
    @JsonProperty("custom_url_sub_title")
    private String customUrlSubTitle;                  // 显示在入口右侧的提示语
    @JsonProperty("promotion_url_name")
    private String promotionUrlName;                   // 营销场景的自定义入口名称
    @JsonProperty("promotion_url")
    private String promotionUrl;                       // 入口跳转外链的地址链接
    @JsonProperty("promotion_url_sub_title")
    private String promotionUrlSubName;                // 显示在营销入口右侧的提示语
    @JsonProperty("get_limit")
    private int getLimit = 50;                         // 每人可领券的数量限制,不填写默认为50
    @JsonProperty("use_limit")
    private int useLimit = 50;                         // 每人可核销的数量限制,不填写默认为50
    @JsonProperty("can_share")
    private Boolean canShare;                          // 卡券领取页面是否可分享
    @JsonProperty("can_give_friend")
    private Boolean canGiveFriend;                     // 卡券是否可转赠

    @JsonProperty(value = "code_type" ,required = true)
    public String getCodeType() {
        return cardCodeType != null ? cardCodeType.getValue() : null;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public WeChatCardCodeType getCardCodeType() {
        return cardCodeType;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getTitle() {
        return title;
    }

    public String getColor() {
        return color;
    }

    public String getNotice() {
        return notice;
    }

    public String getDescription() {
        return description;
    }

    public CardSku getSku() {
        return sku;
    }

    public CardDateInfo getDateInfo() {
        return dateInfo;
    }

    public boolean isUseCustomCode() {
        return useCustomCode;
    }

    public String getCustomCodeMode() {
        return customCodeMode;
    }

    public boolean isBindOpenId() {
        return bindOpenId;
    }

    public String getServicePhone() {
        return servicePhone;
    }

    public List<Integer> getLocationIds() {
        return locationIds;
    }

    public boolean isUseAllLocations() {
        return useAllLocations;
    }

    public String getSource() {
        return source;
    }

    public String getCustomUrlName() {
        return customUrlName;
    }

    public String getCenterTitle() {
        return centerTitle;
    }

    public String getCenterSubTitle() {
        return centerSubTitle;
    }

    public String getCenterUrl() {
        return centerUrl;
    }

    public String getCustomUrl() {
        return customUrl;
    }

    public String getCustomUrlSubTitle() {
        return customUrlSubTitle;
    }

    public String getPromotionUrlName() {
        return promotionUrlName;
    }

    public String getPromotionUrl() {
        return promotionUrl;
    }

    public String getPromotionUrlSubName() {
        return promotionUrlSubName;
    }

    public int getGetLimit() {
        return getLimit;
    }

    public int getUseLimit() {
        return useLimit;
    }

    public Boolean getCanShare() {
        return canShare;
    }

    public Boolean getCanGiveFriend() {
        return canGiveFriend;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public void setCardCodeType(WeChatCardCodeType cardCodeType) {
        this.cardCodeType = cardCodeType;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSku(CardSku sku) {
        this.sku = sku;
    }

    public void setDateInfo(CardDateInfo dateInfo) {
        this.dateInfo = dateInfo;
    }

    public void setUseCustomCode(boolean useCustomCode) {
        this.useCustomCode = useCustomCode;
    }

    public void setCustomCodeMode(String customCodeMode) {
        this.customCodeMode = customCodeMode;
    }

    public void setBindOpenId(boolean bindOpenId) {
        this.bindOpenId = bindOpenId;
    }

    public void setServicePhone(String servicePhone) {
        this.servicePhone = servicePhone;
    }

    public void setLocationIds(List<Integer> locationIds) {
        if (CollectionUtils.isNotEmpty(locationIds)) {
            this.locationIds.addAll(locationIds);
        }
    }

    public void addLocationId(Integer id) {
        if (id != null) this.locationIds.add(id);
    }

    public void setUseAllLocations(boolean useAllLocations) {
        this.useAllLocations = useAllLocations;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setCustomUrlName(String customUrlName) {
        this.customUrlName = customUrlName;
    }

    public void setCenterTitle(String centerTitle) {
        this.centerTitle = centerTitle;
    }

    public void setCenterSubTitle(String centerSubTitle) {
        this.centerSubTitle = centerSubTitle;
    }

    public void setCenterUrl(String centerUrl) {
        this.centerUrl = centerUrl;
    }

    public void setCustomUrl(String customUrl) {
        this.customUrl = customUrl;
    }

    public void setCustomUrlSubTitle(String customUrlSubTitle) {
        this.customUrlSubTitle = customUrlSubTitle;
    }

    public void setPromotionUrlName(String promotionUrlName) {
        this.promotionUrlName = promotionUrlName;
    }

    public void setPromotionUrl(String promotionUrl) {
        this.promotionUrl = promotionUrl;
    }

    public void setPromotionUrlSubName(String promotionUrlSubName) {
        this.promotionUrlSubName = promotionUrlSubName;
    }

    public void setGetLimit(int getLimit) {
        this.getLimit = getLimit;
    }

    public void setUseLimit(int useLimit) {
        this.useLimit = useLimit;
    }

    public void setCanShare(Boolean canShare) {
        this.canShare = canShare;
    }

    public void setCanGiveFriend(Boolean canGiveFriend) {
        this.canGiveFriend = canGiveFriend;
    }
}
