package com.lewis.base.entity;

import java.io.Serializable;

public class Flow implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column flow.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column flow.uid
     *
     * @mbg.generated
     */
    private Integer uid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column flow.sname
     *
     * @mbg.generated
     */
    private String sname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column flow.saddress
     *
     * @mbg.generated
     */
    private String saddress;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column flow.sphone
     *
     * @mbg.generated
     */
    private String sphone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column flow.gname
     *
     * @mbg.generated
     */
    private String gname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column flow.gaddress
     *
     * @mbg.generated
     */
    private String gaddress;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column flow.gphone
     *
     * @mbg.generated
     */
    private String gphone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column flow.status
     *
     * @mbg.generated
     */
    private String status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column flow.ordernum
     *
     * @mbg.generated
     */
    private String ordernum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table flow
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column flow.id
     *
     * @return the value of flow.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column flow.id
     *
     * @param id the value for flow.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column flow.uid
     *
     * @return the value of flow.uid
     *
     * @mbg.generated
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column flow.uid
     *
     * @param uid the value for flow.uid
     *
     * @mbg.generated
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column flow.sname
     *
     * @return the value of flow.sname
     *
     * @mbg.generated
     */
    public String getSname() {
        return sname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column flow.sname
     *
     * @param sname the value for flow.sname
     *
     * @mbg.generated
     */
    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column flow.saddress
     *
     * @return the value of flow.saddress
     *
     * @mbg.generated
     */
    public String getSaddress() {
        return saddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column flow.saddress
     *
     * @param saddress the value for flow.saddress
     *
     * @mbg.generated
     */
    public void setSaddress(String saddress) {
        this.saddress = saddress == null ? null : saddress.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column flow.sphone
     *
     * @return the value of flow.sphone
     *
     * @mbg.generated
     */
    public String getSphone() {
        return sphone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column flow.sphone
     *
     * @param sphone the value for flow.sphone
     *
     * @mbg.generated
     */
    public void setSphone(String sphone) {
        this.sphone = sphone == null ? null : sphone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column flow.gname
     *
     * @return the value of flow.gname
     *
     * @mbg.generated
     */
    public String getGname() {
        return gname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column flow.gname
     *
     * @param gname the value for flow.gname
     *
     * @mbg.generated
     */
    public void setGname(String gname) {
        this.gname = gname == null ? null : gname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column flow.gaddress
     *
     * @return the value of flow.gaddress
     *
     * @mbg.generated
     */
    public String getGaddress() {
        return gaddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column flow.gaddress
     *
     * @param gaddress the value for flow.gaddress
     *
     * @mbg.generated
     */
    public void setGaddress(String gaddress) {
        this.gaddress = gaddress == null ? null : gaddress.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column flow.gphone
     *
     * @return the value of flow.gphone
     *
     * @mbg.generated
     */
    public String getGphone() {
        return gphone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column flow.gphone
     *
     * @param gphone the value for flow.gphone
     *
     * @mbg.generated
     */
    public void setGphone(String gphone) {
        this.gphone = gphone == null ? null : gphone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column flow.status
     *
     * @return the value of flow.status
     *
     * @mbg.generated
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column flow.status
     *
     * @param status the value for flow.status
     *
     * @mbg.generated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column flow.ordernum
     *
     * @return the value of flow.ordernum
     *
     * @mbg.generated
     */
    public String getOrdernum() {
        return ordernum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column flow.ordernum
     *
     * @param ordernum the value for flow.ordernum
     *
     * @mbg.generated
     */
    public void setOrdernum(String ordernum) {
        this.ordernum = ordernum == null ? null : ordernum.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table flow
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", uid=").append(uid);
        sb.append(", sname=").append(sname);
        sb.append(", saddress=").append(saddress);
        sb.append(", sphone=").append(sphone);
        sb.append(", gname=").append(gname);
        sb.append(", gaddress=").append(gaddress);
        sb.append(", gphone=").append(gphone);
        sb.append(", status=").append(status);
        sb.append(", ordernum=").append(ordernum);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}