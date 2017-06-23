package com.ekart.e2e.service.daos.models;

public class Menus {
  private Long menuid;
  private String menuname;
  private String mappingcontent;

  public Long getMenuid() {
    return menuid;
  }

  public void setMenuid(Long menuid) {
    this.menuid = menuid;
  }

  public String getMenuname() {
    return menuname;
  }

  public void setMenuname(String menuname) {
    this.menuname = menuname;
  }

  public String getMappingcontent() {
    return mappingcontent;
  }

  public void setMappingcontent(String mappingcontent) {
    this.mappingcontent = mappingcontent;
  }
}
