package com.neo.entity;

import java.io.Serializable;

public class AtmRet implements Serializable {

    public AtmRet() {
    }

    String fileId = "Iamsorry";

    Atm file;

    public Atm getFile() {
        return file;
    }

    public void setFile(Atm file) {
        this.file = file;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }


}
