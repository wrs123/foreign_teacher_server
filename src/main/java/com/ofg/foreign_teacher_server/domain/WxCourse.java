package com.ofg.foreign_teacher_server.domain;



import java.io.Serializable;

public class WxCourse{
    private Long id;

    private String name;

    private String description;

    private Integer price;

    private Integer classTime;

    private Integer type;

    private Integer delSign;

    private Long phoneNumber;

    private Long coverId;

    private Long areaId;

    private String openId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getClassTime() {
        return classTime;
    }

    public void setClassTime(Integer classTime) {
        this.classTime = classTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getCoverId() {
        return coverId;
    }

    public void setCoverId(Long coverId) {
        this.coverId = coverId;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append(getClass().getSimpleName());
//        sb.append(" [");
//        sb.append("Hash = ").append(hashCode());
//        sb.append(", id=").append(id);
//        sb.append(", name=").append(name);
//        sb.append(", description=").append(description);
//        sb.append(", price=").append(price);
//        sb.append(", classTime=").append(classTime);
//        sb.append(", type=").append(type);
//        sb.append(", coverId=").append(coverId);
//        sb.append(", areaId=").append(areaId);
//        sb.append(", serialVersionUID=").append(serialVersionUID);
//        sb.append("]");
//        return sb.toString();
//    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getDelSign() {
        return delSign;
    }

    public void setDelSign(Integer delSign) {
        this.delSign = delSign;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }
}