package com.bc.model.vo;

public class NoticeReplyVO {
   private int rep_num;
   private int not_num;
   private int member_num;
   private String rep_content;
   private String rep_date;
   private String name;
   
   public NoticeReplyVO() {
   }

   public int getRep_num() {
      return rep_num;
   }

   public void setRep_num(int rep_num) {
      this.rep_num = rep_num;
   }

   public int getNot_num() {
      return not_num;
   }

   public void setNot_num(int not_num) {
      this.not_num = not_num;
   }

   public int getMember_num() {
      return member_num;
   }

   public void setMember_num(int member_num) {
      this.member_num = member_num;
   }

   public String getRep_content() {
      return rep_content;
   }

   public void setRep_content(String rep_content) {
      this.rep_content = rep_content;
   }

   public String getRep_date() {
      return rep_date;
   }

   public void setRep_date(String rep_date) {
      this.rep_date = rep_date;
   }
   
   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   @Override
   public String toString() {
      return "NoticeReplyVO [rep_num=" + rep_num + ", not_num=" + not_num + ", member_num=" + member_num
            + ", rep_content=" + rep_content + ", rep_date=" + rep_date + ", name=" + name + "]";
   }

   
}