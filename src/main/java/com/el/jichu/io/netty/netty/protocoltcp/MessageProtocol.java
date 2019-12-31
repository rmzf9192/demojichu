package com.el.jichu.io.netty.netty.protocoltcp;

/**
 * @author roman zhangfei
 * @Date 2019/12/31 16:57
 * @Version V1.0
 */
//协议包
public class MessageProtocol {
    private int len;
    private byte[] content;

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}