package com.system.design.edu.stackoverflow;
public class Moderator extends Member {
    public boolean closeQuestion(Question question){ return true;}
    public boolean undeleteQuestion(Question question){ return true;}
}
